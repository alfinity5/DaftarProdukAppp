package kelas;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Navigator.setStage(primaryStage);
        Navigator.showDaftar();
    }

    public static void main(String[] args) {
        launch(args);
    }
}