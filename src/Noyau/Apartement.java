package Noyau;

import java.time.LocalDateTime;
import java.util.Date;

public class Apartement extends bien_habitable {
    public int getEtage() {
        return etage;
    }

    public boolean isSimplexe_Duplexe() {
        return Simplexe_Duplexe;
    }

    public void setSimplexe_Duplexe(boolean simplexe_Duplexe) {
        Simplexe_Duplexe = simplexe_Duplexe;
    }

    public boolean isAscenseur() {
        return Ascenseur;
    }

    public void setAscenseur(boolean ascenseur) {
        Ascenseur = ascenseur;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    private int etage;
    private boolean Simplexe_Duplexe;
    private boolean Ascenseur;
    private String image;
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


    public Apartement (String adresse, Transaction transaction, double prix, Proprietaire proprietaire, Wilaya_ wilaya, double superficie, LocalDateTime date, int etage, int nbr_pieces, boolean Simplexe_Duplexe, boolean Ascenseur, boolean meuble, boolean fixe, String image, String type) {

        super(adresse,transaction,prix,proprietaire, wilaya, superficie, date, nbr_pieces, meuble);
        this.etage = etage;
        this.Simplexe_Duplexe = Simplexe_Duplexe;
        this.Ascenseur = Ascenseur;
        this.fixe = fixe;
        this.image = image;
        this.nomClasse = type;
    }

    public void afficher() {
            System.out.println("L'adresse de l'apartement : " + adresse + " à " + this.wilaya);
            System.out.println("Cet apartement est la propriete de : " + this.proprietaire);
            if (meuble == true) System.out.println("Cet apartement est meuble.");
            if (meuble == false) System.out.println("Cet apartement n'est PAS meuble.");
            if (Simplexe_Duplexe == true) System.out.println("Cet apartement est simplexe.");
            if (Simplexe_Duplexe == false) System.out.println("Cet apartement est duplexe.");
            if (Ascenseur == true) System.out.println("Cet apartement est accessible par escaliers et Ascenseur.");
            if (Ascenseur == false) System.out.println("Cet apartement est seulement accessible par escaliers.");
            System.out.println("Il est compose de " + nbr_pieces + "pieces.");
            if (etage == 1) System.out.println("Cet apartement se trouve au " + Integer.toString(etage) + "er etage.");
            if (etage != 1)System.out.println("Cet apartement se trouve au " + Integer.toString(etage) + "ème etage.");
            System.out.println("La superficie de cet apartement : " + Double.toString(superficie) + "km^2");
            System.out.println("Le prix de cet apartement : " + Double.toString(prix));
            if (negociable == true) System.out.println("Le prix est negociable.");
            if (negociable == false) System.out.println("Le prix est fixe.");
        System.out.println("-------------------------------------------------------");

    }

    public double calculer_prix_vente_final(Wilaya_ w)
    {
        double cout = super.calculer_prix_vente_final(w);
        if((this.etage<=2)&&(this.etage>=0))
        {
            cout = cout +50000;
        }
        return cout;
    }
    public double calculer_prix_location_final(Wilaya_ w)
    {
        double cout = super.calculer_prix_location_final(w);
        if((this.etage<=2)&&(this.etage>=0))
        {
            cout = cout + 5000;
        }
        if((this.etage<=6)&&(this.Ascenseur==false))
        {
            cout = cout - 500*this.getSuperficie();
        }
        return cout;
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

    public void afficher_sans_details() {
        System.out.println ("------------Ce bien s'agit d'un apartement------------");
        System.out.println ("adresse de l'apartement : " + this.adresse);
        System.out.println ("Wilaya de l'apartement : " + this.wilaya);
        System.out.println ("Proprietaire de l'apartement : " + this.proprietaire.getNom());
        System.out.println ("Type de transaction : " + this.transaction);
        System.out.println("Prix original de l'apartement : " + this.prix);
        System.out.println("Date d'ajout de l'apartement : " + this.date);
        System.out.println("-------------------------------------------------------");
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
