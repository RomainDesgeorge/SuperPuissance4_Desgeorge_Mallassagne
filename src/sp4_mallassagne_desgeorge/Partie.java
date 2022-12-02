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
    private Joueur[] listeJoueurs=new Joueur[2];//attributs
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
     * @return la liste des joueurs
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
            listeJoueurs[0].affecterCouleur("rouge");//donne une couleur au joueur
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
                Jeton jeton=new Jeton ("rouge");//donne 30 jetons de la couleur rouge au joueur si sa couleur est rouge
                j1.ajouterJeton(jeton);
            }
            
        }
        if ("jaune".equals(j1.getCouleur())){
            for (int i=0;i<31;i++){
                Jeton jeton=new Jeton ("jaune");//donne 30 jetons de la couleur jaune au joueur si sa couleur est jaune
                j1.ajouterJeton(jeton);
            }
            
        }
    }

    /**Place les trous noir et les desintegrateurs dans la disposition voulue
     *
     */
    public void placerTrousNoirsEtDesintegrateurs(){
        int i=0;
        while (i<3){//place 3 trous noirs et 3 désintegrateurs dans les mêmes cases aléatoirement
            int x=(int) (Math.random() * (6));//prends un chiffre aléatoirement entre 0 et 6
            int y=(int) (Math.random() * (5));//prends un chiffre aléatoirement entre 0 et 5
            if (plateau.presenceDesintegrateur(x,y)==false){//verification de la présence de trou noir ou de desintegrateur
                if (plateau.presenceTrouNoir(x,y)==false){
                    plateau.placerTrouNoir(x,y);//place le trou noir dans la case
                    plateau.placerDesintegrateur(x,y);//place le desintegrateur dans la case
                    i+=1;
                }
            }
                
        }
        while (i<5){//place 2 trous noirs dans des cases aléatoirement
            int x=(int) (Math.random() * (6));//prends un chiffre aléatoirement entre 0 et 6
            int y=(int) (Math.random() * (5));//prends un chiffre aléatoirement entre 0 et 5
            if (plateau.presenceDesintegrateur(x,y)==false){//verification de la présence de trou noir ou de desintegrateur
                if (plateau.presenceTrouNoir(x,y)==false){
                    plateau.placerTrouNoir(x,y);//place le trou noir dans la case
                    i+=1;
                }
            }
        }
        while(i<7){//place 2 desintegrateurs dans des cases aléatoirement
            int x=(int) (Math.random() * (6));//prends un chiffre aléatoirement entre 0 et 6
            int y=(int) (Math.random() * (5));//prends un chiffre aléatoirement entre 0 et 5
            if (plateau.presenceDesintegrateur(x,y)==false){//verification de la présence de trou noir ou de desintegrateur
                if (plateau.presenceTrouNoir(x,y)==false){
                    plateau.placerDesintegrateur(x,y);//place le desintegrateur dans la case
                    i+=1;
                }
            }
        }
    }

    /**Initialisation de la partie
     *
     */
    public void initialiserPartie(){
        attribuerCouleurAuxJoueurs();//donne les couleurs aux joueurs
        creerEtAffecterJeton(listeJoueurs[1]);//donne les 30 jetons aux 2 joueurs en fonction de leurs couleurs
        creerEtAffecterJeton(listeJoueurs[0]);
        placerTrousNoirsEtDesintegrateurs();//placement des trous noirs et des desintegrateurs sur le plateau
    }
    
    /**Permet de lancer la partie et de jouer au SuperPuissance4
     *
     */
    public void lancerPartie(){
        int n=0;
        joueurCourant = listeJoueurs[0];//initialisation de joueurCourant
        while(plateau.etreGagnantePourCouleur(joueurCourant.getCouleur()) == false){//On joue tant il n'y a pas de gagnant
            plateau.afficherGrilleSurConsole();//affichage de la grille
            if (n%2 == 0){//si n est pair le joueurCourant est le premier joueur, ce systeme permet de changer de jouer à chaque tour
                joueurCourant = listeJoueurs[0];
                int choix = 10;
                Scanner reponse = new Scanner (System.in);
                while (choix>3 || choix<1){// permet d'avoir des réponses seulement entre 1 et 3 inclus
                System.out.println("Que voulez vous faire, si vous voulez jouer un jeton tapez '1'\nsi vous voulez recuperer un jeton, tapez '2' \nsi vous voulez utiliser un desintegrateur, tapez'3'");
                    choix = reponse.nextInt();//choix entre jouer le jeton, retirer le jeton et utiliser un désintegrateur
                }
                if (choix == 1){//Jouer le jeton
                    int cln=10;
                    Scanner colonne = new Scanner (System.in);
                    while (cln>7 || cln<0){//permet de récuperer une valeur logique pour les colonnes
                        System.out.println("Dans quelle colonne voulez vous placer votre jeton");//demande du placement du jeton
                        cln = colonne.nextInt();
                    }
                    int a = plateau.ajouterJetonDansColonne(joueurCourant.jouerJeton(), cln-1);//placement du jeton
                    if(plateau.presenceDesintegrateur(cln-1,a) == true){//verification de la présence d'un désintegrateur
                        joueurCourant.obtenirDesintegrateur();//récuperation du désintegrateur si il y en a un pour le joueurCourant
                        plateau.supprimerDesintegrateur(cln-1, a);//suppression du désintegrateur après la récuperation
                        System.out.println("Vous avez récupéré un desintegrateur!");//message de confirmation
                        
                    }
                    if(plateau.presenceTrouNoir(cln-1,a) == true){//verification de la présence d'un trou noir
                        plateau.supprimerJeton(cln-1, a);//suppression du jeton si il y a un trou noir
                        plateau.supprimerTrouNoir(cln-1, a);//suppression du trou noir
                    }
                    
                }
                if (choix == 2){//récuperation du jeton
                    int cln=10;
                    int lgn=10;
                    Scanner colonne = new Scanner (System.in);
                    Scanner ligne = new Scanner (System.in);
                    while (cln>7 || cln<0){//permet de récuperer une valeur logique pour les colonnes
                        System.out.println("De quelle colonne voulez vous récupérer votre jeton");
                        cln = colonne.nextInt();
                    }
                    while (lgn>6){//permet de récuperer une valeur logique pour les lignes
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
                    while (cln>7 || cln<0){
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
                    while (cln>7 || cln<0){
                        System.out.println("Dans quelle colonne voulez vous placer votre jeton");
                        cln = colonne.nextInt();
                    }
                    int a = plateau.ajouterJetonDansColonne(joueurCourant.jouerJeton(), cln-1);
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
                    while (cln>7 || cln<0){
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
                    while (cln>7 || cln<0){
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
    }

}
