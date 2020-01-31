package Noyau;

import java.time.LocalDateTime;
import java.util.Date;

public class Bien_non_habitable extends Bien {
    public String getStatus_juridique() {
        return status_juridique;
    }

    public void setStatus_juridique(String status_juridique) {
        this.status_juridique = status_juridique;
    }

    public int getNbr_facades() {
        return nbr_facades;
    }

    public void setNbr_facades(int nbr_facades) {
        this.nbr_facades = nbr_facades;
    }

    private String status_juridique;
    private int nbr_facades;
    private String nomClasse;

    @Override
    public boolean isFixe() {
        return fixe;
    }

    @Override
    public void setFixe(boolean fixe) {
        this.fixe = fixe;
    }

    private boolean fixe;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String image;

    public Bien_non_habitable (String adresse, Transaction transaction, double prix, Proprietaire proprietaire, Wilaya_ wilaya, double superficie, LocalDateTime date, int nbr_facades, String status_juridique, String type, String image, boolean fixe) {
        super(adresse,transaction,prix,proprietaire, wilaya, superficie, date);
        this.nbr_facades = nbr_facades;
        this.status_juridique = status_juridique;
        this.nomClasse = type;
        this.image = image;
        this.nomClasse = type;
        this.fixe = fixe;
    }


    public void afficher() {

        System.out.println("L'adresse du bien : " + adresse + " à " + wilaya);
        System.out.println("Ce bien est la propriete de : " + proprietaire);
        System.out.println("La description du bien : " + description);
        System.out.println("La superficie du bien : " + Double.toString(superficie) + "m^2");
        System.out.println("Le prix du bien : " + Double.toString(prix));
        if (negociable == true) System.out.println("Le prix est negociable.");
        if (negociable == false) System.out.println("Le prix est fixe.");
        System.out.println("Le status juridique du bien : " + status_juridique);
        System.out.println("le nombre de facades de ce bien : " + nbr_facades);
    }

    public void afficher_sans_details() {
        System.out.println ("------------Ce bien s'agit d'un Terrain------------");
        System.out.println ("adresse du Terrain : " + this.adresse);
        System.out.println ("Wilaya de Terrain : " + this.wilaya);
        System.out.println ("Proprietaire de Terrain : " + this.proprietaire);
        System.out.println ("Type de transaction : " + this.transaction);
        System.out.println("Prix original du Terrain : " + this.prix);
        System.out.println("Date d'ajout du terrain : " + this.date);
        System.out.println("-------------------------------------------------------");
    }
    public double calculer_prix_vente_final(Wilaya_ w)
    {
        double cout = super.calculer_prix_vente_final(w);
        if (this.nbr_facades>1)
        {
            cout = cout + 0.005*nbr_facades*cout;
        }
        return cout;
    }
    public double calculer_prix_location_final(Wilaya_ w)
    {
        double cout = super.calculer_prix_location_final(w);
        return cout;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }
    /*
    public double calculer_prix_echange_final(Wilaya w , Wilaya y)
    {
        double cout = this.calculer_prix_vente_final(w);
        if(w.getNom().equals(y.getNom()))
        {
            return cout;
        }
        return cout + cout*0.0025;

    }
*/


}