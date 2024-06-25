package org.example.lastpboproject.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.lastpboproject.Main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginController {
    @FXML
    private TextField nimInput;
    @FXML
    private TextField passwordInput;
    @FXML
    private Button loginButton;
    @FXML
    private Button backButton;

    @FXML
    public void initialize() {
        loginButton.setOnAction(event -> {
            String nim = nimInput.getText();
            String password = passwordInput.getText();
            String result = loginMember(Integer.parseInt(nim), password);
            System.out.println(result);
        });

        backButton.setOnAction(event -> {
            try {
                Main.showWelcomeView();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private String loginMember(long nim, String password) {
        try {
            URL url = new URL("https://your-remote-api-endpoint.com/api/login"); // replace with your remote API endpoint
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            String params = "nim=" + nim + "&password=" + password;
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(params);
            outputStream.flush();
            outputStream.close();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return "Login berhasil.";
            } else {
                return "Login gagal. Response Code: " + responseCode;
            }
        } catch (IOException e) {
            return "Login gagal. Error: " + e.getMessage();
        }
    }
}