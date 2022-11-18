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
    public void placerTrouNoir(){
        avoirTrouNoir = true;
    }
    public void supprimerTrouNoir(){
        avoirTrouNoir = false;
    }
    public boolean presenceTrouNoir(){
        boolean verif = false;
        if (avoirTrouNoir == true){
            verif = true;            
        }
        return verif;
    }
    public Jeton recupererJeton(){
        Jeton jetonarecup = null;
        if (jetonCourant != null){
            jetonarecup = jetonCourant;
            jetonCourant = null;
        }
        return jetonarecup;
    }
    public void supprimerJeton(){
        jetonCourant = null;
    }
    public boolean presenceDesintegrateur(){
        boolean verif = false;
        if (avoirDesintegrateur == true){
            verif = true;
        }else{
            verif = false;
        }
        return verif;        
    }
    public void placerDesintegrateur(){
        avoirDesintegrateur = true;
    }
    public void supprimerDesintegrateur(){
        avoirDesintegrateur = false;
    }
    
    
}
