package ControllerFiles;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import Database.*;
import Application.*;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private ChoiceBox<String> roleChoiceBox;
    @FXML private Label messageLabel;

    ControlLogin controlLogin = new ControlLogin();

    @FXML
    private void initialize() {
        roleChoiceBox.getItems().addAll("student", "teacher", "admin", "guest");
        roleChoiceBox.setValue("student");
    }

    public String getId(){ return usernameField.getText(); }
    public String getPasswd(){ return passwordField.getText(); }
    public String getChoice() {return  roleChoiceBox.getValue(); }


    @FXML
    private void onLoginButtonClick() throws IOException {

        boolean authenticated = controlLogin.checkUserPassword(getId(), getPasswd(), getChoice());

        if(authenticated) {
            if(getChoice().equals("student")) {
                MainApplication.showStudentDashboard();
            }
            else if(getChoice().equals("teacher")) {
                MainApplication.showTeacherDashboard();
            }
            else if(getChoice().equals("admin")) {
                MainApplication.showAdminDashboard();
            }
            else {
                MainApplication.showGuestView();
            }
        }

    }

}
