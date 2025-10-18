package ControllerFiles;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.IOException;
import Application.*;

public class GuestController {

    @FXML
    private void onViewAdmissionInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Admission Information");
        alert.setHeaderText(null);
        alert.setContentText("Admission info and process details can be shown here.");
        alert.showAndWait();
    }

    @FXML
    private void onLogout() throws IOException {
        MainApplication.showLoginView();
    }
}
