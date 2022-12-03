/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_mallassagne_desgeorge;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author rom
 */
public class CelluleGraphique extends JButton {
    CelluleDeGrille celluleassociee;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_jetonJaune = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_jetonRouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_trouNoir = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));
    
    public CelluleGraphique(CelluleDeGrille uneCellule){
        celluleassociee = uneCellule;
    }
    
    @Override
    public void paintComponent (Graphics G){
        super.paintComponent(G);
        if (celluleassociee.presenceTrouNoir() == true){
            setIcon(img_trouNoir);
        }
        else if (celluleassociee.presenceDesintegrateur() == true){
            setIcon(img_desint);
        }
        else{
            String couleur_jeton = celluleassociee.lireCouleurDuJeton();
            switch(couleur_jeton){
                case "jaune":
                    setIcon(img_jetonJaune);
                    break;
                case "rouge":
                    setIcon(img_jetonRouge);
                    break;
                case "rien":
                    setIcon(img_vide);
                    break;
                  
            }
        }
    }
}
