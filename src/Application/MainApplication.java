package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        showLoginView();
    }

    public static void setScene(Parent root, String title) {
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void showLoginView() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/FXMLfiles/LoginView.fxml"));
        Parent root = loader.load();
        setScene(root, "School Management System - Login");
    }

    public static void showStudentDashboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/FXMLfiles/StudentDashboardView.fxml"));
        Parent root = loader.load();
        setScene(root, "Student Dashboard");
    }

    public static void showTeacherDashboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/FXMLfiles/TeacherDashboardView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();  // Create a new stage, not the primary one
        Scene scene = new Scene(root, 900, 600);  // Set width=900, height=600
        stage.setScene(scene);
        stage.setTitle("Teacher Dashboard");
        stage.show();
    }


    public static void showAdminDashboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/FXMLfiles/AdminDashboardView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.setTitle("Admin Dashboard");
        stage.show();
    }

    public static void showGuestView() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/FXMLfiles/GuestView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.setTitle("Guest Access");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
