/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_mallassagne_desgeorge;

/**
 *
 * @author Alexis Mallassagne et Romain Desgeorgessss
 */
public class Jeton {
    private String couleur;
    public Jeton (String Couleur){
        couleur=Couleur;
    }
    /**
    * Permet de lire la couleur du jeton
    * @return la couleur de jeton
    */
    public String lireCouleur() {
        return couleur;
    }
/**
 * Affiche R si la couleur du jeton est rouge et affiche J si la couleur du jeton est jaune
 * @return 
 */
    @Override
    public String toString() {
        String color;
        if ("rouge".equals(couleur)){
            color="R";
        }
        else{
            color="J";
        }
        return color;
    }
    
    
}
