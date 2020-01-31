package Noyau;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;

public class Maison extends bien_habitable {

    private boolean garage;
    private boolean piscine;
    private boolean jardin;

    @Override
    public boolean isGarage() {
        return garage;
    }

    @Override
    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    @Override
    public boolean isPiscine() {
        return piscine;
    }

    @Override
    public void setPiscine(boolean piscine) {
        this.piscine = piscine;
    }

    @Override
    public boolean isJardin() {
        return jardin;
    }

    @Override
    public void setJardin(boolean jardin) {
        this.jardin = jardin;
    }

    @Override
    public int getNbr_etages() {
        return nbr_etages;
    }

    @Override
    public void setNbr_etages(int nbr_etages) {
        this.nbr_etages = nbr_etages;
    }

    @Override
    public boolean isFixe() {
        return fixe;
    }

    @Override
    public void setFixe(boolean fixe) {
        this.fixe = fixe;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private int nbr_etages;
    public boolean fixe;
    private String image;
    private String nomClasse;



    public Maison (String adresse, Transaction transaction, double prix, Proprietaire proprietaire, Wilaya_ wilaya, double superficie, LocalDateTime date, boolean garage, boolean piscine, boolean jardin, int nbr_etages, int nbr_pieces, boolean meuble, boolean fixe, String image, String type) {
        super(adresse,transaction,prix,proprietaire, wilaya, superficie, date, nbr_pieces, meuble);
        this.garage = garage;
        this.piscine = piscine;
        this.jardin = jardin;
        this.nbr_etages = nbr_etages;
        this.fixe = fixe;
        this.image = image;
        this.nomClasse = type;
    }

    public void afficher() {
        System.out.println("L'adresse de la maison : " + this.adresse);
        System.out.println("Cette maison est la propriete de : " + this.proprietaire.getNom());
        System.out.println ("Type de transaction : " + this.transaction);
        System.out.println("Date d'ajout de la Maison : " + this.date);
        if (meuble == true) System.out.println("Cette maison est meuble.");
        if (meuble == false) System.out.println("Cette maison n'est PAS meuble.");
        if (garage == true) System.out.println("Cette maison contient un garage.");
        if (piscine == true) System.out.println("Cette maison contient une piscine.");
        if (jardin == true) System.out.println("Cette maison contient un jardin");
        System.out.println("Cette maison contient " + Integer.toString (nbr_etages) + " etages.");
        System.out.println("Elle est compose de " + nbr_pieces + " pieces.");
        System.out.println("La superficie de la maison : " + Double.toString(superficie) + "km^2");
        System.out.println("Le prix de la maison : " + Double.toString(prix));
        if (fixe == false) System.out.println("Le prix est negociable.");
        if (fixe == true) System.out.println("Le prix est fixe.");
        System.out.println("L'image : " + image);
        System.out.println("-------------------------------------------------------");

    }

    public double calculer_prix_vente_final(Wilaya_ w)
    {
        double cout = super.calculer_prix_vente_final(w);
        if(this.garage || this.jardin || this.piscine)
        {
            cout = cout + cout*0.005;

        }
        return cout;
    }

    public double calculer_prix_location_final(Wilaya_ w)
    {
        double cout = super.calculer_prix_location_final(w);
        if(this.piscine)
        {
            cout = cout+50000;

        }
        return cout;
    }
    /*
    public double calculer_prix_echange_final(Wilaya_ w , Wilaya y)
    {
    	double cout = this.calculer_prix_vente_final(w);
		if(w.getNom().equals(y.getNom()))
		{
			return cout;	
		}
		return cout + cout*0.0025;
    }
*/
    /*public double calculer_prix () {
        double x = super ();

        if ( transaction == Transaction.VENTE ) {

        }

        if ( transaction == Transaction.LOCATION ) {
            if (nbr_etages >= 0 && nbr_etages <= 2 ) x = x + 5000;
            else {
                if ( nbr_etages >= 6) x = x - ( 500 * superficie );
            }
        }

        if ( transaction == Transaction.ECHANGE ) {
            if ( nbr_etages >= 0 && nbr_etages <= 2 ) x = x + 50000;
         //   if ( ! wilaya.equals(wilaya_echange) x = x + 0.0025 * x;
        }
    }
*/
    public void afficher_sans_details() {
        System.out.println ("------------Ce bien s'agit d'une Maison   ------------");
        System.out.println ("adresse du Maison : " + this.adresse);
        System.out.println ("Wilaya de Maison : " + this.wilaya);
        System.out.println ("Proprietaire de la Maison : " + this.proprietaire.getNom());
        System.out.println ("Type de transaction : " + this.transaction);
        System.out.println("Prix original de la maison : " + this.prix);
        System.out.println("Date d'ajout de la Maison : " + this.date);
        System.out.println("-------------------------------------------------------");
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }
}
