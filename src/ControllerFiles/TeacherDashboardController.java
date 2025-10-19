package ControllerFiles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Application.*;
import Database.*;

public class TeacherDashboardController {

    @FXML private Label nameLabel;
    @FXML private Label contactLabel;
    @FXML private Label subjectLabel;
    @FXML private Label scoreLabel;
    @FXML private TextArea feedbackArea;

    UpdateTeacherDetails updateTeacherDetails = new UpdateTeacherDetails();
    LoginController loginController = new LoginController();


    @FXML
    private void onViewProfile() {
        String name = updateTeacherDetails.getName(loginController.getId());
        String subject = updateTeacherDetails.getSubject(loginController.getId());
        String contact = updateTeacherDetails.getContact(loginController.getId());

        nameLabel.setText(name);
        contactLabel.setText(contact);
        subjectLabel.setText(subject);
        //scoreLabel.setText(score+" /10");
        //feedbackArea.setText(feedback);
    }




    @FXML private Label prevMarks1;
    @FXML private Label prevMarks2;
    @FXML private Label prevMarks3;
    @FXML private TextField currentMarks1;
    @FXML private TextField currentMarks2;
    @FXML private TextField currentMarks3;

    @FXML
    private void onUpdateMarks() {
        //Get prev marks for 1 2 and 3
        double marks1 = 89;
        double marks2 = 89;
        double marks3 = 89;

        prevMarks1.setText(marks1+"/100");
        prevMarks2.setText(marks2+"/100");
        prevMarks3.setText(marks3+"/100");
    }
    public double getMarks1(){
        return Double.parseDouble(currentMarks1.getText());
    }
    public double getMarks2(){
        return Double.parseDouble(currentMarks2.getText());
    }
    public double getMarks3(){
        return Double.parseDouble(currentMarks3.getText());
    }




    UpdateAttendance updateAttendance = new UpdateAttendance();

    @FXML private TextField studentIdField;
    @FXML private Label currentAttendanceLabel;

    @FXML private Button subject1PresentButton;
    @FXML private Button subject1AbsentButton;
    @FXML private Button subject2PresentButton;
    @FXML private Button subject2AbsentButton;
    @FXML private Button subject3PresentButton;
    @FXML private Button subject3AbsentButton;

    private final Map<String, Boolean> subjectAttendance = new HashMap<>();

    @FXML
    public void initialize() {
        subjectAttendance.put("Subject 1", null);
        subjectAttendance.put("Subject 2", null);
        subjectAttendance.put("Subject 3", null);
    }

    @FXML
    public void onSubject1Selected(ActionEvent event) {
        boolean isPresent = ((Button) event.getSource()).getId().contains("Present");
        subjectAttendance.put("Subject 1", isPresent);
        updateButtonStyles(subject1PresentButton, subject1AbsentButton, isPresent);
    }

    @FXML
    public void onSubject2Selected(ActionEvent event) {
        boolean isPresent = ((Button) event.getSource()).getId().contains("Present");
        subjectAttendance.put("Subject 2", isPresent);
        updateButtonStyles(subject2PresentButton, subject2AbsentButton, isPresent);
    }

    @FXML
    public void onSubject3Selected(ActionEvent event) {
        boolean isPresent = ((Button) event.getSource()).getId().contains("Present");
        subjectAttendance.put("Subject 3", isPresent);
        updateButtonStyles(subject3PresentButton, subject3AbsentButton, isPresent);
    }

    private void updateButtonStyles(Button presentBtn, Button absentBtn, boolean isPresent) {

        presentBtn.getStyleClass().remove("selected-attendance-button");
        absentBtn.getStyleClass().remove("selected-attendance-button");

        if (isPresent) {
            presentBtn.getStyleClass().add("selected-attendance-button");
        } else {
            absentBtn.getStyleClass().add("selected-attendance-button");
        }
    }

    @FXML
    private void onUpdateAttendance() {
        String studentId = studentIdField.getText().trim();

        if (studentId.isEmpty()) {
            currentAttendanceLabel.setText("Error: Please enter a Student ID.");
            return;
        }

        if (subjectAttendance.containsValue(null)) {
            currentAttendanceLabel.setText("Error: Please mark attendance for all three subjects.");
            return;
        }

        System.out.println("Committing Attendance for Student ID: " + studentId);
        System.out.println("Subject 1: " + (subjectAttendance.get("Subject 1") ? "Present" : "Absent"));
        System.out.println("Subject 2: " + (subjectAttendance.get("Subject 2") ? "Present" : "Absent"));
        System.out.println("Subject 3: " + (subjectAttendance.get("Subject 3") ? "Present" : "Absent"));

        int presentCount = 0;
        for (Boolean isPresent : subjectAttendance.values()) {
            if (isPresent != null && isPresent) {
                presentCount++;
            }
        }
        double totalSubjects = subjectAttendance.size();
        double attendancePercentage = (presentCount / totalSubjects) * 100.0;

        currentAttendanceLabel.setText(String.format("Attendance Committed! Student %s. Present in %d/3 classes (%.1f%%).",
                studentId, presentCount, attendancePercentage));
    }



    @FXML
    private void onLogout() throws IOException {
        MainApplication.showLoginView();
    }

}
