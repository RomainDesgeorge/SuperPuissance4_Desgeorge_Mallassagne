/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_mallassagne_desgeorge;

/**
 *
 * @author rom
 */
public class Jeton {
    private String couleur;
    public Jeton (String Couleur){
        couleur=Couleur;
    }

    public String getCouleur() {
        return couleur;
    }

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
