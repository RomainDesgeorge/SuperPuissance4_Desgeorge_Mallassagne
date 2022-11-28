/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_mallassagne_desgeorge;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Alexis Mallassagne et Romain Desgeorgesssss
 */
public class Joueur {
    private String nom;
    private ArrayList <Jeton> reserveJetons=new ArrayList<>();
    private String couleur;
    int nombreJetonsRestants=reserveJetons.size();
    int nombreDesintegrateurs=0;
    
    /**
     *Constructeur Joueur récupère le Nom du joueur
     * @param Nom
     */
    public Joueur (String Nom){
        nom=Nom;     
        nombreDesintegrateurs=0;
    }

    /**
     *Prend la couleur du joueur et la retourne
     * @param Couleur
     * @return
     */
    public void affecterCouleur(String Couleur){
        couleur=Couleur;
    }

    /**
     *recupère la reserve de jetons
     * @return
     */
    public ArrayList<Jeton> getReserveJetons() {
        return reserveJetons;
    }
    public Jeton jouerJeton(){
        Jeton jeton;
        jeton=reserveJetons.get(0);
        reserveJetons.remove(0) ;
        return jeton;
    }
    /**
     *Prend un jeton en entrée et l'ajoute dans le Tableau reserveJetons
     * @param ajoutjeton
     */
    public void ajouterJeton(Jeton ajoutjeton){
        reserveJetons.add(ajoutjeton);
        

    }

    /**
     *Recupère la couleur
     * @return
     */
    public String getCouleur() {
        return couleur;
    }


    /**
     *Retourne le nombre de jetons restants (ça actualise la valeur)
     * @return
     */
    public int TailleTabJeton(){
        return nombreJetonsRestants=reserveJetons.size();
    }

    /**
     *Ajoute 1 au nombre de Desintegrateurs
     */
    public void obtenirDesintegrateur(){
        nombreDesintegrateurs+=1;
    }

    /**
     *Soustrait 1 au nombre de Desintegrateurs
     */
    public void utiliserDesintegrateur(){
        nombreDesintegrateurs-=1;
        System.out.println("Le désintegrateur a bien été utilisé.");
    }
}
