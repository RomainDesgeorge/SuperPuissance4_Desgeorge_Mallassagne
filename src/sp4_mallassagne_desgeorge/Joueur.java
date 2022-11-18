/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_mallassagne_desgeorge;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Alexis
 */
public class Joueur {
    private String nom;
    public Joueur (String Nom, String Couleur, ArrayList reserveJetons, int nombreJetonsRestants, int nombreDesintegrateurs){
        nom=Nom;
        nombreJetonsRestants=reserveJetons.size();
    }
}
