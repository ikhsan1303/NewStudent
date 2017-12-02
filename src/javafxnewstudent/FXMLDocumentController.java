/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnewstudent;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ikhsan
 */
    public class FXMLDocumentController implements Initializable {

            @FXML
        void next(ActionEvent event) throws IOException {
            // Hide this current window (if this is what you want)
                ((Node)(event.getSource())).getScene().getWindow().hide();

                // Load the new fxml
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLDaftar.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 637, 553);

                // Create new stage (window), then set the new Scene
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("New Student");
                stage.show();
                stage.setResizable(false);
        }

        @FXML
        private JFXTextField username;

        @FXML
        private JFXPasswordField password;

        @FXML
        void login(ActionEvent event) throws IOException {
            if(username.getText().equals("admin") && password.getText().equals("admin")){
                // Hide this current window (if this is what you want)
                ((Node)(event.getSource())).getScene().getWindow().hide();

                // Load the new fxml
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLAdmin.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 805, 661);

                // Create new stage (window), then set the new Scene
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("New Student");
                stage.show();
                stage.setResizable(false);
            }

        }

        /**
         * Initializes the controller class.
         */
        @Override
        public void initialize(URL url, ResourceBundle rb) {
            // TODO
        }    



    }
