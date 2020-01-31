package Noyau;

public class Wilaya {
    private String nom;
    private double Prix_par_m2;

    public Wilaya() {};

    public Wilaya (String nom, double Prix) {
        this.nom = nom;
        Prix_par_m2 = Prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix_par_m2() {
        return Prix_par_m2;
    }

    public void setPrix_par_m2(double prix_par_m2) {
        Prix_par_m2 = prix_par_m2;
    }
}
