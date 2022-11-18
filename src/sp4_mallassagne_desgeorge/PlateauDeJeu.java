/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_mallassagne_desgeorge;

/**
 *
 * @author rom
 */
public class PlateauDeJeu {
    CelluleDeGrille[][] grille = new CelluleDeGrille [6][7];
 
    public void PlateauDeJeu(){
        for (int i=0;i<7;i++){
            for (int j=0; j<6;j++){
                grille[j][i] = new CelluleDeGrille();
            }
        }
    }
    public void ajouterJetonDansColonne(Jeton jeton, int nb){
        int nbligne = 0;
        for(int i=0;i<6;i++){
            if (grille[i][nb] != null){
                nbligne += 1;
            }else{
                break;
            }
        grille[nbligne][nb].affecterJeton(jeton);   
        }

    }    
    public boolean grilleRemplie(){
        boolean verif = true;
        for (int i=0;i<7;i++){
            for (int j=0; j<6;j++){
                if (grille[j][i] == null){
                    verif = false;
                    break;
                }
            }
        }
        return verif;
    }
}


