package Controlleurs;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {
    Button admin_login;
    Button client_login;
    Button creer_compte;


    public void cliquer_admin() throws Exception {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/adminlogin.fxml"));
        primaryStage.setTitle("Portail Administrateur");
        primaryStage.setScene(new Scene(root, 367, 545));
        primaryStage.show();
    }

    public void cliquer_client() throws Exception {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/clientlogin.fxml"));
        primaryStage.setTitle("Portail Client");
        primaryStage.setScene(new Scene(root, 367, 545));
        primaryStage.show();
    }

    public void cliquer_nv_compte() throws Exception {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/creercompte.fxml"));
        primaryStage.setTitle("Création d'un nouveau compte");
        primaryStage.setScene(new Scene(root, 367, 421));
        primaryStage.show();
    }
}