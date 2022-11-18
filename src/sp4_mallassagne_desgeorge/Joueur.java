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
    ArrayList <Jeton> reserveJetons=new ArrayList<>();
    String couleur;
    int nombreJetonsRestants;
    int nombreDesintegrateurs=0;
    //nombreJetonsRestants=reserveJetons.size();
    public Joueur (String Nom){
        nom=Nom;       
    }
    public String affecterCouleur(String Couleur){
        return Couleur;
    }
    public void ajouterJeton(Jeton ajoutjeton){
        nombreJetonsRestants +=1;
        reserveJetons.add(ajoutjeton);
    }
    public void obtenirDesintegrateur(){
        nombreDesintegrateurs+=1;
    }
    public void utiliserDesintegrateur(){
        nombreDesintegrateurs-=1;
        System.out.println("Le désintegrateur a bien été utilisé");
    }
}
