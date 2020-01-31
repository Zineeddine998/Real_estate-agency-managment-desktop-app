package Noyau;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class bien_habitable extends Bien {
    protected int nbr_pieces;

	@Override
	public int getNbr_etages() {
		return nbr_etages;
	}

	@Override
	public void setNbr_etages(int nbr_etages) {
		this.nbr_etages = nbr_etages;
	}

	@Override
	public boolean isMeuble() {
		return meuble;
	}

	@Override
	public void setMeuble(boolean meuble) {
		this.meuble = meuble;
	}

	private int nbr_etages;
    protected boolean meuble;

	@Override
	public boolean isFixe() {
		return fixe;
	}

	@Override
	public void setFixe(boolean fixe) {
		this.fixe = fixe;
	}

	protected boolean fixe;


	public bien_habitable(String adresse, Transaction transaction, double prix, Proprietaire proprietaire, Wilaya_ wilaya, double superficie, LocalDateTime date, int nbr_pieces, boolean meuble) {
        super(adresse,transaction,prix,proprietaire, wilaya, superficie, date);
        this.nbr_pieces = nbr_pieces;
        this.meuble = meuble;



    }


	public int getNbr_pieces() {
		return nbr_pieces;
	}


	public void setNbr_pieces(int nbr_pieces) {
		this.nbr_pieces = nbr_pieces;
	}


	public double calculer_prix_vente_final(Wilaya_ w)
	{
		double cout = super.calculer_prix_vente_final(w);
		return cout;
	}
	public double calculer_prix_location_final(Wilaya_ w)
	{
		double cout = super.calculer_prix_location_final(w);
		return cout;
	}
	
}
