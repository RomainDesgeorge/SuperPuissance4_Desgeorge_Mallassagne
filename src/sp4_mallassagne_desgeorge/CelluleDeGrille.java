/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_mallassagne_desgeorge;

/**
 *
 * @author Alexis Mallassagne et Romain Desgeorgessss
 */
public class CelluleDeGrille {
    public CelluleDeGrille(){
        jetonCourant = null;
        avoirTrouNoir = false;
        avoirDesintegrateur = false;

    
}
    private Jeton jetonCourant;
    private boolean avoirTrouNoir;
    private boolean avoirDesintegrateur;
    
    /**
     *Verifie la présence d'un jeton dans la cellule
     * @return
     */
    public boolean presenceJeton(){
        boolean verif = false;
        if(jetonCourant != null){
            verif = true;            
        }
        return verif;
    }

    /**
     *Ajout du jeton dans la cellule
     * @param jeton
     */
    public void affecterJeton(Jeton jeton){  
        jetonCourant = jeton;
    } 

    /**
     *Lis la couleur du jeton dans la cellule
     * @return la couleur du jeton
     */
    public String lireCouleurDuJeton(){
        String couleur;
        if(jetonCourant != null){
            if ("R".equals(jetonCourant.toString())){
                couleur = "rouge";
            }else{
                couleur = "jaune";
            }
        }else{
            couleur = null;
        }
        return couleur;
    }

    /**Donne la valeur true à la variable avoirTrouNoir
     * Met un trou noir dans la cellule
     *
     */
    public void placerTrouNoir(){
        avoirTrouNoir = true;
    }

    /**Donne la valeur false à la variable avoirTrouNoir
     * Enleve le trou noir de la cellule
     *
     */
    public void supprimerTrouNoir(){
        avoirTrouNoir = false;
    }

    /**Verifie la présence d'un trou noir dans la cellule
     *
     * @return true ou false en fonction de la présence d'un trou noir
     */
    public boolean presenceTrouNoir(){
        boolean verif = false;
        if (avoirTrouNoir == true){
            verif = true;            
        }
        return verif;
    }

    /**Vide la case et retourne le jeton enlevé
     *
     * @return
     */
    public Jeton recupererJeton(){
        Jeton jetonarecup = null;
        if (jetonCourant != null){
            jetonarecup = jetonCourant;
            jetonCourant = null;
        }
        return jetonarecup;
    }

    /**Vide la case de son jeton (supprime le jeton)
     *
     */
    public void supprimerJeton(){
        jetonCourant = null;
    }

    /**Verifie la présence d'un desintegrateur dans la cellule
     *
     * @return true ou false en fonction de la présence d'un desintegrateur
     */
    public boolean presenceDesintegrateur(){
        boolean verif;
        if (avoirDesintegrateur == true){
            verif = true;
        }else{
            verif = false;
        }
        return verif;        
    }

    /**Met un desintegrateur dans la cellule
     *
     */
    public void placerDesintegrateur(){
        avoirDesintegrateur = true;
    }

    /**Supprime le desintegrateur de la cellule
     *
     */
    public void supprimerDesintegrateur(){
        avoirDesintegrateur = false;
    }

    /**Active le trou noir donc supprime le jeton et le trou noir
     *
     */
    public void activerTrouNoir(){
        supprimerJeton();
        supprimerTrouNoir();
    }
    
}
