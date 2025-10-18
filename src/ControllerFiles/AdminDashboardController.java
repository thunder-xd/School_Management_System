package ControllerFiles;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

import Application.*;

public class AdminDashboardController {

    @FXML private TextField nameField;
    @FXML private TextField marksField;
    @FXML private TextField attendanceField;
    @FXML private TextField phoneField;

    @FXML
    private void onUpdateStudentDetails() {
        //Set the database things
    }

    public String getName(){return nameField.getText();}
    public String getMarks(){return marksField.getText();}
    public String getAttendance(){return attendanceField.getText();}
    public String getPhone(){return phoneField.getText();}



    @FXML private TextField nameFieldTeach;
    @FXML private TextField subjectField;
    @FXML private TextField scoreField;
    @FXML private TextField contactField;
    @FXML private TextArea feedbackArea;

    @FXML
    private void onUpdateTeacherDetails() {
        //Set DataBase Things
    }

    public String getNameTeacher(){return nameFieldTeach.getText();}
    public String getSubjectTeacher(){return subjectField.getText();}
    public String getScoreTeacher(){return scoreField.getText();}
    public String getContactTeacher(){return contactField.getText();}
    public String getFeedback(){return feedbackArea.getText();}



    @FXML
    private void onLogout() throws IOException {
        MainApplication.showLoginView();
    }
}
