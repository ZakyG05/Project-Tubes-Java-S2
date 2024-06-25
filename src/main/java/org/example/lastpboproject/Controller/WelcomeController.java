package org.example.lastpboproject.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.lastpboproject.Main;

public class WelcomeController {

    public Button backButton;
    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    public void initialize() {
        loginButton.setOnAction(event -> {
            try {
                Main.showLoginView();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        registerButton.setOnAction(event -> {
            try {
                Main.showRegisterView();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}