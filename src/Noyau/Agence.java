package Noyau;

import java.util.*;

public class Agence {





    public void afficher_bien( TreeSet<Bien> bienTreeSet ) {
        Iterator<Bien> it = bienTreeSet.iterator ();
        while (it.hasNext ()) {
            it.next ().afficher_sans_details();
        }
    }

    public void ajouter_bien (Bien bien,TreeSet<Bien> bienTreeSet)
    {

     //   bien.getProprietaire ().getBiens ().add (bien);
        bienTreeSet.add(bien); //ajouter dans la liste de tout les biens
    }

    public void supprimer_bien(TreeSet<Bien> bienTreeSet, Bien bien)//Supprimer la liste des biens
    {
      //  bien.getProprietaire ().getBiens ().remove (bien);
        bienTreeSet.remove (bien);

    }

    public void archiverBien(TreeSet<Bien> bien_archi, TreeSet<Bien> bienTreeSet, Bien bien)//Archiver bien dans la liste des biens
    {
        bien_archi.add(bien);
        bien.setArchive (true);
        bienTreeSet.remove (bien);
    }

    public void modifier_bien(Bien bien)//Modifier les informations du bien
    {
            int i;
            double prix;
            String adresse;
            Bien.Transaction transaction;

            System.out.println ("Voulez vous modifier : ");
            System.out.println ("1 - Le Prix : ");
            System.out.println ("2 - La Wilaya : ");
            System.out.println ("3 - L'adresse : ");
            System.out.println ("4 - Le type de transaction : ");
            //...
            System.out.println ("Entrez le nombre d'action correspondant S.V.P. : ");

            Scanner sc = new Scanner (System.in);
            i = sc.nextInt ();

            switch (i) {
                case 1: {
                    System.out.println ("Entrez le nouveau prix : ");
                    Scanner sc1 = new Scanner (System.in);
                    prix = sc1.nextDouble ();
                    bien.setPrix (prix);
                }
                break;
                case 2: {
                    System.out.println ("Entrez le nouvelle Wilaya : ");
                    Scanner sc1 = new Scanner (System.in);
                    String nom_modifie = sc1.nextLine ();
                    System.out.println ("Entrez le nouveau prix : ");
                    Scanner sc2 = new Scanner (System.in);
                    double prix_modifie = sc2.nextDouble ();
                    Bien.Wilaya_ wilaya = Bien.Wilaya_.Wilaya1;
                    bien.setWilaya (wilaya); ;
                }break;
                case 3 : {
                    System.out.println ("Entrez le nouvelle adresse : ");
                    Scanner sc1 = new Scanner (System.in);
                    bien.setAdresse (sc1.nextLine ());

                }break;

                case 4 : {
                    System.out.println ("Entrez le nouveau type de transaction : ");
                    System.out.println ("1 - VENTE");
                    System.out.println ("2 - LOCATION");
                    System.out.println ("3 - ECHANGE");


                    Scanner sc1 = new Scanner (System.in);
                    int i_transaction = sc1.nextInt ();

                    switch (i_transaction) {
                        case 1 : bien.setTransaction (Bien.Transaction.VENTE);break;
                        case 2 : bien.setTransaction (Bien.Transaction.LOCATION);break;
                        case 3 : bien.setTransaction (Bien.Transaction.ECHANGE);break;
                    }

                }break;

            }

    }





    public static TreeSet<Proprietaire> Proprietaires;




    public void recherche(TreeSet<Bien> ts,String[] val ,Boolean transaction,Boolean wilaya,Boolean prixmax,Boolean prixmin,Boolean typebien,Boolean supmin,Boolean nbminpcs){//Recherche a criteres
    
  

        TreeSet ts44= new TreeSet();
        ts44 = (TreeSet)ts.clone();
    
    if(transaction) {
    	
    	Iterator<Bien> it8 = ts.iterator ();
    	
            for (int i8 = 0; i8 < ts.size() ; i8++) {
            	
            	
   	           Bien bien= it8.next();
   	        
   	           if(!(bien.getTransaction().toString().equals(val[0])))  ts44.remove (bien);
   	        
            }
    }
    
    if(wilaya) {
    	Iterator<Bien> it7 = ts.iterator ();
        for (int i8 = 0; i8 < ts.size() ; i8++) {
        	
	           Bien bien= it7.next();
	          
	          
	          
	       
	           if(!(bien.getWilaya().equals(val[1]))) {
                   ts44.remove (bien);
	        	   
	           }
        }
     }
    
    
    if(prixmax) {
    	Iterator<Bien> it6 = ts.iterator ();
        for (int i8 = 0; i8 < ts.size() ; i8++) {
	           Bien bien= it6.next();

	           if((bien.getPrix()>Double.parseDouble(val[2])))  ts44.remove (bien);
        }
}
    if(prixmin) {
    	Iterator<Bien> it5 = ts.iterator ();
        for (int i8 = 0; i8 < ts.size() ; i8++) {
	           Bien bien= it5.next();
	           if(!(bien.getPrix()>=Double.parseDouble(val[3])))  ts44.remove (bien);
        }
}
    
    if(typebien) {
    	Iterator<Bien> it4 = ts.iterator ();
        for (int i8 = 0; i8 < ts.size() ; i8++) {
        	
	           Bien bien= it4.next();
	        
	           if(!(bien.getClass().toString().equals(val[4])))   ts44.remove (bien);
        }
     }
    
    
    if(supmin) {
    	Iterator<Bien> it3 = ts.iterator ();
        for (int i8 = 0; i8 < ts.size() ; i8++) {
	           Bien bien= it3.next();
	           if(!(bien.getSuperficie()>=Double.parseDouble(val[5])))  ts44.remove (bien);
        }
     }
    
    
    if(nbminpcs) {
    	Iterator<Bien> it2 = ts.iterator ();
        for (int i8 = 0; i8 < ts.size() ; i8++) {
        	 Bien bien= it2.next();
        	   if(!(bien.getClass().toString().equals("class Bien_non_habitable"))) {
	          
	           bien_habitable bien2 = (bien_habitable) bien;
	           if(!(bien2.getNbr_pieces()>=Double.parseDouble(val[6])))   ts44.remove (bien);
        }else { ts44.remove (bien);
        }
        }
        }
    
    
    
    Iterator<Bien> it66 = ts44.iterator ();
    for (int j6 = 0; j6 <ts44.size() ; j6++) {
    	it66.next ().afficher_sans_details ();
    }

   	 Proprietaire proprietaires [] = new Proprietaire[100];
    }
   

   /* public void bienproprietere(Proprietere proprietere,ListeBien<Bien> biens)//Afficher les biens du proprietere
    {
        for(int i = 0 ; i< biens.size() ; i++ )
        {
            if(biens.get(i).proprietere.equals(proprietere)) System.out.println(biens.get(i).toString());
        }
    }
*/
}
