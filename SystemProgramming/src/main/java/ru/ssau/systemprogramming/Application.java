package ru.ssau.systemprogramming;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/mainWindow.fxml"));

        primaryStage.setTitle("SPO");
        primaryStage.setScene(new Scene(root, 640, 600));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
