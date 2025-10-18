package ControllerFiles;

import javafx.fxml.FXML;

import java.io.IOException;
import Application.*;

public class StudentDashboardController {

    @FXML
    private void handleLogout() throws IOException {
        MainApplication.showLoginView();
    }
}

//cow sex 99