package Noyau;

//import org.freedesktop.dbus.interfaces.Local;

import java.awt.*;
import java.time.LocalDateTime;

public abstract class Bien implements Comparable<Bien> {

    public String getAdresse () {
        return adresse;
    }

    public void setAdresse ( String adresse ) {
        this.adresse = adresse;
    }

    public Wilaya_ getWilaya () {
        return wilaya;
    }

    public void setWilaya ( Wilaya_ wilaya ) {
        this.wilaya = wilaya;
    }

    public Proprietaire getProprietaire () {
        return proprietaire;
    }

    public void setProprietaire ( Proprietaire proprietaire ) {
        this.proprietaire = proprietaire;
    }

    public double getSuperficie () {
        return superficie;
    }

    public void setSuperficie ( double superficie ) {
        this.superficie = superficie;
    }

    public double getPrix () {
        return prix;
    }

    public void setPrix ( double prix ) {
        this.prix = prix;
    }

    public boolean isNegociable () {
        return negociable;
    }

    public void setNegociable ( boolean negociable ) {
        this.negociable = negociable;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public Image[] getPhotos () {
        return photos;
    }

    public void setPhotos ( Image[] photos ) {
        this.photos = photos;
    }

    public boolean isArchive () {
        return archive;
    }

    public void setArchive ( boolean archive ) {
        this.archive = archive;
    }

    public Transaction getTransaction () {
        return transaction;
    }

    public void setTransaction ( Transaction transaction ) {
        this.transaction = transaction;
    }

    public LocalDateTime getDate () {
        return date;
    }

    public void setDate ( LocalDateTime date ) {
        this.date = date;
    }

    protected Proprietaire proprietaire;
    protected String adresse;
    protected double superficie;
    protected double prix;
    protected boolean negociable;
    protected String description;
    protected Image[] photos;
    protected boolean archive;
    protected LocalDateTime date;
    protected boolean Archive;

    public boolean isFixe() {
        return fixe;
    }

    public void setFixe(boolean fixe) {
        this.fixe = fixe;
    }

    protected boolean fixe;


    protected boolean garage;
    protected boolean piscine;
    protected boolean jardin;
    protected int nbr_etages;
    protected int nbr_pieces;

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public boolean isPiscine() {
        return piscine;
    }

    public void setPiscine(boolean piscine) {
        this.piscine = piscine;
    }

    public boolean isJardin() {
        return jardin;
    }

    public void setJardin(boolean jardin) {
        this.jardin = jardin;
    }

    public int getNbr_etages() {
        return nbr_etages;
    }

    public void setNbr_etages(int nbr_etages) {
        this.nbr_etages = nbr_etages;
    }

    public int getNbr_pieces() {
        return nbr_pieces;
    }

    public void setNbr_pieces(int nbr_pieces) {
        this.nbr_pieces = nbr_pieces;
    }

    public boolean isMeuble() {
        return meuble;
    }

    public void setMeuble(boolean meuble) {
        this.meuble = meuble;
    }

    public boolean meuble;

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    protected String nomClasse;



    public enum Transaction {
        VENTE,LOCATION,ECHANGE;
    }

    protected Wilaya_ wilaya;

    public enum Wilaya_ {
        Wilaya1,Wilaya2,Wilaya3;
    }


    protected Transaction transaction;

    public Bien (String adresse, Transaction transaction, double prix, Proprietaire proprietaire, Wilaya_ wilaya, double superficie, LocalDateTime date)
    {
        this.adresse = adresse;
        this.transaction = transaction;
        this.prix = prix;
        this.proprietaire = proprietaire;
        this.wilaya = wilaya;
        this.superficie = superficie;
        this.date = date;
        this.Archive = false;

    }

    public abstract void afficher();


    public double calculer_prix_vente_final(Wilaya_ wilaya)
    {
        double cout = this.getPrix();
        double prix_par_m2 = 0;
        if (wilaya == Wilaya_.Wilaya1) prix_par_m2 =100000;
        if (wilaya == Wilaya_.Wilaya2) prix_par_m2 =30000;
        if (wilaya == Wilaya_.Wilaya3) prix_par_m2 =60000;
        if((this.getPrix())<5000000)
        {
            if(prix_par_m2<50000)
            {
                cout = cout + 0.03*this.getPrix();
            }
            else
            {
                cout = cout + 0.035*cout;
            }
        }
        if(((this.getPrix())>=5000000)&&((this.getPrix())<=15000000))
        {
            if((prix_par_m2)<50000)
            {
                cout = cout + 0.02*this.getPrix();
            }
            else
            {
                cout = cout + 0.025*cout;
            }
        }
        if((this.getPrix())>15000000)
        {
            if((prix_par_m2)<70000)
            {
                cout = cout + 0.01*this.getPrix();
            }
            else
            {
                cout = cout + 0.02*cout;
            }
        }
        return cout;

    }

    public double calculer_prix_location_final(Wilaya_ w)
    {
        double cout = this.getPrix();
        double prix_par_m2 = 0;
        if (w == Wilaya_.Wilaya1) prix_par_m2 = 100000;
        if (w == Wilaya_.Wilaya2) prix_par_m2 = 30000;
        if (w == Wilaya_.Wilaya3) prix_par_m2 = 60000;

        if(this.superficie<60)
        {
            if(prix_par_m2<50000)
            {
                cout = cout + cout*0.01;
            }
            else
            {
                cout = cout + cout * 0.015;
            }
        }
        if(((this.superficie)<=60)&&((this.superficie)>=150))
        {
            if(prix_par_m2<50000)
            {
                cout = cout + cout*0.02;
            }
            else
            {
                cout = cout + cout * 0.025;
            }
        }
        if(this.superficie>150)
        {
            if(prix_par_m2<50000)
            {
                cout = cout + cout*0.03;
            }
            else
            {
                cout = cout + cout * 0.035;
            }
        }
        return cout;
    }
	
	
	/*public double calculer_prix_echange_final(Wilaya w,Wilaya y)
	{
		double cout = this.calculer_prix_vente_final(w);
		if(w.getNom().equals(y.getNom()))
		{
			cout = cout + cout*0.0025;
		}
		return cout;

	}*/
   // abstract double calculer_prix_vente_Immo(Wilaya w);

    @Override
    public int compareTo ( Bien o ) {
        return this.date.compareTo (o.date);

    }

    abstract void afficher_sans_details();

}
