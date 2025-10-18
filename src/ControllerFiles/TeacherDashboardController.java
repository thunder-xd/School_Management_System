package ControllerFiles;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

import Application.*;

public class TeacherDashboardController {

    @FXML private Label nameLabel;
    @FXML private Label contactLabel;
    @FXML private Label subjectLabel;
    @FXML private Label scoreLabel;
    @FXML private TextArea feedbackArea;

    @FXML
    private void onViewProfile(String name, String contact, String subject, double score, String feedback) {
        nameLabel.setText(name);
        contactLabel.setText(contact);
        subjectLabel.setText(subject);
        scoreLabel.setText(score+" /10");
        feedbackArea.setText(feedback);
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




    @FXML private Label currentAttendanceLabel;

    @FXML private ToggleGroup attendanceGroup;
    @FXML private RadioButton presentRadio;
    @FXML private RadioButton absentRadio;

    public String getSelectedAttendance() {
        Toggle selectedToggle = attendanceGroup.getSelectedToggle();

        if (selectedToggle.equals(presentRadio)) {
            return "Present";
        } else if (selectedToggle.equals(absentRadio)) {
            return "Absent";
        }
        return "No selection";
    }

    @FXML
    private void onUpdateAttendance() {
        //Getter to get the current lable
        double attendance = 0.0;
        currentAttendanceLabel.setText("Current Attendance: " + attendance);
        //Set selected attendance (getSelectedAttendance())


    }



    @FXML
    private void onLogout() throws IOException {
        MainApplication.showLoginView();
    }
}
