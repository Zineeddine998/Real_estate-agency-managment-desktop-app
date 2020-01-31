package Noyau;

import java.util.TreeSet;

public class Proprietaire implements Comparable<Proprietaire> {
    private String nom;
    private String prenom;
    private String adresse_mail;
    private String telephone;
    private String adresse;



    private TreeSet<Bien> biens;


    public void setBiens ( TreeSet<Bien> biens ) {
        this.biens = biens;
    }

    public Proprietaire( String nom, String prenom, String adresse_mail, String telephone, String adresse, TreeSet<Bien> biens) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse_mail = adresse_mail;
        this.telephone = telephone;
        this.adresse = adresse;
        this.biens = biens;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse_mail() {
        return adresse_mail;
    }

    public void setAdresse_mail(String adresse_mail) {
        this.adresse_mail = adresse_mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public TreeSet<Bien> getBiens () {
        return biens;
    }

    public void ajouter_bien(Bien bien) {
        biens.add (bien);
    }

    @Override
    public int compareTo ( Proprietaire o ) {
        return this.nom.compareTo (o.nom);

    }
}
