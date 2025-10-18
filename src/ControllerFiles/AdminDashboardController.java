package ControllerFiles;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

import Application.*;
import Database.*;

public class AdminDashboardController {

    @FXML private TextField regNo;
    @FXML private TextField nameField;
    @FXML private TextField attendanceField;
    @FXML private TextField phoneField;
    @FXML private TextField address;
    @FXML private TextField age;

    UpdateStudentDetails updateStudent = new UpdateStudentDetails();
    UpdateTeacherDetails updateTeacher = new UpdateTeacherDetails();

    @FXML
    private void onUpdateStudentDetails() throws SQLException {
        updateStudent.updateStudentDetails(getId(), getName(), getPhone(), getAddress(), getAge());
    }

    public String getId() { return  regNo.getText(); }
    public String getName(){return nameField.getText();}
    public String getAttendance(){return attendanceField.getText();}
    public String getPhone(){return phoneField.getText();}
    public String getAddress(){return address.getText();}
    public String getAge(){return age.getText();}



    @FXML private TextField teachId;
    @FXML private TextField nameFieldTeach;
    @FXML private TextField subjectField;
    @FXML private TextField scoreField;
    @FXML private TextField contactField;
    @FXML private TextArea feedbackArea;

    @FXML
    private void onUpdateTeacherDetails() throws SQLException {
        //Set DataBase Things
        updateTeacher.updateTeacherDetails(getTeacherId(), getNameTeacher(), getSubjectTeacher(), getContactTeacher());
    }


    public String getTeacherId(){return teachId.getText();}
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
