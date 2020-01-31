package Controlleurs;


import Noyau.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;


public class Controller_client implements Initializable {
    public static String username;
    @FXML
    private AnchorPane menu_client;

    @FXML
    private Pane message_interface;
    @FXML
    private Pane vide;
    @FXML
    private Pane listes_messages_interface;

    @FXML
    private TextField description;

    @FXML
    private ListView<String> listViewmsg;
    ObservableList list = FXCollections.observableArrayList();


    @FXML private Button Liste_des_biens;

    @FXML private Button Rechercher_bien;

    @FXML private Button envoyer_message,envoyer_msg;
    @FXML private Pane message_panel;


    @FXML
    private Button Messages,envoyer,Quitter,recherche;
    @FXML private RadioButton offre, autre,annone;
    @FXML private TextArea texte;

    @FXML private Label nbr_dispo;

    @FXML private Button plus_de_details_final;

    @FXML private Pane plus_de_details_panel,plus_de_details_panel1,plus_de_details_panel2,Rechercher_bien_panel,Liste_des_bien_panel;
    @FXML private TableColumn ttype_de_bien,ttype_de_transaction,tprix,twilaya,tdate;
    @FXML private Label type_de_transaction_1,adresse_1,wilaya_1,prop_1,prix_1,prix_final_1,superficie_1,nbr_etages_1,nbr_pieces_1;@FXML private ImageView image_apartement;
    @FXML private Label type_de_transaction_2,adresse_2,wilaya_2,prop_2,prix_2,prix_final_2,superficie_2,nbr_facades;@FXML private ImageView image_terrain;@FXML private Button statut_juridique;
    @FXML private Label type_de_transaction_,adresse_,wilaya_,prop_,prix_,prix_final_,superficie_,nbr_etages_,nbr_pieces_;@FXML private ImageView image_maison;
    @FXML private ImageView negociable_maison,fixe_maison,garage_dispo_maison,garage_non_dispo_maison,jardin_dispo_maison,jardin_non_dispo_maison,piscine_dispo_maison,piscine_non_dispo_maison,meuble_dispo_maison,meuble_non_dispo_maison;
    @FXML private ImageView nego_a,fixe_a,simplexe_dispo_a,duplexe_dispo_a,ascenseur_dispo_a,ascenseur_non_dispo_a,meuble_dispo_a,meuble_non_dispo_a;
    @FXML private ImageView nego_t,fixe_t;
    @FXML private CheckBox check_prix_min,check_prix_max,check_sup_min,check_sup_max,check_wilaya,check_transaction,check_type;
    @FXML private TextField prix_min,prix_max,sup_min,sup_max; @FXML private MenuButton wilayaa,typee,transactionn;
    @FXML private TableColumn c_type,c_prix,c_transaction,c_wilaya,c_superficie;
    @FXML private MenuItem wilaya11,wilaya22,wilaya33,ventee,echangee,locationn,maisonn,apartementt,terrainn;




    private String filtre_de_wilaya;
    private String filtre_de_transaction;
    private String filtre_de_type;



    @FXML private TableView<Bien> tableau_des_biens,tableau_filtres;

    @FXML private Button lancer_rech;

    @FXML private TextField message;

    /*  public void load_list(ActionEvent actionEvent){


          if (actionEvent.getSource() == recherche) {

          listViewmsg.getItems().addAll(user_tab);
          }


      }*/

    public void handleClicks(ActionEvent actionEvent) {
          if (actionEvent.getSource() == Liste_des_biens) {

              plus_de_details_panel.toBack();
              plus_de_details_panel1.toBack();
              plus_de_details_panel2.toBack();
              Liste_des_bien_panel.toFront();
              nbr_dispo.setText(String.valueOf(Controller_admin.tout_les_biens.size()));

              //Affichage
              tableau_des_biens.getItems().clear();
              Iterator<Bien> iterator = Controller_admin.tout_les_biens.iterator();

              while(iterator.hasNext())
              {
                  tableau_des_biens.getItems().add(iterator.next());

              }

          }


        if (actionEvent.getSource() == envoyer_message) {
            message_panel.toFront();
            Liste_des_bien_panel.toBack();
            Rechercher_bien_panel.toBack();
        }

        if (actionEvent.getSource() == Rechercher_bien)
        {
            Liste_des_biens.toBack();
            message_panel.toBack();
            Rechercher_bien_panel.toFront();
        }

        if (actionEvent.getSource() ==recherche ) {
            listes_messages_interface.toFront();
        }

        if(actionEvent.getSource()==Quitter)
        {
            Stage stage = (Stage) Quitter.getScene().getWindow();
            // do what you have to do
            stage.close();
        }
    }


    @FXML
    public void plus_de_details (ActionEvent actionEvent) {
        Bien bien_selectione;
        bien_selectione = (Bien) tableau_des_biens.getSelectionModel().getSelectedItem();
        if (bien_selectione.getNomClasse() == "Maison") {

            Liste_des_bien_panel.toFront();
            plus_de_details_panel1.toBack();
            plus_de_details_panel2.toBack();
            plus_de_details_panel.toFront();


            type_de_transaction_.setText(String.valueOf(bien_selectione.getTransaction()));
            adresse_.setText(String.valueOf(bien_selectione.getAdresse()));
            wilaya_.setText(String.valueOf(bien_selectione.getWilaya()));
            prop_.setText(bien_selectione.getProprietaire().getNom() + " " + bien_selectione.getProprietaire().getPrenom());
            if (type_de_transaction_.getText().equals("VENTE")) {
                prix_final_.setText(bien_selectione.calculer_prix_vente_final(bien_selectione.getWilaya()) + " DZD");
            }
            if (type_de_transaction_.getText().equals("LOCATION")) {
                prix_final_.setText(bien_selectione.calculer_prix_location_final(bien_selectione.getWilaya()) + " DZD");
            }
            prix_.setText(bien_selectione.getPrix() + " DZD");
            superficie_.setText(bien_selectione.getSuperficie() + " m^2");
            nbr_etages_.setText(String.valueOf(bien_selectione.getNbr_etages()));
            nbr_pieces_.setText(String.valueOf(bien_selectione.getNbr_pieces()));


            if (bien_selectione.isGarage()) {
                garage_dispo_maison.toFront();
            } else garage_non_dispo_maison.toFront();
            if (bien_selectione.isPiscine()) {
                piscine_dispo_maison.toFront();
            } else piscine_non_dispo_maison.toFront();
            if (bien_selectione.isJardin()) {
                jardin_dispo_maison.toFront();
            } else jardin_non_dispo_maison.toFront();
            if (bien_selectione.isMeuble()) {
                meuble_dispo_maison.toFront();
            } else meuble_non_dispo_maison.toFront();
            if (bien_selectione.isFixe()) {
                fixe_maison.toFront();
                negociable_maison.toBack();
            } else {negociable_maison.toFront();fixe_maison.toBack();}

            Maison ms = (Maison) bien_selectione;
            File imageFile = new File(ms.getImage());
            String fileLocation = imageFile.toURI().toString();
            Image fxImage = new Image(fileLocation);
            image_maison.setImage(fxImage);
        }

        if (bien_selectione.getNomClasse() == "Apartement") {
            Liste_des_bien_panel.toFront();
            plus_de_details_panel.toBack();
            plus_de_details_panel2.toBack();
            plus_de_details_panel1.toFront();
            Apartement app = (Apartement) bien_selectione;
            type_de_transaction_1.setText(String.valueOf(app.getTransaction()));
            adresse_1.setText(String.valueOf(app.getAdresse()));
            wilaya_1.setText(String.valueOf(app.getWilaya()));
            prop_1.setText(app.getProprietaire().getNom() + " " + app.getProprietaire().getPrenom());
            if (type_de_transaction_1.getText().equals("VENTE")) {
                prix_final_1.setText(app.calculer_prix_vente_final(app.getWilaya()) + " DZD");
            }
            if (type_de_transaction_1.getText().equals("LOCATION")) {
                prix_final_1.setText(app.calculer_prix_location_final(app.getWilaya()) + " DZD");
            }
            prix_1.setText(bien_selectione.getPrix() + " DZD");
            superficie_1.setText(app.getSuperficie() + " m^2");
            nbr_etages_1.setText(String.valueOf(app.getEtage()));
            nbr_pieces_1.setText(String.valueOf(app.getNbr_pieces()));

            if(app.isSimplexe_Duplexe()) {simplexe_dispo_a.toFront();} else {duplexe_dispo_a.toFront();}
            if(app.isAscenseur()) {ascenseur_dispo_a.toFront();} else {ascenseur_non_dispo_a.toFront();}
            if(app.isMeuble()) {meuble_dispo_a.toFront();} else {meuble_non_dispo_a.toFront();}
            if(app.isFixe()) {fixe_a.toFront();nego_a.toBack();} else {nego_a.toFront();fixe_a.toBack();}

            File imageFile = new File(app.getImage());
            String fileLocation = imageFile.toURI().toString();
            Image fxImage = new Image(fileLocation);
            image_apartement.setImage(fxImage);
        }

        if (bien_selectione.getNomClasse() == "Terrain") {
            Bien_non_habitable tr = (Bien_non_habitable) bien_selectione;
            Liste_des_bien_panel.toFront();
            plus_de_details_panel.toBack();
            plus_de_details_panel1.toBack();
            plus_de_details_panel2.toFront();
            type_de_transaction_2.setText(String.valueOf(tr.getTransaction()));
            adresse_2.setText(String.valueOf(tr.getAdresse()));
            wilaya_2.setText(String.valueOf(tr.getWilaya()));
            prop_2.setText(tr.getProprietaire().getNom() + " " + tr.getProprietaire().getPrenom());
            if (type_de_transaction_2.getText().equals("VENTE")) {
                prix_final_2.setText(tr.calculer_prix_vente_final(tr.getWilaya()) + " DZD");
            }
            if (type_de_transaction_2.getText().equals("LOCATION")) {
                prix_final_2.setText(tr.calculer_prix_location_final(tr.getWilaya()) + " DZD");
            }
            prix_2.setText(bien_selectione.getPrix() + " DZD");
            superficie_2.setText(tr.getSuperficie() + " m^2");
            nbr_facades.setText(String.valueOf(tr.getNbr_facades()));

            File imageFile = new File(tr.getImage());
            String fileLocation = imageFile.toURI().toString();
            Image fxImage = new Image(fileLocation);
            image_terrain.setImage(fxImage);

            statut_juridique.setOnAction(actionEvent1 -> {
                if(Desktop.isDesktopSupported()) {
                    try {
                        File file = new File(tr.getStatus_juridique());
                        Desktop.getDesktop().open(file);
                    } catch (IOException ex) {
                        // no application registered for PDFs
                    }
                }
            });
            if(tr.isFixe()) {fixe_t.toFront(); nego_t.toBack();} else {nego_t.toFront(); fixe_t.toBack();}
            if(tr.isFixe()) {fixe_t.toFront(); nego_t.toBack();} else {nego_t.toFront(); fixe_t.toBack();}

        }
    }


    @FXML
    public void envoyer_msg(ActionEvent actionEvent) {
          if (actionEvent.getSource() == envoyer_msg)
          {
                String msg = message.getText();
                String usr = username;
                Noyau.messages nv_message = new Noyau.messages(usr,msg);
                msgs.add(nv_message);
                System.out.println(nv_message);
          }
    }


    /*public void envoyer_message(ActionEvent actionEvent){
       if( actionEvent.getSource() == envoyer){
        if(texte.getText().equals(null))
        {

        }else{
            String msg = texte.getText();

            msg_tab.add(msg);
            user_tab.add(username)  ;
            i++;

        }

        System.out.println(msg_tab.get(i));
           System.out.println(user_tab.get(i));


      }
    }*/

    public void rechercher (ActionEvent actionEvent) {

        if(actionEvent.getSource() == lancer_rech) {
            ArrayList<Bien> biens = new ArrayList<Bien>(Controller_admin.tout_les_biens);
            Bien b;

            if (check_prix_max.isSelected()) {
                double prixmax = Double.parseDouble(prix_max.getText());
                Iterator<Bien> it1 = biens.iterator();
                while (it1.hasNext()) {
                    b = it1.next();
                    if (b.getPrix() > prixmax) {
                        it1.remove();
                    }
                }
            }


            if (check_prix_min.isSelected()) {
                double prixmin = Double.parseDouble(prix_min.getText());
                Iterator<Bien> it2 = biens.iterator();
                while (it2.hasNext()) {
                    b = it2.next();
                    if (b.getPrix() < prixmin) {
                        it2.remove();
                    }
                }
            }

            if (check_sup_min.isSelected()) {
                double supmin = Double.parseDouble(sup_min.getText());
                Iterator<Bien> it3 = biens.iterator();
                while (it3.hasNext()) {
                    b = it3.next();
                    if (b.getSuperficie() < supmin) {
                        it3.remove();
                    }
                }
            }

            if (check_sup_max.isSelected()) {
                double supmax = Double.parseDouble(sup_max.getText());
                Iterator<Bien> it4 = biens.iterator();
                while (it4.hasNext()) {
                    b = it4.next();
                    if (b.getSuperficie() > supmax) {
                        it4.remove();
                    }
                }
            }

            if (check_transaction.isSelected()) {
                {
                    Iterator<Bien> it5 = biens.iterator();
                    while (it5.hasNext()) {
                        b = it5.next();
                        if (String.valueOf(b.getTransaction()) != (filtre_de_transaction)) {
                            it5.remove();
                        }
                    }
                }
            }

            if (check_type.isSelected()) {
                {
                    Iterator<Bien> it6 = biens.iterator();
                    while (it6.hasNext()) {
                        b = it6.next();
                        if (String.valueOf(b.getNomClasse()) != (filtre_de_type)) {
                            it6.remove();
                        }
                    }
                }
            }
            if (check_wilaya.isSelected()) {
                {
                    Iterator<Bien> it7 = biens.iterator();
                    while (it7.hasNext()) {
                        b = it7.next();
                        if (String.valueOf(b.getWilaya()) != (filtre_de_wilaya)) {
                            it7.remove();
                        }
                    }
                }
            }

            //affichage
            tableau_filtres.getItems().clear();
            Iterator<Bien> it8 = biens.iterator();
            while (it8.hasNext()) {
                tableau_filtres.getItems().add(it8.next());
            }

        }
    }

    public static ArrayList<messages> msgs = new ArrayList<messages>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ttype_de_bien.setCellValueFactory(new PropertyValueFactory<Bien,String>("nomClasse"));
        tprix.setCellValueFactory(new PropertyValueFactory<Bien, String>("prix"));
        tdate.setCellValueFactory(new PropertyValueFactory<Bien,String>("date"));
        twilaya.setCellValueFactory(new PropertyValueFactory<Bien, String>("wilaya"));
        ttype_de_transaction.setCellValueFactory(new PropertyValueFactory<Bien, String>("transaction"));

        c_type.setCellValueFactory(new PropertyValueFactory<Bien,String>("nomClasse"));
        c_prix.setCellValueFactory(new PropertyValueFactory<Bien, String>("prix"));
        c_superficie.setCellValueFactory(new PropertyValueFactory<Bien,String>("superficie"));
        c_wilaya.setCellValueFactory(new PropertyValueFactory<Bien, String>("wilaya"));
        c_transaction.setCellValueFactory(new PropertyValueFactory<Bien, String>("transaction"));

        //filtre
        wilaya11.setOnAction(e -> {wilayaa.setText("Wilaya 1"); filtre_de_wilaya ="Wilaya1";});ventee.setOnAction(e-> {transactionn.setText("Vente");filtre_de_transaction=("VENTE");});
        wilaya22.setOnAction(e -> {wilayaa.setText("Wilaya 2"); filtre_de_wilaya ="Wilaya2";});locationn.setOnAction(e-> {transactionn.setText("Location");filtre_de_transaction=("LOCATION");});
        wilaya33.setOnAction(e -> {wilayaa.setText("Wilaya 3"); filtre_de_wilaya ="Wilaya3";});echangee.setOnAction(e-> {transactionn.setText("Echange");filtre_de_transaction=("ECHANGE");});


    }

    /*
    public void display(javafx.scene.input.MouseEvent mouseEvent) {
        String element = listViewmsg.getSelectionModel().getSelectedItem();
        int h =user_tab.indexOf(element);
        if((element!=null)&&(!element.isEmpty())){
            description.setText(msg_tab.get(h));
        }
    }

     */
}
