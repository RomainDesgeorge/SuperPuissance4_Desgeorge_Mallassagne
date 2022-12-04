package sp4_mallassagne_desgeorge;


import java.util.Scanner;
import sp4_mallassagne_desgeorge.Jeton;
import sp4_mallassagne_desgeorge.Joueur;
import sp4_mallassagne_desgeorge.PlateauDeJeu;
import sp4_mallassagne_desgeorge.CelluleDeGrille;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alexis Mallassagne et Romain Desgeorge
 */
public class Partie {
    private Joueur[] listeJoueurs=new Joueur[2];
    private Joueur joueurCourant;
    private PlateauDeJeu plateau;

    /**
     *Constructeur Partie
     * @param joueur1
     * @param joueur2
     */
    public Partie (Joueur joueur1,Joueur joueur2){
        listeJoueurs[0]=joueur1;
        listeJoueurs[1]=joueur2;
        plateau=new PlateauDeJeu();
    }

    /**Recupere la liste des joueurs
     *
     * @return
     */
    public Joueur[] getListeJoueurs() {
        return listeJoueurs;
    }
    
    /**Affecte une couleur aux joueurs aléatoirement
     *
     */
    public void attribuerCouleurAuxJoueurs(){
        int valeur=(int) (Math.random() * (2));
        if (valeur==0){
            listeJoueurs[0].affecterCouleur("rouge");
            listeJoueurs[1].affecterCouleur("jaune");
        }
        else{
            listeJoueurs[0].affecterCouleur("jaune");
            listeJoueurs[1].affecterCouleur("rouge");
        }
        
    }

    /**Crée 30 jetons puis les insere dans le tableau reserve jetons du joueur
     *
     * @param j1
     */
    public void creerEtAffecterJeton(Joueur j1){
        if ("rouge".equals(j1.getCouleur())){
            for (int i=0;i<31;i++){
                Jeton jeton=new Jeton ("rouge");
                j1.ajouterJeton(jeton);
            }
            
        }
        if ("jaune".equals(j1.getCouleur())){
            for (int i=0;i<31;i++){
                Jeton jeton=new Jeton ("jaune");
                j1.ajouterJeton(jeton);
            }
            
        }
    }

    /**Place les trous noir et les desintegrateurs dans la disposition voulue
     *
     */
    public void placerTrousNoirsEtDesintegrateurs(){
        int i=0;
        while (i<3){
            int x=(int) (Math.random() * (9-3));
            int y=(int) (Math.random() * (8-3));
            if (plateau.presenceDesintegrateur(x,y)==false){
                if (plateau.presenceTrouNoir(x,y)==false){
                    plateau.placerTrouNoir(x,y);
                    plateau.placerDesintegrateur(x,y);
                    i+=1;
                }
            }
                
        }
        while (i<5){
            int x=(int) (Math.random() * (9-3));
            int y=(int) (Math.random() * (8-3));
            if (plateau.presenceDesintegrateur(x,y)==false){
                if (plateau.presenceTrouNoir(x,y)==false){
                    plateau.placerTrouNoir(x,y);
                    i+=1;
                }
            }
        }
        while(i<7){
            int x=(int) (Math.random() * (9-3));
            int y=(int) (Math.random() * (8-3));
            if (plateau.presenceDesintegrateur(x,y)==false){
                if (plateau.presenceTrouNoir(x,y)==false){
                    plateau.placerDesintegrateur(x,y);
                    i+=1;
                }
            }
        }
    }

    /**Initialisation de la partie
     *
     */
    public void initialiserPartie(){
        attribuerCouleurAuxJoueurs();
        creerEtAffecterJeton(listeJoueurs[1]);
        creerEtAffecterJeton(listeJoueurs[0]);
        placerTrousNoirsEtDesintegrateurs();
    }
    
    public void lancerPartie(){
        int n=0;
        joueurCourant = listeJoueurs[0];
        while(plateau.etreGagnantePourCouleur(joueurCourant.getCouleur()) == false){
            plateau.afficherGrilleSurConsole();
            if (n%2 == 0){
                joueurCourant = listeJoueurs[0];
                int choix = 10;
                Scanner reponse = new Scanner (System.in);
                while (choix>3 || choix<1){
                System.out.println("Que voulez vous faire, si vous voulez jouer un jeton tapez '1'\nsi vous voulez récupérer un jeton, tapez '2' \nsi vous voulez utiliser un désintegrateur, tapez'3'");
                    choix = reponse.nextInt();
                }
                if (choix == 1){
                    int cln=10;
                    Scanner colonne = new Scanner (System.in);
                    while (cln>7){
                        System.out.println("Dans quelle colonne voulez vous placer votre jeton");
                        cln = colonne.nextInt();
                    }
                    int a = plateau.ajouterJetonDansColonne(joueurCourant, cln-1);
                    if(plateau.presenceDesintegrateur(cln-1,a) == true){
                        joueurCourant.obtenirDesintegrateur();
                        plateau.supprimerDesintegrateur(cln-1, a);
                        System.out.println("Vous avez récupéré un désintegrateur!");
                        
                    }
                    if(plateau.presenceTrouNoir(cln-1,a) == true){
                        plateau.supprimerJeton(cln-1, a);
                        plateau.supprimerTrouNoir(cln-1, a);
                    }
                    
                }
                if (choix == 2){
                    int cln=10;
                    int lgn=10;
                    Scanner colonne = new Scanner (System.in);
                    Scanner ligne = new Scanner (System.in);
                    while (cln>7){
                        System.out.println("De quelle colonne voulez vous récupérer votre jeton");
                        cln = colonne.nextInt();
                    }
                    while (lgn>6){
                        System.out.println("De quelle ligne voulez vous récuprer votre jeton");
                        lgn = ligne.nextInt();
                    }
                    
                    plateau.recupererJeton(cln-1, lgn-1);
                    
                }
                if (choix == 3){
                    int cln=10;
                    int lgn=10;
                    if (joueurCourant.getNombreDesintegrateurs()==0){
                        System.out.println("Le joueur n'a pas de désintegrateurs");
                        continue;
                    }
                    Scanner colonne = new Scanner (System.in);
                    Scanner ligne = new Scanner (System.in);
                    while (cln>7){
                        System.out.println("Dans quelle colonne voulez vous placer votre jeton");
                        cln = colonne.nextInt();
                    }
                    while (lgn>6){
                        System.out.println("Dans quelle ligne voulez vous placer votre jeton");
                        lgn = ligne.nextInt();
                    }
                    plateau.utiliserDesintegrateur(cln-1, lgn-1,joueurCourant);
                    plateau.tasserLigne(cln-1);
                    
                }               
            }
            if (n%2 == 1){
                joueurCourant = listeJoueurs[1];
                int choix = 10;                
                Scanner reponse = new Scanner (System.in);
                while (choix>3 || choix<1){
                    System.out.println("Que voulez vous faire, si vous voulez jouer un jeton tapez '1'\nsi vous voulez récupérer un jeton, tapez '2' \nsi vous voulez utiliser un désintegrateur, tapez'3'");
                choix = reponse.nextInt();
                }
                if (choix == 1){
                    int cln=10;
                    Scanner colonne = new Scanner (System.in);
                    while (cln>7){
                        System.out.println("Dans quelle colonne voulez vous placer votre jeton");
                        cln = colonne.nextInt();
                    }
                    int a = plateau.ajouterJetonDansColonne(joueurCourant, cln-1);
                    if(plateau.presenceDesintegrateur(cln-1, a) == true){
                        joueurCourant.obtenirDesintegrateur();
                        plateau.supprimerDesintegrateur(cln-1, a);
                        System.out.println("Vous avez récupéré un désintegrateur!");
                        plateau.tasserLigne(cln-1);
                        
                    }
                    if(plateau.presenceTrouNoir(cln-1, a) == true){
                        plateau.supprimerJeton(cln-1, a);
                        plateau.supprimerTrouNoir(cln-1, a);
                    }
                    
                }
                if (choix == 2){
                    int cln=10;
                    int lgn=10;
                    Scanner colonne = new Scanner (System.in);
                    Scanner ligne = new Scanner (System.in);
                    while (cln>7){
                        System.out.println("De quelle colonne voulez vous récupérer votre jeton");
                        cln = colonne.nextInt();
                    }
                    while (lgn>6){
                        System.out.println("De quelle ligne voulez vous récuprer votre jeton");
                        lgn = ligne.nextInt(); 
                    }
                    
                    plateau.recupererJeton(cln-1, lgn-1);
                    
                }
                if (choix == 3){
                    int cln=10;
                    int lgn=10;
                    if (joueurCourant.getNombreDesintegrateurs()==0){
                        System.out.println("Le joueur n'a pas de désintegrateurs");
                        continue;
                    }
                    Scanner colonne = new Scanner (System.in);
                    Scanner ligne = new Scanner (System.in);
                    while (cln>7){
                        System.out.println("Dans quelle colonne voulez vous utiliser votre desintegrateur");
                        cln = colonne.nextInt();
                    }
                    while (lgn>6){
                        System.out.println("Dans quelle ligne voulez vous utiliser votre desintegrateur");
                        lgn = ligne.nextInt();
                    }
                    plateau.utiliserDesintegrateur(cln-1, lgn-1,joueurCourant);
                    plateau.tasserLigne(cln-1);
                    
                }               
                
            }
            n +=1;
        }
        plateau.afficherGrilleSurConsole();
        plateau.viderGrille(joueurCourant, joueurCourant);
    }

}
