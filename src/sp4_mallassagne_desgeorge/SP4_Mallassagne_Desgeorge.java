/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_mallassagne_desgeorge;


/**
 *
 * @author Alexis Mallassagne et Romain Desgeorge
 */
public class SP4_Mallassagne_Desgeorge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Joueur joueur1 = new Joueur("joueur1");
        Joueur joueur2 = new Joueur("joueur2");
        Partie partie = new Partie(joueur1,joueur2);
        partie.initialiserPartie();
        partie.lancerPartie();
        
    }
    
}
