/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_mallassagne_desgeorge;

import java.util.Scanner;

/**
 *
 * @author Alexis Mallassagne et Romain Desgeorge
 */
public class SP4_Mallassagne_Desgeorge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String Nom_joueur1;
        String Nom_joueur2;
        Scanner Nom1 = new Scanner(System.in);
        Scanner Nom2 = new Scanner(System.in);
        System.out.println("Joueur 1, Rentrez votre nom");
        Nom_joueur1 = Nom1.next();
        System.out.println("Joueur 2, Rentrez votre nom");
        Nom_joueur2 = Nom2.next();
        Joueur joueur1 = new Joueur(Nom_joueur1);//création des 2 joueurs
        Joueur joueur2 = new Joueur(Nom_joueur2);
        Partie partie = new Partie(joueur1, joueur2);//création d'une nouvelle partie prenant en paramètres les 2 joueurs
        partie.initialiserPartie();//initialisation de la partie
        partie.lancerPartie(); //lancement de la partie

    }

}
