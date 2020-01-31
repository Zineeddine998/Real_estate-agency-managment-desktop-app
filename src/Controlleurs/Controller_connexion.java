package Controlleurs;



import Noyau.Bien;
import Noyau.Proprietaire;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Controller_connexion {
    @FXML
    Button button_connexion_admin;
    @FXML
    PasswordField passwordAdmin;
    @FXML
    Pane mdpincorrecte;
    @FXML
    TextField User;
    @FXML
    PasswordField  passwordClient;
    @FXML
    Button button_connexion_client;
    @FXML
    Button nvBoutton;
    @FXML
    TextField nvUser;
    @FXML
    PasswordField nvPassword;
    @FXML
    Pane nv;


    static ArrayList<Proprietaire> ProprietaireArrayList = new ArrayList<Proprietaire> ();


    public void connexion_admin() throws IOException {
        String mdp = passwordAdmin.getText();
        if (mdp.equals("admin")) {
            Stage stage = new Stage();
            button_connexion_admin.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/menu_admin.fxml"));
            stage.setTitle("Menu de l'administrateur");
            stage.setScene(new Scene(root, 1050, 576));
            stage.show();
            Stage stage_2 = (Stage) button_connexion_admin.getScene().getWindow();
            stage_2.close();
        }
        else mdpincorrecte.toBack();
    }


    public void connexion_client() throws IOException {
        TreeSet<Bien> b = new TreeSet<Bien>();
        Proprietaire prop1 = new Proprietaire ("Boutaleb", "Allaa", "allaabtb@gmail.com", "0776539155", "06 rue des freres taleb Saida",b);
        Proprietaire prop2 = new Proprietaire ("Zidane", "Zineeddine", "zidanezineeddine@gmail.com", "0548654521", "n04 Draria Algier", b);
        Proprietaire prop3 = new Proprietaire ("Senouci", "Karima", "karisenouci@outlook.com", "0775417020", "5 juillet n03 Oran", b);
        Proprietaire prop4 = new Proprietaire ("Amari", "Amine", "amariamine@hotmail.com", "0551516145", "batiment A n12 cartier El Badr, Bejaia", b);


        ProprietaireArrayList.add (prop1);
        ProprietaireArrayList.add (prop2);
        ProprietaireArrayList.add (prop3);
        ProprietaireArrayList.add (prop4);
        int check=0;
        String user = User.getText();
        Controller_client.username = user;
        String mdp_client =  passwordClient.getText();


        for (int i = 0; i < ProprietaireArrayList.size(); i++) {
            System.out.println(ProprietaireArrayList.get(i).getAdresse_mail());
            if(ProprietaireArrayList.get(i).getAdresse_mail().equals(user)) {
                check=1;
                break;
            }
        }

        if (check==1) {
            Stage stage = new Stage();
            button_connexion_client.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            //Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/menu_client.fxml"));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/menu_client.fxml"));
            Controller_client scene2 = loader.getController();

           // scene2.transferMessage(user);
            Parent root = loader.load();
            stage.setTitle("Menu Client");
            //scene2.transferMessage(user);
            stage.setScene(new Scene(root, 1050, 576));
            stage.show();
            Stage stage_2 = (Stage) button_connexion_client.getScene().getWindow();
            stage_2.close();
        }
        else mdpincorrecte.toBack();
    }


    public void connexion_nvclient() throws IOException {

        String user = nvUser.getText();
        String mdp_client =  nvPassword.getText();
        TreeSet<Bien> b = new TreeSet<Bien>();
        Proprietaire nv_user = new Proprietaire("default","default",nvUser.getText(),"default","default",b);

        ProprietaireArrayList.add(nv_user);

        Stage stage = new Stage();
        nvBoutton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
       // Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/menu_client.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/menu_client.fxml"));
        Controller_client scene2 = loader.getController();


        Parent root = loader.load();

      //  scene2.transferMessage(user);
        stage.setTitle("Menu Client");
        stage.setScene(new Scene(root, 1050, 576));
        stage.show();
        Stage stage_2 = (Stage) nvBoutton.getScene().getWindow();
        stage_2.close();
    }



}
