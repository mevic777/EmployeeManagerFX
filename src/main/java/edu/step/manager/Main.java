package edu.step.manager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane container = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));

        stage.setScene(new Scene(container));
        stage.setTitle("Employee Application v.0.1");
        stage.show();
    }
}
