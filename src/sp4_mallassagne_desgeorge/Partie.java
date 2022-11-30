package sp4_mallassagne_desgeorge;


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
 * @author xelat
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
    }

    public Joueur[] getListeJoueurs() {
        return listeJoueurs;
    }
    
    public void attribuerCouleurAuxJoueurs(){
        int valeur=(int) (Math.random() * (5-3));
        if (valeur==0){
            listeJoueurs[0].affecterCouleur("rouge");
            listeJoueurs[1].affecterCouleur("jaune");
        }
        else{
            listeJoueurs[0].affecterCouleur("jaune");
            listeJoueurs[1].affecterCouleur("rouge");
        }
        
    }
    public void creerEtAffecterJeton(Joueur j1){
        if (j1.getCouleur()=="rouge"){
            for (int i=0;i<31;i++){
                Jeton jeton=new Jeton ("rouge");
                j1.ajouterJeton(jeton);
            }
            
        }
    }
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
    public void initialiserPartie(){
        attribuerCouleurAuxJoueurs();
        creerEtAffecterJeton(listeJoueurs[1]);
        creerEtAffecterJeton(listeJoueurs[0]);
        placerTrousNoirsEtDesintegrateurs();
    }
    
    public void lancerPartie(){
        while(plateau.etreGagnantePourCouleur(joueurCourant.getCouleur()) == false){
            int n=0;
            if (n%2 == 0){
                
            }
            if (n%2 == 1){
                
            }        
        }
    }

}
