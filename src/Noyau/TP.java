package Noyau;

import java.util.*;

public class TP {


    public static void main(String[] args) {
        String[][] message = new String[50][2];
        String[] val = new String[7];
        Agence imoesi = new Agence();
        int i_msg = 0;

        TreeSet<Bien> ts2 = new TreeSet<Bien>();
        TreeSet<Bien> ts3 = new TreeSet<Bien>();



/*
        String msg;
        String client;

        Wilaya wilaya1 = new Wilaya ("wilaya1", 100000);
        Wilaya wilaya2 = new Wilaya ("wilaya2", 30000);
        Wilaya wilaya3 = new Wilaya ("wilaya3", 60000);
        Wilaya wilaya0 = new Wilaya ("wilaya0",0);

        TreeSet<Bien> ts1 = new TreeSet<Bien> (); //biens du prop1
        TreeSet<Bien> ts2 = new TreeSet<Bien> (); //biens du prop2
        TreeSet<Bien> ts3 = new TreeSet<Bien> (); //biens du prop1
        TreeSet<Bien> ts4 = new TreeSet<Bien> (); //biens du prop1
        TreeSet<Bien> ts5 = new TreeSet<Bien> ();

        Proprietaire prop1 = new Proprietaire ("Boutaleb", "Allaa", "allaabtb@gmail.com", "0776539155", "06 rue des freres taleb Saida", ts1);
        Proprietaire prop2 = new Proprietaire ("Zidane", "Zineeddine", "zidanezineeddine@gmail.com", "0548654521", "n04 Draria Algier", ts2);
        Proprietaire prop3 = new Proprietaire ("Senouci", "Karima", "karisenouci@outlook.com", "0775417020", "5 juillet n03 Oran", ts3);
        Proprietaire prop4 = new Proprietaire ("Amari", "Amine", "amariamine@hotmail.com", "0551516145", "batiment A n12 cartier El Badr, Bejaia", ts4);

        ArrayList<Proprietaire> ProprietaireArrayList = new ArrayList<Proprietaire> ();
        ProprietaireArrayList.add (prop1);
        ProprietaireArrayList.add (prop2);
        ProprietaireArrayList.add (prop3);
        ProprietaireArrayList.add (prop4);


        Date date1 = new Date (110, Calendar.APRIL, 6);
        Date date2 = new Date (111, Calendar.DECEMBER, 5);
        Date date3 = new Date (112, Calendar.JANUARY, 13);
        Date date4 = new Date (113, Calendar.FEBRUARY, 22);
        Date date5 = new Date (114, Calendar.NOVEMBER, 14);
        Date date6 = new Date (115, Calendar.MARCH, 11);
        Date date7 = new Date (116, Calendar.AUGUST, 12);
        Date date8 = new Date (117, Calendar.SEPTEMBER, 25);
        Date date9 = new Date (118, Calendar.SEPTEMBER, 25);
        Date date10 = new Date (120, Calendar.SEPTEMBER, 25);
        Date date11 = new Date (108, Calendar.SEPTEMBER, 25);
        Date date12 = new Date (106, Calendar.SEPTEMBER, 25);
/*
        Apartement bien1 = new Apartement ("n04 Draria wilaya2", Bien.Transaction.VENTE, 4000000, prop2, wilaya2, 120, date1, 1, 4, true, true, true);
        Maison bien2 = new Maison ("n21 arbibenmhidi wilaya3", Bien.Transaction.VENTE, 10000000, prop1, wilaya3, 200, date2, false, false, true, 2, 5, true);
        Bien_non_habitable bien3 = new Bien_non_habitable ("n96 el alia wilaya1", Bien.Transaction.VENTE, 20000000, prop1, wilaya1, 500, date3, 3, "Papier timbre");
        Apartement bien4 = new Apartement ("n05 1novembre wilaya3", Bien.Transaction.LOCATION, 400000, prop2, wilaya3, 100, date4, 1, 3, true, false, true);
        Maison bien5 = new Maison ("n21 El Badr wilaya2", Bien.Transaction.LOCATION, 150000, prop3, wilaya2, 160, date5, false, true, false, 4, 8, true);
        Apartement bien6 = new Apartement ("n06 1novembre wilaya3", Bien.Transaction.LOCATION, 600000, prop2, wilaya3, 50, date6, 6, 1, true, false, false);
        Bien_non_habitable bien7 = new Bien_non_habitable ("n69 El Nasr Wilaya1", Bien.Transaction.ECHANGE, 18000000, prop1, wilaya1, 650, date7, 1, "Papier timbre");
        Maison bien8 = new Maison ("TEST TEST TEST", Bien.Transaction.ECHANGE, 14000000, prop2, wilaya2, 200, date8, true, false, false, 3, 7, true);
        Maison bien9 = new Maison ("TEEEEEEEEEEEEEEEEEEEEEEST", Bien.Transaction.ECHANGE, 14000000, prop2, wilaya3, 400, date9, true, false, false, 3, 7, true);

        ts1.add (bien2);
        ts1.add (bien3);
        ts1.add (bien7);

        ts2.add (bien1);
        ts2.add (bien4);
        ts2.add (bien6);
        ts2.add (bien8);


        ts3.add (bien5);
       

        TreeSet<Bien> ts0 = new TreeSet<Bien> (); //tout les biens
        ts0.add (bien2);
        ts0.add (bien3);
        ts0.add (bien1);
        ts0.add (bien4);
        ts0.add (bien5);
        ts0.add (bien6);
        ts0.add (bien7);
        ts0.add (bien8);


        TreeSet<Bien> ts_archive = new TreeSet<Bien> (); //tout les biens


        String mdp = "123456";

        boolean continu_principal = true;
        while (continu_principal) {


            System.out.println ("Voulez vous vous connecter en tant que : ");
            System.out.println ("1 - Admin");
            System.out.println ("2 - Client");
            System.out.println ("Entrez votre choix S.V.P. : ");

            Scanner sc1 = new Scanner (System.in);
            int i = sc1.nextInt ();

            {
                if ( i == 1 ) {
                    System.out.println ("Entrez votre mot de passe : ");
                    Scanner sc2 = new Scanner (System.in);
                    String motdepasse = sc2.nextLine ();
                    if ( mdp.equals (motdepasse) ) {
                        System.out.println ("***** Connexion Reusite *****");
                        boolean continu = true;
                        while (continu) {
                            System.out.println ("Choisissez l'action que vous voulez effectuer : ");
                            System.out.println ("1 - Afficher les biens d'un proprietaire donne : ");
                            System.out.println ("2 - Ajouter un bien : ");
                            System.out.println ("3 - Archiver un bien : ");
                            System.out.println ("4 - Supprimer un bien : ");
                            System.out.println ("5 - Afficher un bien donne : ");
                            System.out.println ("6 - Afficher les message recus : ");
                            System.out.println ("7 - Modifier un bien : ");
                            System.out.println ("8 - Afficher les prix de chaque biens : ");
                            System.out.println ("9 - Recherche des biens : ");
                            System.out.println ("10 - Afficher le prix finale d'un bien ");
                         
                            Scanner action_admin = new Scanner (System.in);
                            int j = action_admin.nextInt ();
                            switch (j) {
                                case 1: {//Affichage des biens d'un proprietaire donné

                                    System.out.println ("Entrez le nombre du proprietaire : ");
                                    Scanner sc3 = new Scanner (System.in);
                                    int num_prop = sc3.nextInt ();

                                    Iterator<Proprietaire> it3 = ProprietaireArrayList.iterator ();
                                    for (int i3 = 0; i3 < num_prop - 1; i3++) {
                                        if ( it3.hasNext () ) it3.next ();
                                    }
                                    imoesi.afficher_bien (it3.next ().getBiens ());
                                }
                                break;
                                case 2: { //ajouter un bien
                                    Date dat = new Date();
                                    Boolean ajoute=false;
                                	 Bien.Transaction transaction2 = Bien.Transaction.VENTE;
                                    Proprietaire prop33 = new Proprietaire ("default","default","default","default","default",ts0);
                                    System.out.println ("Veuillez introduire le proprietaire : ");
                                    System.out.println ("1 - Proprietaire deja existant  : ");
                                    System.out.println ("2 - Ajouter un proprietaire  : ");
                                    Scanner gg = new Scanner (System.in);
                                   int  i8 =gg.nextInt();
                                   switch(i8){
                                       case 1: {
                                           System.out.println ("Veuillez choissir le proprietaire : ");
                                           int i7;
                                           Iterator<Proprietaire> it7 = ProprietaireArrayList.iterator ();
                                           for (int j7 = 1; j7 < ProprietaireArrayList.size ()+1; j7++) {
                                               System.out.println ( j7 +" - "+  it7.next ().getNom ());

                                           }
                                           Scanner kk = new Scanner (System.in);
                                           int   i6 =gg.nextInt();

                                           Iterator<Proprietaire> it5 = ProprietaireArrayList.iterator ();
                                           for (int j7 = 0; j7 < i6-1; j7++) {
                                               it5.next ();

                                           }
                                           prop33=it5.next ();
                                       break;}
                                       case 2: {
                                           ajoute = true;
                                           System.out.println ("Ajouter un nouveau proprietaire :");
                                           System.out.println ("introduire le nom du proprietaire :");
                                           Scanner kk1 = new Scanner (System.in);
                                           String i6 = kk1.nextLine ();
                                           System.out.println ("Introduire le prenom du proprietaire :");
                                           Scanner kk2 = new Scanner (System.in);
                                           String i7 = kk2.nextLine ();
                                           System.out.println ("Introduire l'addresse mail du  proprietaire :");
                                           Scanner kk3 = new Scanner (System.in);
                                           String i88 = kk3.nextLine ();
                                           System.out.println ("Introduire le numero de telephone :");
                                           Scanner kk4 = new Scanner (System.in);
                                           String i9 = kk4.nextLine ();
                                           System.out.println ("Introduire l'addresse du proprietaire  :");
                                           Scanner kk5 = new Scanner (System.in);
                                           String i10 = kk4.nextLine ();

                                           prop33.setAdresse_mail (i88);
                                           prop33.setAdresse (i10);
                                           prop33.setNom (i6);
                                           prop33.setPrenom (i7);
                                           prop33.setTelephone (i9);

                                           TreeSet<Bien> nv_liste = new TreeSet<Bien> ();

                                           prop33.setBiens (nv_liste);
                                           ProprietaireArrayList.add (prop33);
                                       }
                                           break;

                                   }

                                    	String ll;
                                    	System.out.println ("Veillez introduire le type de transaction : ");
                                    	System.out.println ("1 - VENTE");
                                    	System.out.println ("2 - LOCATION");
                                    	System.out.println ("3 - ECHANGE");
                                        Scanner scc11 = new Scanner (System.in);
                                       int r1 = scc11.nextInt();
                                       
                                        switch(r1)
                                        {
                                        case 1:transaction2 = Bien.Transaction.VENTE;break;
                                        case 2:transaction2 = Bien.Transaction.LOCATION;break;
                                        case 3:transaction2 = Bien.Transaction.ECHANGE;break;
                                        }
                                       
                                        System.out.println ("Veillez introduire l'adresse exacte  : ");
                                        Scanner scc333 = new Scanner (System.in);
                                       String  r6 = scc333.nextLine ();

                                        System.out.println ("Veillez choisir la wilaya par le num qui correspond : ");
                                        System.out.println ("1 - wilaya1");
                                        System.out.println ("2 - wilaya2");
                                        System.out.println ("3 - wilaya3");

                                        Scanner scc22 = new Scanner (System.in);
                                        int indicewilaya;
                                        indicewilaya = scc22.nextInt ();
                                        Wilaya nv_wilaya = new Wilaya ();
                                        switch (indicewilaya) {

                                            case 1:
                                                nv_wilaya = wilaya1;
                                                break;
                                            case 2:
                                                nv_wilaya = wilaya2;
                                                break;
                                            case 3:
                                                nv_wilaya = wilaya3;
                                                break;
                                        }

                                        String lmk;
                                    	System.out.println ("Veillez introduire le descriptif : ");
                                        Scanner scc222 = new Scanner (System.in);
                                        lmk = scc222.nextLine ();
                                   
                                        String lkm;
                                    	System.out.println ("Veillez introduire l'Url de la photo : ");
                                        Scanner scc221 = new Scanner (System.in);
                                        lkm= scc221.nextLine ();
                                    	

                                        
                                    	System.out.println ("Veillez introduire le prix : ");
                                        Scanner scc322 = new Scanner (System.in);
                                       double r4 = scc322.nextInt ();


                                    	System.out.println ("Veillez introduire le superficie : ");
                                        Scanner scc37 = new Scanner (System.in);
                                        double r79 = scc37.nextInt ();

                                     
                                    	System.out.println ("Veillez introduire le type du bien : ");
                                    	System.out.println ("1- Maison");
                                    	System.out.println ("2- Apartement");
                                    	System.out.println ("3- bien_non_habitable ");
                                        Scanner scc111 = new Scanner (System.in);
                                       int r5 = scc111.nextInt();
                                           
                                        switch(r5) {case 1: {
                                            System.out.println ("Veillez introduire le nombre de pieces : ");
                                            Scanner scc38 = new Scanner (System.in);
                                            int r7= scc38.nextInt ();

                                            System.out.println ("Veuillez introduire le nombre d'etages  : ");
                                            Scanner scc39 = new Scanner (System.in);
                                            int r8= scc39.nextInt ();

                                            Bien m = new Maison(r6,transaction2,r4,prop33,nv_wilaya,r79,dat,true,true,false,r7,r8,true);
                                            imoesi.ajouter_bien (m, ts0);

                                        }break;

                                        case 2 :  {
                                            System.out.println ("Veillez introduire le nombre de pieces : ");
                                            Scanner scc38 = new Scanner (System.in);
                                            int r7= scc38.nextInt ();


                                            System.out.println ("Veuillez introduire l'etage  : ");
                                            Scanner scc39 = new Scanner (System.in);
                                            int r8= scc39.nextInt ();

                                        	Bien ap = new Apartement(r6,transaction2,r4,prop33,nv_wilaya,r79,dat,r8,r7,false,false,false);
                                        	imoesi.ajouter_bien (ap, ts0);
                                        }break;

                                        case 3 : { System.out.println ("Veillez introduire le nombre de facades : ");
                                            Scanner scc377 = new Scanner (System.in);
                                            double r799 = scc377.nextInt ();

                                            String lg;
                                            System.out.println ("Veillez introduire le statut juridique : ");
                                            Scanner scc226 = new Scanner (System.in);
                                            lg= scc226.nextLine ();

                                            Bien ter = new  Bien_non_habitable(r6,transaction2,r4,prop33,nv_wilaya,r79,dat,(int)r799,lg);

                                            imoesi.ajouter_bien(ter, ts0); }break;
                                        }
                                       
                                   
                                    imoesi.afficher_bien (ts0);

                                }
                                break;

                                case 3: { //archiver un bien
                                    System.out.println ("----- Archiver un bien -----");
                                    System.out.println ("Entrez le numero du bien a archiver : ");

                                    Scanner sc3 = new Scanner (System.in);
                                    int i3 = sc3.nextInt ();
                                    Iterator<Bien> it = ts0.iterator ();
                                    for (int j3 = 0; j3 < i3 - 1; j3++) {
                                        it.next ();
                                    }
                                    System.out.println ("**************************************************");

                                    System.out.println ("Voici les biens avant l'archive : ");
                                    imoesi.afficher_bien (ts0);
                                    imoesi.archiverBien (ts_archive, ts0, it.next ());
                                    System.out.println ("**************************************************");

                                    System.out.println ("Voici les biens archives : ");
                                    imoesi.afficher_bien (ts_archive);
                                    System.out.println ("**************************************************");

                                    System.out.println ("Voici les biens apres l'archive : ");
                                    imoesi.afficher_bien (ts0);
                                    System.out.println ("**************************************************");


                                }
                                break;

                                case 4: { //supprimer un bien
                                    System.out.println ("----- Supprimer un bien -----");
                                    System.out.println ("Entrez le numero du bien a supprimer : ");
                                    Scanner sc4 = new Scanner (System.in);
                                    int i4 = sc4.nextInt ();
                                    Iterator<Bien> it4 = ts0.iterator ();
                                    for (int j3 = 0; j3 < i4 - 1; j3++) {
                                        it4.next ();
                                    }
                                    System.out.println ("**************************************************");

                                    System.out.println ("Voici les biens avant la suppression : ");
                                    imoesi.afficher_bien (ts0);
                                    imoesi.supprimer_bien (ts0, it4.next ());
                                    System.out.println ("**************************************************");

                                    System.out.println ("Voici les biens apres la suppression : ");
                                    imoesi.afficher_bien (ts0);
                                    System.out.println ("**************************************************");
                                }
                                break;

                                case 5: { //afficher un bien donne
                                    System.out.println ("----- Afficher un bien -----");
                                    System.out.println ("Entrez le numero du bien a afficher : ");
                                    Scanner sc5 = new Scanner (System.in);
                                    int i5 = sc5.nextInt ();
                                    Iterator<Bien> it5 = ts0.iterator ();
                                    for (int j5 = 0; j5 < i5 - 1; j5++) {
                                        it5.next ();
                                    }
                                    it5.next ().afficher();
                                }break;

                                case 6: { //afficher les messages
                                    for (int i6 = 0; i < i_msg + 1; i++) {
                                        System.out.println ("***************************************");
                                        System.out.println (message[i][0]);
                                        System.out.println (message[i][1]);
                                        System.out.println ("***************************************");
                                    }

                                }
                                break;

                                case 7: { //modifier un bien
                                    System.out.println ("----- Modifier un bien -----");
                                    {
                                        System.out.println ("Entrez le numero du bien a modifier : ");
                                        Scanner sc7 = new Scanner (System.in);
                                        int i7 = sc7.nextInt ();
                                        Iterator<Bien> it7 = ts0.iterator ();
                                        for (int j7 = 0; j7 < i7 - 1; j7++) {
                                            it7.next ();
                                        }
                                        imoesi.modifier_bien (it7.next ());
                                    }
                                }
                                break;
                                case 8 : {//afficher les prix finaux des biens
                                

                                     Iterator<Bien> it8 = ts0.iterator ();
                                     for (int i8 = 0; i8 < ts0.size() ; i8++) {
                                    	 System.out.println();
                                    	 Bien bien= it8.next();
                                    	 Bien.Transaction transaction = bien.getTransaction();
                                    	 int i9 = i8+1;
                                         switch (transaction) {
                                             case VENTE: System.out.println("Le prix du bien "+ i9 +" : " + (long)bien.calculer_prix_vente_final(bien.getWilaya ())+" DA");break;
                                             case LOCATION :System.out.println("Le prix du bien "+i9 + " : " +(long)bien.calculer_prix_location_final(bien.getWilaya ())+" DA") ;break;
                                             case ECHANGE : System.out.print("Le prix du bien "+i9 +" (echange dans la meme wilaya) : " +(long)bien.calculer_prix_echange_final(bien.getWilaya (),bien.getWilaya ())+" DA"+" , "); System.out.println("(echange dans une autre wilaya) : " +(long)bien.calculer_prix_echange_final(bien.getWilaya (),wilaya0)+" DA");break;
                                      
                                    	 
                                     } 
                                 
                                         //if ( it8.hasNext () ) it8.next ();
                                     //imoesi.afficher_bien (it8.next ().getBiens ());
                                	}
                               
                                }
                                break;
                                case 9:{
                                	System.out.println("Operation de recherche : ");
                                	Boolean b1 , b2 , b3 , b4 , b5 , b6 , b7;
                                	System.out.println ("Voulez vous choisir le type de transction ? (true pour OUI , false pour NON)");
                                    Scanner scc1 = new Scanner (System.in);
                                    b1 = scc1.nextBoolean ();
                                    if(b1)
                                    {
                                    	String ll;
                                    	System.out.println ("Veillez introduire le type de transaction : ");
                                        Scanner scc11 = new Scanner (System.in);
                                        ll = scc11.nextLine ();
                                        val[0]=ll;
                                    }
                                    System.out.println ("Voulez vous choisir une wilaya ? (true pour OUI , false pour NON)");
                                    Scanner scc2 = new Scanner (System.in);
                                    b2 = scc2.nextBoolean ();
                                    if(b2)
                                    {
                                    	System.out.println ("Veillez choisir la wilaya par le num qui correspond : ");
                                        System.out.println ("1 - wilaya1");
                                        System.out.println ("2 - wilaya2");
                                        System.out.println ("3 - wilaya3");

                                        Scanner scc22 = new Scanner (System.in);
                                        int indicewilaya;
                                        indicewilaya = scc22.nextInt ();
                                        switch (indicewilaya) {

                                            case 1 : val[1] =   "wilaya1";break;
                                            case 2 : val[1] =   "wilaya2";break;
                                            case 3 : val[1] =   "wilaya3";break;
                                        }
                                    }
                                    System.out.println ("Voulez vous introduire un prix max ? (true pour OUI , false pour NON)");
                                    Scanner scc3 = new Scanner (System.in);
                                    b3 = scc3.nextBoolean ();
                                    if(b3)
                                    {
                                    	String lk;
                                    	System.out.println ("Veillez introduire le prix max : ");
                                        Scanner scc32 = new Scanner (System.in);
                                        lk = scc32.nextLine ();
                                        val[2]=lk;
                                    }
                                    System.out.println ("Voulez vous introduire un prix min ? (true pour OUI , false pour NON)");
                                    Scanner scc4 = new Scanner (System.in);
                                    b4 = scc4.nextBoolean ();
                                    if(b4)
                                    {
                                    	String lk;
                                    	System.out.println ("Veuillez introduire le prix min : ");
                                        Scanner scc35 = new Scanner (System.in);
                                        lk = scc35.nextLine ();
                                        val[3]=lk;
                                    }
                                    System.out.println ("Voulez vous introduire le type du bien ? (true pour OUI , false pour NON)");
                                    Scanner scc5 = new Scanner (System.in);
                                    b5 = scc5.nextBoolean ();
                                    if(b5)
                                    {
                                    	String lk;
                                    	System.out.println ("Veillez introduire le type du bien : ");
                                        Scanner scc36 = new Scanner (System.in);
                                        lk = scc36.nextLine ();
                                        val[4]="class "+lk;
                                    }
                                    System.out.println ("Voulez vous introduire la superficie minimale  ? (true pour OUI , false pour NON)");
                                    Scanner scc6 = new Scanner (System.in);
                                    b6 = scc6.nextBoolean ();
                                    if(b6)
                                    {
                                    	String lk;
                                    	System.out.println ("Veillez introduire le superficie minimale : ");
                                        Scanner scc37 = new Scanner (System.in);
                                        lk = scc37.nextLine ();
                                        val[5]=lk;
                                    }
                                    System.out.println ("Voulez vous introduire le nombre minimal de pieces  ? (true pour OUI , false pour NON)");
                                    Scanner scc7 = new Scanner (System.in);
                                    b7 = scc7.nextBoolean ();
                                    if(b7)
                                    {
                                    	String lk;
                                    	System.out.println ("Veillez introduire le nombre minimal de pieces : ");
                                        Scanner scc38 = new Scanner (System.in);
                                        lk = scc38.nextLine ();
                                        val[6]=lk;
                                    }
                                    TreeSet<Bien> ts13 = new TreeSet<Bien> ();

                                    Iterator<Bien> it54 = ts0.iterator ();
                                    for (int i8 = 0; i8 < ts0.size() ; i8++) {
                                        Bien bien = it54.next();
                                        ts13.add (bien);


                                    }
                                    System.out.println ("*******************************************************************");
                                    
                                	imoesi.recherche(ts13,val ,b1,b2,b3,b4,b5,b6,b7);
                                	
                            }break;


                                case 10 :
                                {
                                    System.out.println ("----- Afficher du prix d'un  bien -----");
                                    System.out.println ("Entrez le numero du bien a afficher : ");
                                    Scanner sc5 = new Scanner (System.in);
                                    int i5 = sc5.nextInt ();
                                    Iterator<Bien> it5 = ts0.iterator ();
                                    for (int j5 = 0; j5 < i5 - 1; j5++) {
                                        it5.next ();
                                    }
                                    Bien bien55 = it5.next ();

                                        Bien.Transaction transaction = bien5.getTransaction();
                                        switch (transaction) {
                                            case VENTE: System.out.println((long)bien55.calculer_prix_vente_final(bien55.getWilaya ())+" DA");break;
                                            case LOCATION :System.out.println((long)bien55.calculer_prix_location_final(bien55.getWilaya ())+" DA") ;break;
                                            case ECHANGE : System.out.print("Le prix du bien  (echange dans la meme wilaya) : " +(long)bien55.calculer_prix_echange_final(bien55.getWilaya (),bien55.getWilaya ())+" DA"+" , "); System.out.println("(echange dans une autre wilaya) : " +(long)bien55.calculer_prix_echange_final(bien55.getWilaya (),wilaya0)+" DA");break;


                                        }


                                }
                            }
                            System.out.println ("Voulez vous continuer ? (true pour OUI , false pour NON)");
                            Scanner sc_continu = new Scanner (System.in);
                            continu = sc_continu.nextBoolean ();
                        }
                        } else System.out.println ("Mot de passe incorrecte, veuillez ressayer S.V.P.");

                } else {
                    if ( i == 2 ) {
                        System.out.println ("Bienvenu Cher Client !!!");
                        boolean continu2 = true;
                        while (continu2) {

                        System.out.println ("Choisissez l'action que vous voulez effectuer : ");
                        System.out.println ("1 - Envoyer un message a l'agence : ");
                        System.out.println ("2 - Afficher les biens selon un proprietaire donne : ");
                        System.out.println ("3 - Afficher un bien donne : ");
                        System.out.println ("4 - Afficher les prix finaux des biens : ");
                        System.out.println ("5 - Rechercher un bien : ");
                        System.out.println ("6 - Afficher le prix d'un bien donnee: ");


                        Scanner action_admin = new Scanner (System.in);
                        int j2 = action_admin.nextInt ();

                            switch (j2) {
                                case 1: { //envoyer un message
                                    System.out.println ("----- Envoyer  un msg -----");
                                    System.out.println ("Entrez le message a envoyer : ");
                                    Scanner sc6_1 = new Scanner (System.in);
                                    String i6_1 = sc6_1.nextLine ();
                                    System.out.println ("Entrez votre nom et prenom : ");
                                    Scanner sc6_2 = new Scanner (System.in);
                                    String i6_2 = sc6_2.nextLine ();
                                    i_msg++;
                                    envoyer_msg (i6_1, i6_2, message, i_msg);

                                }
                                break;

                                case 2: {//Affichage des biens d'un proprietaire donné

                                    System.out.println ("Entrez le nombre du proprietaire : ");
                                    Scanner sc3 = new Scanner (System.in);
                                    int num_prop = sc3.nextInt ();

                                    Iterator<Proprietaire> it3 = ProprietaireArrayList.iterator ();
                                    for (int i3 = 0; i3 < num_prop - 1; i3++) {
                                        if ( it3.hasNext () ) it3.next ();
                                    }
                                    imoesi.afficher_bien (it3.next ().getBiens ());
                                }
                                break;

                                case 3: { //afficher un bien donne
                                    System.out.println ("----- Afficher un bien -----");
                                    System.out.println ("Entrez le numero du bien a afficher : ");
                                    Scanner sc5 = new Scanner (System.in);
                                    int i5 = sc5.nextInt ();
                                    Iterator<Bien> it5 = ts0.iterator ();
                                    for (int j5 = 0; j5 < i5 - 1; j5++) {
                                        it5.next ();
                                    }
                                    it5.next ().afficher();
                                }break;

                                case 4 : {//afficher les prix finaux des biens


                                    Iterator<Bien> it8 = ts0.iterator ();
                                    for (int i8 = 0; i8 < ts0.size() ; i8++) {
                                        System.out.println();
                                        Bien bien= it8.next();
                                        Bien.Transaction transaction = bien.getTransaction();
                                        int i9 = i8+1;
                                        switch (transaction) {
                                            case VENTE: System.out.println("Le prix du bien "+ i9 +" : " + (long)bien.calculer_prix_vente_final(bien.getWilaya ())+" DA");break;
                                            case LOCATION :System.out.println("Le prix du bien "+i9 + " : " +(long)bien.calculer_prix_location_final(bien.getWilaya ())+" DA") ;break;
                                            case ECHANGE : System.out.print("Le prix du bien "+i9 +" (echange dans la meme wilaya) : " +(long)bien.calculer_prix_echange_final(bien.getWilaya (),bien.getWilaya ())+" DA"+" , "); System.out.println("(echange dans une autre wilaya) : " +(long)bien.calculer_prix_echange_final(bien.getWilaya (),wilaya0)+" DA");break;


                                        }

                                        //if ( it8.hasNext () ) it8.next ();
                                        //imoesi.afficher_bien (it8.next ().getBiens ());
                                    }

                                }
                                break;
                                case 5:{
                                    System.out.println("Operation de recherche : ");
                                    Boolean b1 , b2 , b3 , b4 , b5 , b6 , b7;
                                    System.out.println ("Voulez vous choisir le type de transction ? (true pour OUI , false pour NON)");
                                    Scanner scc1 = new Scanner (System.in);
                                    b1 = scc1.nextBoolean ();
                                    if(b1)
                                    {
                                        String ll;
                                        System.out.println ("Veillez introduire le type de transaction : ");
                                        Scanner scc11 = new Scanner (System.in);
                                        ll = scc11.nextLine ();
                                        val[0]=ll;
                                    }
                                    System.out.println ("Voulez vous choisir une wilaya ? (true pour OUI , false pour NON)");
                                    Scanner scc2 = new Scanner (System.in);
                                    b2 = scc2.nextBoolean ();
                                    if(b2) {
                                        System.out.println ("Veillez choisir la wilaya par le num qui correspond : ");
                                        System.out.println ("1 - wilaya1");
                                        System.out.println ("2 - wilaya2");
                                        System.out.println ("3 - wilaya3");

                                        Scanner scc22 = new Scanner (System.in);
                                        int indicewilaya;
                                        indicewilaya = scc22.nextInt ();
                                        switch (indicewilaya) {

                                            case 1:
                                                val[1] = "wilaya1";
                                                break;
                                            case 2:
                                                val[1] = "wilaya2";
                                                break;
                                            case 3:
                                                val[1] = "wilaya3";
                                                break;
                                        }
                                    }
                                    System.out.println ("Voulez vous introduire un prix max ? (true pour OUI , false pour NON)");
                                    Scanner scc3 = new Scanner (System.in);
                                    b3 = scc3.nextBoolean ();
                                    if(b3)
                                    {
                                        String lk;
                                        System.out.println ("Veillez introduire le prix max : ");
                                        Scanner scc32 = new Scanner (System.in);
                                        lk = scc32.nextLine ();
                                        val[2]=lk;
                                    }
                                    System.out.println ("Voulez vous introduire un prix min ? (true pour OUI , false pour NON)");
                                    Scanner scc4 = new Scanner (System.in);
                                    b4 = scc4.nextBoolean ();
                                    if(b4)
                                    {
                                        String lk;
                                        System.out.println ("Veuillez introduire le prix min : ");
                                        Scanner scc35 = new Scanner (System.in);
                                        lk = scc35.nextLine ();
                                        val[3]=lk;
                                    }
                                    System.out.println ("Voulez vous introduire le type du bien ? (true pour OUI , false pour NON)");
                                    Scanner scc5 = new Scanner (System.in);
                                    b5 = scc5.nextBoolean ();
                                    if(b5)
                                    {
                                        String lk;
                                        System.out.println ("Veillez introduire le type du bien : ");
                                        Scanner scc36 = new Scanner (System.in);
                                        lk = scc36.nextLine ();
                                        val[4]="class "+lk;
                                    }
                                    System.out.println ("Voulez vous introduire la superficie minimale  ? (true pour OUI , false pour NON)");
                                    Scanner scc6 = new Scanner (System.in);
                                    b6 = scc6.nextBoolean ();
                                    if(b6)
                                    {
                                        String lk;
                                        System.out.println ("Veillez introduire le superficie minimale : ");
                                        Scanner scc37 = new Scanner (System.in);
                                        lk = scc37.nextLine ();
                                        val[5]=lk;
                                    }
                                    System.out.println ("Voulez vous introduire le nombre minimal de pieces  ? (true pour OUI , false pour NON)");
                                    Scanner scc7 = new Scanner (System.in);
                                    b7 = scc7.nextBoolean ();
                                    if(b7)
                                    {
                                        String lk;
                                        System.out.println ("Veillez introduire le nombre minimal de pieces : ");
                                        Scanner scc38 = new Scanner (System.in);
                                        lk = scc38.nextLine ();
                                        val[6]=lk;
                                    }

                                    imoesi.recherche(ts0,val ,b1,b2,b3,b4,b5,b6,b7);

                                }break;



                                case 6 :
                                {
                                    System.out.println ("----- Afficher du prix d'un  bien -----");
                                    System.out.println ("Entrez le numero du bien a afficher : ");
                                    Scanner sc5 = new Scanner (System.in);
                                    int i5 = sc5.nextInt ();
                                    Iterator<Bien> it5 = ts0.iterator ();
                                    for (int j5 = 0; j5 < i5 - 1; j5++) {
                                        it5.next ();
                                    }
                                    Bien bien55 = it5.next ();

                                    Bien.Transaction transaction = bien5.getTransaction();
                                    switch (transaction) {
                                        case VENTE: System.out.println((long)bien55.calculer_prix_vente_final(bien55.getWilaya ())+" DA");break;
                                        case LOCATION :System.out.println((long)bien55.calculer_prix_location_final(bien55.getWilaya ())+" DA") ;break;
                                        case ECHANGE : System.out.print("Le prix du bien  (echange dans la meme wilaya) : " +(long)bien55.calculer_prix_echange_final(bien55.getWilaya (),bien55.getWilaya ())+" DA"+" , "); System.out.println("(echange dans une autre wilaya) : " +(long)bien55.calculer_prix_echange_final(bien55.getWilaya (),wilaya0)+" DA");break;


                                    }


                                }break;
                            }
                            System.out.println ("Voulez vous continuer ? (true pour OUI , false pour NON)");
                            Scanner sc_continu2 = new Scanner (System.in);
                            continu2 = sc_continu2.nextBoolean ();
                        }
                    }
                }
                System.out.println ("Voulez vous continuer vers le menu principal ? (true pour OUI , false pour NON)");
                Scanner sc_continu_principal = new Scanner (System.in);
                continu_principal = sc_continu_principal.nextBoolean ();
            }
        }
    }
        public static void envoyer_msg ( String msg, String client, String[][]message,int i)
        {

            message[i][0] = msg;
            message[i][1] = client;
        }
*/
    }
}
