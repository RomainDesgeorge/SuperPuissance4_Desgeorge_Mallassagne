/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_mallassagne_desgeorge;

/**
 *
 * @author rom
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
    
    public boolean presenceJeton(){
        boolean verif = false;
        if(jetonCourant != null){
            verif = true;            
        }
        return verif;
    }
    public void affecterJeton(Jeton jeton){  
        jetonCourant = jeton;
    } 
    public String lireCouleurDuJeton(){
        String couleur;
        if(jetonCourant != null){
            if ("r".equals(jetonCourant.toString())){
                couleur = "rouge";
            }else{
                couleur = "jaune";
            }
        }else{
            couleur = null;
        }
        return couleur;
    }
    public void placeTrouNoir(){
        avoirTrouNoir = true;
    }
    public void supprimeTrouNoir(){
        avoirTrouNoir = false;
    }
}
