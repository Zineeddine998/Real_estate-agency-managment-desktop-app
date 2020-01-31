package Controlleurs;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import com.sun.glass.ui.CommonDialogs;
import com.sun.source.tree.Tree;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;

import Noyau.*;

import javax.swing.*;

public class Controller_admin implements Initializable {
    @FXML private AnchorPane menu_admin;

    //Les options du menu admin et leurs panels
    @FXML private Button Liste_des_biens,Messages,Liste_des_clients,Modifier_bien,Quitter,Ajouter_bien,Rechercher_bien;
    @FXML private Pane Liste_des_bien_panel,Rechercher_bien_panel;
    @FXML private Pane messages_panel;
    @FXML private Pane Liste_des_clients_panel;
    @FXML private Pane Ajouter_bien_panel;
    @FXML private Label nbr_dispo,nbr_archi,nbr_sup;
    @FXML private TableView<messages> table_messages;


    @FXML private Button lancer_rech;

    @FXML private TableView tableau_des_biens,tableau_filtres; @FXML private TableColumn ttype_de_bien,ttype_de_transaction,tprix,twilaya,tdate;
    @FXML private TableView tableau_des_biens_a; @FXML private TableColumn ttype_de_bien_a,ttype_de_transaction_a,tprix_a,twilaya_a,tdate_a;
    @FXML private TableView tableau_des_biens4; @FXML private TableColumn ttype_de_bien1,ttype_de_transaction1,tprix1,twilaya1,tdate1;

    @FXML private TableColumn c_type,c_prix,c_transaction,c_wilaya,c_superficie,c_prop;

    @FXML private CheckBox check_prix_min,check_prix_max,check_sup_min,check_sup_max,check_wilaya,check_transaction,check_type,check_prop;
    @FXML private TextField prix_min,prix_max,sup_min,sup_max; @FXML private MenuButton wilayaa,typee,transactionn,propp;
    @FXML private MenuItem wilaya11,wilaya22,wilaya33,ventee,echangee,locationn,maisonn,apartementt,terrainn,prop_1_,prop_2_,prop_3_;
    @FXML private ImageView negociable_maison,fixe_maison,garage_dispo_maison,garage_non_dispo_maison,jardin_dispo_maison,jardin_non_dispo_maison,piscine_dispo_maison,piscine_non_dispo_maison,meuble_dispo_maison,meuble_non_dispo_maison;
    @FXML private ImageView nego_a,fixe_a,simplexe_dispo_a,duplexe_dispo_a,ascenseur_dispo_a,ascenseur_non_dispo_a,meuble_dispo_a,meuble_non_dispo_a;
    @FXML private ImageView nego_t,fixe_t;

    @FXML private Pane plus_de_details_panel,plus_de_details_panel1,plus_de_details_panel2;
    @FXML private Label type_de_transaction_,adresse_,wilaya_,prop_,prix_,prix_final_,superficie_,nbr_etages_,nbr_pieces_;@FXML private ImageView image_maison;
    @FXML private Label type_de_transaction_1,adresse_1,wilaya_1,prop_1,prix_1,prix_final_1,superficie_1,nbr_etages_1,nbr_pieces_1;@FXML private ImageView image_apartement;
    @FXML private Label type_de_transaction_2,adresse_2,wilaya_2,prop_2,prix_2,prix_final_2,superficie_2,nbr_facades;@FXML private ImageView image_terrain;@FXML private Button statut_juridique;


    @FXML private Button plus_de_details_final,archiver_final,supprimer_final;
    @FXML private Button archiver, Restaurer; @FXML private Pane biens_archives_liste;
    private Bien clone; private String x; private String  type_de_clone; private String type_initial;
    @FXML private Label infos_sans_details;
    @FXML private Button confirmer_modif_apartement;

    @FXML private TableColumn username,messagee;


    //les buttons de navigation dans le menu d'ajout
    @FXML
    private Button ajouter_maison,annuler_maison,ajouter_apartement,annuler_apartement,ajouter_terrain,annuler_terrain;
    @FXML
    private Label erreur_ajout,success_ajout,erreur_ajout_apartement,success_ajout_apartement,erreur_ajout_terrain,success_ajout_terrain;
    private LocalDateTime date;
    //les fields de chaque type de bien
    //Maison
    @FXML private MenuButton Typedetransaction_maison,Wilaya_maison,Proprietaire_maison;
    @FXML private MenuItem Vente_maison,Echange_maison,Location_maison,Wilaya1_maison,Wilaya2_maison,Wilaya3_maison,Prop1_maison,Prop2_maison,Prop3_maison;
    @FXML private TextField Adresse_maison,Superficie_maison,Prix_maison,nbr_etages_maison,nbr_pieces_maison;
    @FXML private Button ajouter_image_maison,Maison;
    @FXML private Pane menu_Maison;
    @FXML private RadioButton Sans_Garage_maison,Avec_Garage_maison,Sans_Piscine_maison,Avec_Piscine_maison,Sans_Jardin_maison,Avec_Jardin_maison,Sans_Meubles_maison,Avec_Meubles_maison,Prix_Fixe_maison,Prix_Negotiable_maison;
    @FXML private ToggleGroup groupe_m_1 = new ToggleGroup();
    @FXML private ToggleGroup groupe_m_2 = new ToggleGroup();
    @FXML private ToggleGroup groupe_m_3 = new ToggleGroup();
    @FXML private ToggleGroup groupe_m_4 = new ToggleGroup();
    @FXML private ToggleGroup groupe_m_5 = new ToggleGroup();

    //Apartement
    @FXML private MenuButton Typedetransaction_apartement,Wilaya_apartement,Proprietaire_apartement;
    @FXML private MenuItem Vente_apartement,Echange_apartement,Location_apartement,Wilaya1_apartement,Wilaya2_apartement,Wilaya3_apartement,Prop1_apartement,Prop2_apartement,Prop3_apartement;
    @FXML private TextField Adresse_apartement,Superficie_apartement,Prix_apartement,numero_etage_apartement,nbr_pieces_apartement;
    @FXML private Button ajouter_image_apartement,Apartement;
    @FXML private Pane menu_Apartement;
    @FXML private RadioButton Simplexe_apartement,Duplexe_apartement,Sans_Ascenseur_apartement,Avec_Ascenseur_apartement,Sans_Meubles_apartement,Avec_Meubles_apartement,Prix_Fixe_apartement,Prix_Negotiable_apartement;
    @FXML private ToggleGroup groupe_a_1 = new ToggleGroup();
    @FXML private ToggleGroup groupe_a_2 = new ToggleGroup();
    @FXML private ToggleGroup groupe_a_3 = new ToggleGroup();
    @FXML private ToggleGroup groupe_a_4 = new ToggleGroup();

    //Terrain
    @FXML private MenuButton Typedetransaction_terrain,Wilaya_terrain,Proprietaire_terrain;
    @FXML private MenuItem Vente_terrain,Echange_terrain,Location_terrain,Wilaya1_terrain,Wilaya2_terrain,Wilaya3_terrain,Prop1_terrain,Prop2_terrain,Prop3_terrain;
    @FXML private TextField Adresse_terrain,Superficie_terrain,Prix_terrain,Nbr_Facades_terrain;
    @FXML private Button ajouter_image_terrain,ajouter_statut_terrain,Terrain;
    @FXML private Pane menu_Terrain;
    @FXML private RadioButton Prix_Fixe_terrain, Prix_Negotiable_terrain;
    @FXML private ToggleGroup groupe_t_1 = new ToggleGroup();
    @FXML private Button confirmer_modif_maison,modif_apartement,modif_terrain;


    private String type_de_transaction = "null";
    private String num_de_wilaya = "null";
    private int num_de_prop = 0;

    private String filtre_de_wilaya;
    private String filtre_de_transaction;
    private String filtre_de_type;
    private String filtre_de_prop;

    private static int bien_supprime=0;

    @FXML private Pane Modifier_bien_panel;

    public Controller_admin() throws IOException {
    }

    //methode de choix de l'option du menu admin
    @FXML public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == Liste_des_biens) {

            plus_de_details_panel.toBack();
            plus_de_details_panel1.toBack();
            plus_de_details_panel2.toBack();
            Rechercher_bien_panel.toBack();
            messages_panel.toBack();
            biens_archives_liste.toBack();
            Liste_des_bien_panel.toFront();

            nbr_dispo.setText(String.valueOf(tout_les_biens.size()));

            //Affichage
            tableau_des_biens.getItems().clear();
            Iterator<Bien> iterator = tout_les_biens.iterator();

            while(iterator.hasNext())
            {
                tableau_des_biens.getItems().add(iterator.next());

            }

        }

        if (actionEvent.getSource() == Messages) {
            Liste_des_bien_panel.toBack();
            Ajouter_bien_panel.toBack();
            Modifier_bien_panel.toBack();
            Rechercher_bien_panel.toBack();
            messages_panel.toFront();


            table_messages.getItems().clear();
            Iterator<messages> it = Controller_client.msgs.iterator();

            while (it.hasNext()) { table_messages.getItems().add(it.next());}

        }

        if (actionEvent.getSource() == Rechercher_bien) {

            Liste_des_bien_panel.toBack();
            Ajouter_bien_panel.toBack();
            Modifier_bien_panel.toBack();
            messages_panel.toBack();
            Rechercher_bien_panel.toFront();

        }
        if(actionEvent.getSource()==Modifier_bien)
        {
            Liste_des_bien_panel.toBack();
            Ajouter_bien_panel.toBack();
            Modifier_bien_panel.toFront();

            //Affichage
            tableau_des_biens4.getItems().clear();
            Iterator<Bien> iterator = tout_les_biens.iterator();

            while(iterator.hasNext())
            {
                tableau_des_biens4.getItems().add(iterator.next());

            }

        }
        if(actionEvent.getSource()==Ajouter_bien)
        {
            Rechercher_bien_panel.toBack();
            messages_panel.toBack();
            menu_Maison.toBack();
            menu_Apartement.toBack();
            menu_Terrain.toBack();
            confirmer_modif_maison.toBack();
            modif_apartement.toBack();
            modif_terrain.toBack();
            Modifier_bien_panel.toBack();
            Liste_des_bien_panel.toBack();
            Ajouter_bien_panel.toFront();

            //clear maison fields
            Typedetransaction_maison.setText("Type de transaction");Typedetransaction_maison.setTextFill(Color.web("#FFFFFF"));
            Adresse_maison.setText(null);
            Superficie_maison.setText(null);
            Prix_maison.setText(null);
            Avec_Garage_maison.setSelected(false);Sans_Garage_maison.setSelected(false);
            Avec_Piscine_maison.setSelected(false);Sans_Piscine_maison.setSelected(false);

            Wilaya_maison.setText("Wilaya");Wilaya_maison.setTextFill(Color.web("#FFFFFF"));
            Avec_Jardin_maison.setSelected(false);Sans_Jardin_maison.setSelected(false);

            nbr_etages_maison.setText(null);
            nbr_pieces_maison.setText(null);
            Avec_Meubles_maison.setSelected(false);Sans_Meubles_maison.setSelected(false);

            Prix_Fixe_maison.setSelected(false);
            Prix_Negotiable_maison.setSelected(false);
            Proprietaire_maison.setText("Proprietaire");Proprietaire_maison.setTextFill(Color.web("#FFFFFF"));
            ajouter_image_maison.setText("Ajouter une image");
            erreur_ajout.toBack();
            success_ajout.toBack();

            //clear apartement fields
            Typedetransaction_apartement.setText("Type de transaction");Typedetransaction_apartement.setTextFill(Color.web("#FFFFFF"));
            Adresse_apartement.setText(null);
            Superficie_apartement.setText(null);
            Prix_apartement.setText(null);
            Avec_Ascenseur_apartement.setSelected(false);Sans_Ascenseur_apartement.setSelected(false);
            Simplexe_apartement.setSelected(false);Duplexe_apartement.setSelected(false);

            Wilaya_apartement.setText("Wilaya");Wilaya_apartement.setTextFill(Color.web("#FFFFFF"));
            numero_etage_apartement.setText(null);
            nbr_pieces_apartement.setText(null);
            Avec_Meubles_apartement.setSelected(false);Sans_Meubles_apartement.setSelected(false);
            Prix_Fixe_apartement.setSelected(false);Prix_Negotiable_apartement.setSelected(false);

            Proprietaire_apartement.setText("Proprietaire");Proprietaire_apartement.setTextFill(Color.web("#FFFFFF"));
            ajouter_image_apartement.setText("Ajouter une image");ajouter_image_apartement.setTextFill(Color.web("#FFFFFF"));
            erreur_ajout_apartement.toBack();
            success_ajout_apartement.toBack();

            //clear terrain fields
            Typedetransaction_terrain.setText("Type de transaction");Typedetransaction_terrain.setTextFill(Color.web("#FFFFFF"));
            Adresse_terrain.setText(null);
            Superficie_terrain.setText(null);
            Prix_terrain.setText(null);
            Wilaya_terrain.setText("Wilaya");Wilaya_terrain.setTextFill(Color.web("#FFFFFF"));
            Nbr_Facades_terrain.setText(null);
            Prix_Fixe_terrain.setSelected(false);Prix_Negotiable_terrain.setSelected(false);
            Proprietaire_terrain.setText("Proprietaire");Proprietaire_terrain.setTextFill(Color.web("FFFFFF"));
            ajouter_image_terrain.setText("Ajouter une image");ajouter_image_terrain.setTextFill(Color.web("#FFFFFF"));
            ajouter_statut_terrain.setText("Statut Juridique");ajouter_statut_terrain.setTextFill(Color.web("#FFFFFF"));
            erreur_ajout_terrain.toBack();
            success_ajout_terrain.toBack();

        }
        if(actionEvent.getSource()==Quitter)
        {
            Stage stage = (Stage) Quitter.getScene().getWindow();
            // do what you have to do
            stage.close();
        }
    }

    //methode du choix de type de bien a ajouter
    @FXML public void AjouterClick(ActionEvent actionEvent) {
        if (actionEvent.getSource() == Maison) {
            menu_Maison.toFront();
        }
        if (actionEvent.getSource() == Apartement) {
            menu_Apartement.toFront();
        }
        if (actionEvent.getSource() == Terrain) {
            menu_Terrain.toFront();
        }
    }

    //les image loaders de chaque type de bien
    @FXML public void image_loader_maison(ActionEvent actionEvent) {
        FileChooser filechooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichiers JPG", "*.jpg");
        filechooser.getExtensionFilters().add(extFilter);
        filechooser.setTitle("Ajouter l'image du bien");
        Stage stage = (Stage) menu_Maison.getScene().getWindow();
        File file = filechooser.showOpenDialog(stage);

        if (file != null) {
            ajouter_image_maison.setText(file.getAbsolutePath());
        }
    }
    @FXML public void image_loader_apartement(ActionEvent actionEvent) {
        FileChooser filechooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichiers JPG", "*.jpg");
        filechooser.getExtensionFilters().add(extFilter);
        filechooser.setTitle("Ajouter l'image du bien");
        Stage stage = (Stage) menu_Apartement.getScene().getWindow();
        File file = filechooser.showOpenDialog(stage);

        if (file != null) {
            ajouter_image_apartement.setText(file.getAbsolutePath());
        }
    }
    @FXML public void image_loader_terrain(ActionEvent actionEvent) {
        FileChooser filechooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichiers JPG", "*.jpg");
        filechooser.getExtensionFilters().add(extFilter);
        filechooser.setTitle("Ajouter l'image du bien");
        Stage stage = (Stage) menu_Terrain.getScene().getWindow();
        File file = filechooser.showOpenDialog(stage);

        if (file != null) {
            ajouter_image_terrain.setText(file.getAbsolutePath());
        }
    }
    @FXML public void statut_juridique_loader(ActionEvent actionEvent) {
        FileChooser filechooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichiers PDF", "*.pdf");
        filechooser.getExtensionFilters().add(extFilter);
        filechooser.setTitle("Ajouter le statut juridique");
        Stage stage = (Stage) menu_Terrain.getScene().getWindow();
        File file = filechooser.showOpenDialog(stage);

        if (file != null) {
            ajouter_statut_terrain.setText(file.getAbsolutePath());
        }
    }


    @FXML
    public void Archiver(ActionEvent actionEvent) {
        Bien bien_selectione;
        bien_selectione = (Bien) tableau_des_biens.getSelectionModel().getSelectedItem();
        biens_archives.add(bien_selectione);
        tout_les_biens.remove(bien_selectione);
        nbr_archi.setText(String.valueOf(biens_archives.size()));
        nbr_dispo.setText(String.valueOf(tout_les_biens.size()));



        //Affichage
        tableau_des_biens.getItems().clear();
        Iterator<Bien> iterator = tout_les_biens.iterator();

        while(iterator.hasNext())
        {
            tableau_des_biens.getItems().add(iterator.next());

        }
    }

    @FXML
    public void Supprimer(ActionEvent actionEvent) {
        Bien bien_selectione;
        bien_selectione = (Bien) tableau_des_biens.getSelectionModel().getSelectedItem();
        bien_supprime++;
        nbr_sup.setText(String.valueOf(bien_supprime));
        tout_les_biens.remove(bien_selectione);
        nbr_dispo.setText(String.valueOf(tout_les_biens.size()));

        //Affichage
        tableau_des_biens.getItems().clear();
        Iterator<Bien> iterator = tout_les_biens.iterator();

        while(iterator.hasNext())
        {
            tableau_des_biens.getItems().add(iterator.next());

        }
    }

    @FXML
    public void navigation(ActionEvent actionEvent) {
        if (actionEvent.getSource() == annuler_maison || actionEvent.getSource() == annuler_apartement || actionEvent.getSource() == annuler_terrain) {
            if (actionEvent.getSource() == annuler_maison)
            {
                menu_Maison.toBack();
                menu_Apartement.toBack();
                menu_Terrain.toBack();
                Ajouter_bien_panel.toFront();

                Typedetransaction_maison.setText("Type de transaction");Typedetransaction_maison.setTextFill(Color.web("#FFFFFF"));
                Adresse_maison.setText(null);
                Superficie_maison.setText(null);
                Prix_maison.setText(null);
                Avec_Garage_maison.setSelected(false);Sans_Garage_maison.setSelected(false);
                Avec_Piscine_maison.setSelected(false);Sans_Piscine_maison.setSelected(false);

                Wilaya_maison.setText("Wilaya");Wilaya_maison.setTextFill(Color.web("#FFFFFF"));
                Avec_Jardin_maison.setSelected(false);Sans_Jardin_maison.setSelected(false);

                nbr_etages_maison.setText(null);
                nbr_pieces_maison.setText(null);
                Avec_Meubles_maison.setSelected(false);Sans_Meubles_maison.setSelected(false);

                Prix_Fixe_maison.setSelected(false);
                Prix_Negotiable_maison.setSelected(false);
                Proprietaire_maison.setText("Proprietaire");Proprietaire_maison.setTextFill(Color.web("#FFFFFF"));
                ajouter_image_maison.setText("Ajouter une image");
                erreur_ajout.toBack();
                success_ajout.toBack();
            } else
                if (actionEvent.getSource() == annuler_apartement) {
                    menu_Maison.toBack();
                    menu_Apartement.toBack();
                    menu_Terrain.toBack();
                    Ajouter_bien_panel.toFront();

                    Typedetransaction_apartement.setText("Type de transaction");Typedetransaction_apartement.setTextFill(Color.web("#FFFFFF"));
                    Adresse_apartement.setText(null);
                    Superficie_apartement.setText(null);
                    Prix_apartement.setText(null);
                    Avec_Ascenseur_apartement.setSelected(false);Sans_Ascenseur_apartement.setSelected(false);
                    Simplexe_apartement.setSelected(false);Duplexe_apartement.setSelected(false);

                    Wilaya_apartement.setText("Wilaya");Wilaya_apartement.setTextFill(Color.web("#FFFFFF"));
                    numero_etage_apartement.setText(null);
                    nbr_pieces_apartement.setText(null);
                    Avec_Meubles_apartement.setSelected(false);Sans_Meubles_apartement.setSelected(false);
                    Prix_Fixe_apartement.setSelected(false);Prix_Negotiable_apartement.setSelected(false);

                    Proprietaire_apartement.setText("Proprietaire");Proprietaire_apartement.setTextFill(Color.web("#FFFFFF"));
                    ajouter_image_apartement.setText("Ajouter une image");ajouter_image_apartement.setTextFill(Color.web("#FFFFFF"));

                    erreur_ajout_apartement.toBack();
                    success_ajout_apartement.toBack();
                } else
                    if (actionEvent.getSource() == annuler_terrain) {
                        menu_Terrain.toBack();
                        menu_Apartement.toBack();
                        menu_Maison.toBack();
                        Ajouter_bien_panel.toFront();

                        Typedetransaction_terrain.setText("Type de transaction");Typedetransaction_terrain.setTextFill(Color.web("#FFFFFF"));
                        Adresse_terrain.setText(null);
                        Superficie_terrain.setText(null);
                        Prix_terrain.setText(null);
                        Wilaya_terrain.setText("Wilaya");Wilaya_terrain.setTextFill(Color.web("#FFFFFF"));
                        Nbr_Facades_terrain.setText(null);
                        Prix_Fixe_terrain.setSelected(false);Prix_Negotiable_terrain.setSelected(false);
                        Proprietaire_terrain.setText("Proprietaire");Proprietaire_terrain.setTextFill(Color.web("FFFFFF"));
                        ajouter_image_terrain.setText("Ajouter une image");ajouter_image_terrain.setTextFill(Color.web("#FFFFFF"));
                        ajouter_statut_terrain.setText("Statut Juridique");ajouter_statut_terrain.setTextFill(Color.web("#FFFFFF"));
                        erreur_ajout_terrain.toBack();
                        success_ajout_terrain.toBack();

                    }
        }
        else
            if (actionEvent.getSource() == ajouter_maison || actionEvent.getSource() == ajouter_apartement || actionEvent.getSource() == ajouter_terrain)
            {
                if (actionEvent.getSource() == ajouter_maison)
                {
                    if(Adresse_maison.getText().equals(null) || type_de_transaction.equals("null") || Prix_maison.getText().equals(null) || num_de_prop == 0 || num_de_wilaya.equals("null") || Superficie_maison.getText().equals(null) || ((Avec_Garage_maison.isSelected() == false) && (Sans_Garage_maison.isSelected() == false)) || ((Avec_Piscine_maison.isSelected() == false) && (Sans_Piscine_maison.isSelected() == false)) || ((Avec_Jardin_maison.isSelected() == false) && (Sans_Jardin_maison.isSelected() == false)) || ((Avec_Meubles_maison.isSelected() == false) && (Sans_Meubles_maison.isSelected() == false)) || nbr_etages_maison.getText().equals(null) || nbr_pieces_maison.getText().equals(null) || ((Prix_Fixe_maison.isSelected() == false) && (Prix_Negotiable_maison.isSelected() == false)))
                    {
                        erreur_ajout.toFront();
                    }
                    else {
                        date = LocalDateTime.now();
                        String type = "Maison";
                        Maison nv_maison = new Maison(Adresse_maison.getText(), Bien.Transaction.valueOf(type_de_transaction), Double.parseDouble(Prix_maison.getText()), proprietaire[num_de_prop-1], Bien.Wilaya_.valueOf(num_de_wilaya), Double.parseDouble(Superficie_maison.getText()), date, Avec_Garage_maison.isSelected(), Avec_Piscine_maison.isSelected(), Avec_Jardin_maison.isSelected(), Integer.parseInt(nbr_etages_maison.getText()), Integer.parseInt(nbr_pieces_maison.getText()), Avec_Meubles_maison.isSelected(), Prix_Fixe_maison.isSelected(), ajouter_image_maison.getText(),type);
                    tout_les_biens.add(nv_maison);
                    erreur_ajout.toBack();
                    success_ajout.toFront();

                     }
                  }

                if (actionEvent.getSource() == ajouter_apartement) {
                    if(Adresse_apartement.getText().equals(null) || type_de_transaction.equals("null") || Prix_apartement.getText().equals(null) || num_de_prop == 0|| num_de_wilaya.equals("null") || Superficie_apartement.getText().equals(null) || ((Avec_Ascenseur_apartement.isSelected() == false) && (Sans_Ascenseur_apartement.isSelected() == false)) || ((Avec_Meubles_apartement.isSelected() == false) && (Sans_Meubles_apartement.isSelected() == false)) ||  nbr_pieces_apartement.getText().equals(null) || numero_etage_apartement.getText().equals(null) || ((Prix_Fixe_apartement.isSelected() == false) && (Prix_Negotiable_apartement.isSelected() == false)) || ((Simplexe_apartement.isSelected() == false) && (Duplexe_apartement.isSelected() == false)))
                    {
                        erreur_ajout_apartement.toFront();
                    }
                    else {
                        LocalDateTime date = LocalDateTime.now();
                        String type = "Apartement";
                        Apartement nv_apartement = new Apartement(Adresse_apartement.getText(), Bien.Transaction.valueOf(type_de_transaction), Double.parseDouble(Prix_apartement.getText()), proprietaire[num_de_prop-1], Bien.Wilaya_.valueOf(num_de_wilaya), Double.parseDouble(Superficie_apartement.getText()), date, Integer.parseInt(numero_etage_apartement.getText()), Integer.parseInt(nbr_pieces_apartement.getText()), Simplexe_apartement.isSelected(), Avec_Ascenseur_apartement.isSelected(), Avec_Meubles_apartement.isSelected(), Prix_Fixe_apartement.isSelected(), ajouter_image_apartement.getText(),type);
                        tout_les_biens.add(nv_apartement);
                        erreur_ajout_apartement.toBack();
                        success_ajout_apartement.toFront();
                    }
                }
                if (actionEvent.getSource() == ajouter_terrain) {
                    if(Adresse_terrain.getText().equals(null) || type_de_transaction.equals("null") || Prix_terrain.getText().equals(null) || num_de_prop == 0 || num_de_wilaya.equals("null") || Superficie_terrain.getText().equals(null) || Nbr_Facades_terrain.getText().equals(null) || ajouter_statut_terrain.getText().equals("Statut Juridique"))
                    {
                        erreur_ajout_terrain.toFront();
                    }
                    else {
                        LocalDateTime date = LocalDateTime.now();
                        String type = "Terrain";
                        Bien_non_habitable terrain_nv = new Bien_non_habitable(Adresse_terrain.getText(),Bien.Transaction.valueOf(type_de_transaction),Double.parseDouble(Prix_terrain.getText()),proprietaire[num_de_prop-1],Bien.Wilaya_.valueOf(num_de_wilaya),Double.parseDouble(Superficie_terrain.getText()),date,Integer.parseInt(Nbr_Facades_terrain.getText()),ajouter_statut_terrain.getText(),type, ajouter_image_terrain.getText(),Prix_Fixe_terrain.isSelected());
                        tout_les_biens.add(terrain_nv);
                        erreur_ajout_terrain.toBack();
                        success_ajout_terrain.toFront();
                    }
                }
            }

        Iterator<Bien> iterator = tout_les_biens.iterator();
            while(iterator.hasNext())
            {
                iterator.next().afficher();
            }


    }

    @FXML
    public void afficher_archive (ActionEvent actionEvent) {
        Liste_des_bien_panel.toFront();
        plus_de_details_panel.toBack();
        plus_de_details_panel1.toBack();
        plus_de_details_panel2.toBack();
        biens_archives_liste.toFront();

        //Affichage
        tableau_des_biens_a.getItems().clear();
        Iterator<Bien> iterator = biens_archives.iterator();

        while(iterator.hasNext())
        {
            tableau_des_biens_a.getItems().add(iterator.next());
        }
    }

    @FXML
    public void Restaurer (ActionEvent actionEvent) {
        Bien bien_selectione;
        bien_selectione = (Bien) tableau_des_biens_a.getSelectionModel().getSelectedItem();
        tout_les_biens.add(bien_selectione);
        biens_archives.remove(bien_selectione);
        nbr_archi.setText(String.valueOf(biens_archives.size()));
        nbr_dispo.setText(String.valueOf(tout_les_biens.size()));
        //Affichage
        tableau_des_biens_a.getItems().clear();
        Iterator<Bien> iterator = biens_archives.iterator();

        while(iterator.hasNext())
        {
            tableau_des_biens_a.getItems().add(iterator.next());
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
    public void modifier_bien (ActionEvent actionEvent) {
        Bien bien_selectione;
        bien_selectione = (Bien) tableau_des_biens4.getSelectionModel().getSelectedItem();
        Modifier_bien_panel.toBack();
        Liste_des_bien_panel.toBack();
        Ajouter_bien_panel.toFront();
        if (bien_selectione.getNomClasse() == "Maison") {

            Maison ms = (Maison) bien_selectione;
            menu_Terrain.toBack();
            menu_Apartement.toBack();
            menu_Maison.toFront();
            Typedetransaction_maison.setText(String.valueOf(ms.getTransaction()));
            Adresse_maison.setText(String.valueOf(ms.getAdresse()));
            Superficie_maison.setText(String.valueOf(ms.getSuperficie()));
            Prix_maison.setText(String.valueOf(ms.getPrix()));
            if (ms.isGarage()) {
                Avec_Garage_maison.setSelected(true);
                Sans_Garage_maison.setSelected(false);
            } else {
                Sans_Garage_maison.setSelected(true);
                Avec_Garage_maison.setSelected(false);
            }
            if (ms.isPiscine()) {
                Avec_Piscine_maison.setSelected(true);
                Sans_Piscine_maison.setSelected(false);
            } else {
                Sans_Piscine_maison.setSelected(true);
                Avec_Piscine_maison.setSelected(false);
            }

            Wilaya_maison.setText(String.valueOf(ms.getWilaya()));
            if (ms.isJardin()) {
                Avec_Jardin_maison.setSelected(true);
                Sans_Jardin_maison.setSelected(false);
            } else {
                Sans_Jardin_maison.setSelected(true);
                Avec_Jardin_maison.setSelected(false);
            }

            nbr_etages_maison.setText(String.valueOf(ms.getNbr_etages()));
            nbr_pieces_maison.setText(String.valueOf(ms.getNbr_pieces()));
            if (ms.isMeuble()) {
                Avec_Meubles_maison.setSelected(true);
                Sans_Meubles_maison.setSelected(false);
            } else {
                Sans_Meubles_maison.setSelected(true);
                Avec_Meubles_maison.setSelected(false);
            }

            if (ms.isFixe()) {
                Prix_Fixe_maison.setSelected(true);
                Prix_Negotiable_maison.setSelected(false);
            } else {
                Prix_Negotiable_maison.setSelected(true);
                Prix_Fixe_maison.setSelected(false);
            }

            Proprietaire_maison.setText(ms.getProprietaire().getNom() + " " + ms.getProprietaire().getPrenom());
            ajouter_image_maison.setText(ms.getImage());
            confirmer_modif_maison.toFront();
            confirmer_modif_maison.setOnAction(actionEvent12 -> {
                String type = new String();
                type = "Maison";
                LocalDateTime nv_date = LocalDateTime.now();
                Maison nv_maison = new Maison(Adresse_maison.getText(), Bien.Transaction.valueOf(type_de_transaction), Double.parseDouble(Prix_maison.getText()), proprietaire[num_de_prop - 1], Bien.Wilaya_.valueOf(num_de_wilaya), Double.parseDouble(Superficie_maison.getText()), nv_date, Avec_Garage_maison.isSelected(), Avec_Piscine_maison.isSelected(), Avec_Jardin_maison.isSelected(), Integer.parseInt(nbr_etages_maison.getText()), Integer.parseInt(nbr_pieces_maison.getText()), Avec_Meubles_maison.isSelected(), Prix_Fixe_maison.isSelected(), ajouter_image_maison.getText(), type);
                tout_les_biens.remove(ms);
                tout_les_biens.add(nv_maison);
                menu_Maison.toBack();
                menu_Apartement.toBack();
                menu_Terrain.toBack();
                Modifier_bien_panel.toFront();

                //Affichage
                tableau_des_biens4.getItems().clear();
                Iterator<Bien> iterator = tout_les_biens.iterator();

                while (iterator.hasNext()) {
                    tableau_des_biens4.getItems().add(iterator.next());

                }
            });


        } else if (bien_selectione.getNomClasse() == "Apartement") {
            Apartement ap = (Apartement) bien_selectione;
            menu_Terrain.toBack();
            menu_Apartement.toFront();
            menu_Maison.toBack();

            Typedetransaction_apartement.setText(String.valueOf(ap.getTransaction()));
            Adresse_apartement.setText(String.valueOf(ap.getAdresse()));
            Superficie_apartement.setText(String.valueOf(ap.getSuperficie()));
            Prix_apartement.setText(String.valueOf(ap.getPrix()));
            if (ap.isAscenseur()) {
                Avec_Ascenseur_apartement.setSelected(true);
                Sans_Ascenseur_apartement.setSelected(false);
            } else {
                Sans_Ascenseur_apartement.setSelected(true);
                Avec_Ascenseur_apartement.setSelected(false);
            }
            if (ap.isSimplexe_Duplexe()) {
                Simplexe_apartement.setSelected(true);
                Duplexe_apartement.setSelected(false);
            } else {
                Duplexe_apartement.setSelected(true);
                Simplexe_apartement.setSelected(false);
            }

            Wilaya_apartement.setText(String.valueOf(ap.getWilaya()));
            numero_etage_apartement.setText(String.valueOf(ap.getEtage()));
            nbr_pieces_apartement.setText(String.valueOf(ap.getNbr_pieces()));
            if (ap.isMeuble()) {
                Avec_Meubles_apartement.setSelected(true);
                Sans_Meubles_apartement.setSelected(false);
            } else {
                Sans_Meubles_apartement.setSelected(true);
                Avec_Meubles_apartement.setSelected(false);
            }
            if (ap.isFixe()) {
                Prix_Fixe_apartement.setSelected(true);
                Prix_Negotiable_apartement.setSelected(false);
            } else {
                Prix_Negotiable_apartement.setSelected(true);
                Prix_Fixe_apartement.setSelected(false);
            }

            Proprietaire_apartement.setText(ap.getProprietaire().getNom() + " " + ap.getProprietaire().getPrenom());
            ajouter_image_apartement.setText(ap.getImage());
            modif_apartement.toFront();
            modif_apartement.setOnAction(actionEvent1 -> {
                String type = new String();
                type = "Apartement";
                LocalDateTime nv_date = LocalDateTime.now();
                Apartement nv__apartement = new Apartement(Adresse_apartement.getText(), Bien.Transaction.valueOf(type_de_transaction), Double.parseDouble(Prix_apartement.getText()), proprietaire[num_de_prop - 1], Bien.Wilaya_.valueOf(num_de_wilaya), Double.parseDouble(Superficie_apartement.getText()), nv_date, Integer.parseInt(numero_etage_apartement.getText()), Integer.parseInt(nbr_pieces_apartement.getText()), Simplexe_apartement.isSelected(), Avec_Ascenseur_apartement.isSelected(), Avec_Meubles_apartement.isSelected(), Prix_Fixe_apartement.isSelected(), ajouter_image_apartement.getText(), type);
                tout_les_biens.remove(ap);
                tout_les_biens.add(nv__apartement);
                menu_Apartement.toBack();
                menu_Maison.toBack();
                menu_Terrain.toBack();
                Modifier_bien_panel.toFront();

                //Affichage
                tableau_des_biens4.getItems().clear();
                Iterator<Bien> iterator = tout_les_biens.iterator();

                while (iterator.hasNext()) {
                    tableau_des_biens4.getItems().add(iterator.next());

                }
            });
        } else if (bien_selectione.getNomClasse() == "Terrain") {
            Bien_non_habitable tr = (Bien_non_habitable) bien_selectione;
            menu_Terrain.toFront();
            menu_Apartement.toBack();
            menu_Maison.toBack();

            Typedetransaction_terrain.setText(String.valueOf(tr.getTransaction()));
            Adresse_terrain.setText(tr.getAdresse());
            Superficie_terrain.setText(String.valueOf(tr.getSuperficie()));
            Prix_terrain.setText(String.valueOf(tr.getPrix()));
            Wilaya_terrain.setText(String.valueOf(tr.getWilaya()));
            Nbr_Facades_terrain.setText(String.valueOf(tr.getNbr_facades()));
            if (tr.isFixe()) {
                Prix_Fixe_terrain.setSelected(true);
                Prix_Negotiable_terrain.setSelected(false);
            } else {
                Prix_Negotiable_terrain.setSelected(true);
                Prix_Fixe_terrain.setSelected(false);
            }
            Proprietaire_terrain.setText(tr.getProprietaire().getNom() + " " + tr.getProprietaire().getPrenom());
            ajouter_image_terrain.setText(tr.getImage());
            ajouter_statut_terrain.setText(tr.getStatus_juridique());
            modif_terrain.toFront();
            modif_terrain.setOnAction(actionEvent3 -> {

                String type = new String();
                type = "Terrain";
                LocalDateTime nv_date = LocalDateTime.now();
                Bien_non_habitable nv_terrain = new Bien_non_habitable(Adresse_terrain.getText(), Bien.Transaction.valueOf(type_de_transaction), Double.parseDouble(Prix_terrain.getText()), proprietaire[num_de_prop - 1], Bien.Wilaya_.valueOf(num_de_wilaya), Double.parseDouble(Superficie_terrain.getText()), nv_date, Integer.parseInt(Nbr_Facades_terrain.getText()), ajouter_statut_terrain.getText(), type, ajouter_image_terrain.getText(),Prix_Fixe_terrain.isSelected());
                tout_les_biens.remove(tr);
                tout_les_biens.add(nv_terrain);
                menu_Terrain.toBack();
                menu_Apartement.toBack();
                menu_Maison.toBack();
                Modifier_bien_panel.toFront();
            });
        }
    }

    public void rechercher (ActionEvent actionEvent) {

        if(actionEvent.getSource() == lancer_rech) {
            ArrayList<Bien> biens = new ArrayList<Bien>(tout_les_biens);
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

        if (check_prop.isSelected()) {
            Iterator<Bien> it8 = biens.iterator();
            while (it8.hasNext()) {
                b = it8.next();

                if (String.valueOf(b.getProprietaire().getNom()) != (filtre_de_prop)) {
                    it8.remove();
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



    //les variables de base de données


    public static TreeSet<Bien> tout_les_biens = new TreeSet<Bien>(); //la liste des biens complete
    private TreeSet<Bien> biens_archives = new TreeSet<Bien>(); //la liste des biens archivés


    /*les proprietaires prop1 prop2 prop3*/
    static Proprietaire[] proprietaire = new Proprietaire[100];
    TreeSet<Bien> ts1 = new TreeSet<Bien>();
    TreeSet<Bien> ts2 = new TreeSet<Bien>();
    TreeSet<Bien> ts3 = new TreeSet<Bien>();
    private Proprietaire prop1 = new Proprietaire("Boutaleb", "Mohamed Allaa Eddine", "im_boutaleb@esi.dz", "0776539155", "Rue 06 des freres Taleb, wilaya 1", ts1);
    private Proprietaire prop2 = new Proprietaire("Zidane", "Zine Eddine", "iz_zidane@esi.dz", "0776584531", "Rue 13 de Draria, wilaya 3", ts2);
    private Proprietaire prop3 = new Proprietaire("Amel", "Chehrouri", "ia_amel@gmail.com", "0541354879", "77, cartier larude, wilaya 2", ts3);
    /***************************************/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Initialisation des menu d'ajout de chaque type de bien
        //maison
        Sans_Garage_maison.setToggleGroup(groupe_m_1);Avec_Garage_maison.setToggleGroup(groupe_m_1);Sans_Piscine_maison.setToggleGroup(groupe_m_2);Avec_Piscine_maison.setToggleGroup(groupe_m_2);
        Sans_Jardin_maison.setToggleGroup(groupe_m_3);Avec_Jardin_maison.setToggleGroup(groupe_m_3);Sans_Meubles_maison.setToggleGroup(groupe_m_4);Avec_Meubles_maison.setToggleGroup(groupe_m_4);
        Prix_Fixe_maison.setToggleGroup(groupe_m_5);Prix_Negotiable_maison.setToggleGroup(groupe_m_5);
        Vente_maison.setOnAction(e -> { Typedetransaction_maison.setText("VENTE"); Typedetransaction_maison.setTextFill(Color.web("#0ed145")); type_de_transaction = "VENTE"; });
        Location_maison.setOnAction(e -> { Typedetransaction_maison.setText("LOCATION"); Typedetransaction_maison.setTextFill(Color.web("#0ed145")); type_de_transaction = "LOCATION";});
        Echange_maison.setOnAction(e -> { Typedetransaction_maison.setText("ECHANGE"); Typedetransaction_maison.setTextFill(Color.web("#0ed145")); type_de_transaction = "ECHANGE";});
        Wilaya1_maison.setOnAction(e -> { Wilaya_maison.setText("Wilaya 1"); Wilaya_maison.setTextFill(Color.web("#0ed145")); num_de_wilaya = "Wilaya1";});
        Wilaya2_maison.setOnAction(e -> { Wilaya_maison.setText("Wilaya 2"); Wilaya_maison.setTextFill(Color.web("#0ed145")); num_de_wilaya = "Wilaya2";});
        Wilaya3_maison.setOnAction(e -> { Wilaya_maison.setText("Wilaya 3"); Wilaya_maison.setTextFill(Color.web("#0ed145")); num_de_wilaya = "Wilaya3";});
        Prop1_maison.setOnAction(e -> { Proprietaire_maison.setText("Prop 1"); Proprietaire_maison.setTextFill(Color.web("#0ed145")); num_de_prop=1;});
        Prop2_maison.setOnAction(e -> { Proprietaire_maison.setText("Prop 2"); Proprietaire_maison.setTextFill(Color.web("#0ed145")); num_de_prop=2;});
        Prop3_maison.setOnAction(e -> { Proprietaire_maison.setText("Prop 3"); Proprietaire_maison.setTextFill(Color.web("#0ed145")); num_de_prop=3;});

        //apartement
        Simplexe_apartement.setToggleGroup(groupe_a_1);Duplexe_apartement.setToggleGroup(groupe_a_1);Sans_Ascenseur_apartement.setToggleGroup(groupe_a_2);Avec_Ascenseur_apartement.setToggleGroup(groupe_a_2);
        Sans_Meubles_apartement.setToggleGroup(groupe_a_3);Avec_Meubles_apartement.setToggleGroup(groupe_a_3);Prix_Fixe_apartement.setToggleGroup(groupe_a_4);Prix_Negotiable_apartement.setToggleGroup(groupe_a_4);
        Vente_apartement.setOnAction(e -> { Typedetransaction_apartement.setText("VENTE"); Typedetransaction_apartement.setTextFill(Color.web("#0ed145")); type_de_transaction = "VENTE";});
        Location_apartement.setOnAction(e -> { Typedetransaction_apartement.setText("LOCATION"); Typedetransaction_apartement.setTextFill(Color.web("#0ed145"));type_de_transaction = "LOCATION"; });
        Echange_apartement.setOnAction(e -> { Typedetransaction_apartement.setText("ECHANGE"); Typedetransaction_apartement.setTextFill(Color.web("#0ed145")); type_de_transaction = "ECHANGE";});
        Wilaya1_apartement.setOnAction(e -> { Wilaya_apartement.setText("Wilaya 1"); Wilaya_apartement.setTextFill(Color.web("#0ed145")); num_de_wilaya = "Wilaya1";});
        Wilaya2_apartement.setOnAction(e -> { Wilaya_apartement.setText("Wilaya 2"); Wilaya_apartement.setTextFill(Color.web("#0ed145")); num_de_wilaya = "Wilaya2"; });
        Wilaya3_apartement.setOnAction(e -> { Wilaya_apartement.setText("Wilaya 3"); Wilaya_apartement.setTextFill(Color.web("#0ed145")); num_de_wilaya = "Wilaya3"; });
        Prop1_apartement.setOnAction(e -> { Proprietaire_apartement.setText("Prop 1"); Proprietaire_apartement.setTextFill(Color.web("#0ed145")); num_de_prop=1;});
        Prop2_apartement.setOnAction(e -> { Proprietaire_apartement.setText("Prop 2"); Proprietaire_apartement.setTextFill(Color.web("#0ed145")); num_de_prop=2;});
        Prop3_apartement.setOnAction(e -> { Proprietaire_apartement.setText("Prop 3"); Proprietaire_apartement.setTextFill(Color.web("#0ed145")); num_de_prop=3;});

        //terrain
        Prix_Fixe_terrain.setToggleGroup(groupe_t_1);Prix_Negotiable_terrain.setToggleGroup(groupe_t_1);
        Vente_terrain.setOnAction(e -> { Typedetransaction_terrain.setText("VENTE"); Typedetransaction_terrain.setTextFill(Color.web("#0ed145")); type_de_transaction = "VENTE";});
        Echange_terrain.setOnAction(e -> { Typedetransaction_terrain.setText("ECHANGE"); Typedetransaction_terrain.setTextFill(Color.web("#0ed145")); type_de_transaction = "ECHANGE";});
        Location_terrain.setOnAction(e -> { Typedetransaction_terrain.setText("LOCATION"); Typedetransaction_terrain.setTextFill(Color.web("#0ed145"));type_de_transaction = "LOCATION"; });
        Wilaya1_terrain.setOnAction(e -> { Wilaya_terrain.setText("Wilaya 1"); Wilaya_terrain.setTextFill(Color.web("#0ed145")); num_de_wilaya = "Wilaya1";});
        Wilaya2_terrain.setOnAction(e -> { Wilaya_terrain.setText("Wilaya 2"); Wilaya_terrain.setTextFill(Color.web("#0ed145")); num_de_wilaya = "Wilaya2";});
        Wilaya3_terrain.setOnAction(e -> { Wilaya_terrain.setText("Wilaya 3"); Wilaya_terrain.setTextFill(Color.web("#0ed145")); num_de_wilaya = "Wilaya3";});
        Prop1_terrain.setOnAction(e -> { Proprietaire_terrain.setText("Prop 1"); Proprietaire_terrain.setTextFill(Color.web("#0ed145")); num_de_prop=1;});
        Prop2_terrain.setOnAction(e -> { Proprietaire_terrain.setText("Prop 2"); Proprietaire_terrain.setTextFill(Color.web("#0ed145")); num_de_prop=2;});
        Prop3_terrain.setOnAction(e -> { Proprietaire_terrain.setText("Prop 3"); Proprietaire_terrain.setTextFill(Color.web("#0ed145")); num_de_prop=3;});

        //filtre
        wilaya11.setOnAction(e -> {wilayaa.setText("Wilaya 1"); filtre_de_wilaya ="Wilaya1";});ventee.setOnAction(e-> {transactionn.setText("Vente");filtre_de_transaction=("VENTE");});
        wilaya22.setOnAction(e -> {wilayaa.setText("Wilaya 2"); filtre_de_wilaya ="Wilaya2";});locationn.setOnAction(e-> {transactionn.setText("Location");filtre_de_transaction=("LOCATION");});
        wilaya33.setOnAction(e -> {wilayaa.setText("Wilaya 3"); filtre_de_wilaya ="Wilaya3";});echangee.setOnAction(e-> {transactionn.setText("Echange");filtre_de_transaction=("ECHANGE");});
        maisonn.setOnAction(e -> {maisonn.setText("Maison"); filtre_de_type ="Maison";});        apartementt.setOnAction(e -> {maisonn.setText("Apartement"); filtre_de_type ="Apartement";});
        terrainn.setOnAction(e -> {terrainn.setText("Terrain"); filtre_de_type ="Terrain";});        prop_1_.setOnAction(e -> {propp.setText("Prop 1"); filtre_de_prop ="Boutaleb";});
        prop_2_.setOnAction(e -> {propp.setText("Prop 2"); filtre_de_prop ="Zidane";});        prop_3_.setOnAction(e -> {propp.setText("Prop 3"); filtre_de_prop ="Amel";});







        proprietaire[0]=prop1;
        proprietaire[1]=prop2;
        proprietaire[2]=prop3;

        nbr_dispo.setText("0");
        nbr_archi.setText("0");
        nbr_sup.setText("0");

        ttype_de_bien.setCellValueFactory(new PropertyValueFactory<Bien,String>("nomClasse"));
        tprix.setCellValueFactory(new PropertyValueFactory<Bien, String>("prix"));
        tdate.setCellValueFactory(new PropertyValueFactory<Bien,String>("date"));
        twilaya.setCellValueFactory(new PropertyValueFactory<Bien, String>("wilaya"));
        ttype_de_transaction.setCellValueFactory(new PropertyValueFactory<Bien, String>("transaction"));

        ttype_de_bien_a.setCellValueFactory(new PropertyValueFactory<Bien,String>("nomClasse"));
        tprix_a.setCellValueFactory(new PropertyValueFactory<Bien, String>("prix"));
        tdate_a.setCellValueFactory(new PropertyValueFactory<Bien,String>("date"));
        twilaya_a.setCellValueFactory(new PropertyValueFactory<Bien, String>("wilaya"));
        ttype_de_transaction_a.setCellValueFactory(new PropertyValueFactory<Bien, String>("transaction"));

        ttype_de_bien1.setCellValueFactory(new PropertyValueFactory<Bien,String>("nomClasse"));
        tprix1.setCellValueFactory(new PropertyValueFactory<Bien, String>("prix"));
        tdate1.setCellValueFactory(new PropertyValueFactory<Bien,String>("date"));
        twilaya1.setCellValueFactory(new PropertyValueFactory<Bien, String>("wilaya"));
        ttype_de_transaction1.setCellValueFactory(new PropertyValueFactory<Bien, String>("transaction"));

        c_type.setCellValueFactory(new PropertyValueFactory<Bien,String>("nomClasse"));
        c_prix.setCellValueFactory(new PropertyValueFactory<Bien, String>("prix"));
        c_superficie.setCellValueFactory(new PropertyValueFactory<Bien,String>("superficie"));
        c_wilaya.setCellValueFactory(new PropertyValueFactory<Bien, String>("wilaya"));
        c_transaction.setCellValueFactory(new PropertyValueFactory<Bien, String>("transaction"));
        c_prop.setCellValueFactory(new PropertyValueFactory<Bien, String>("proprietaire"));

        username.setCellValueFactory(new PropertyValueFactory<messages,String>("username"));
        messagee.setCellValueFactory(new PropertyValueFactory<messages,String>("message"));

    }

}

