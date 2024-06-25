package org.example.lastpboproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        primaryStage.setTitle("UMM Library");

        showWelcomeView();
    }

    public static void showWelcomeView() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/welcome.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showLoginView() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/login.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showRegisterView() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/register.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}