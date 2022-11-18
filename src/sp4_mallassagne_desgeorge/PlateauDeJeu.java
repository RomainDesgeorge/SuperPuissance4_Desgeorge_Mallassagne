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
    public boolean presenceJeton(int x, int y){
        boolean verif = false;
        if (grille[x][y].presenceJeton() == true){
            verif = true;
        }
        return verif;
    }
    public String lireCouleurDuJeton(int x, int y){
        String couleur;
        couleur = grille[x][y].lireCouleurDuJeton();
        return couleur;
    }
    public boolean ligneGagnantePourCouleur(String couleur){
        boolean verif = false;
        int win = 0;
        int verif1 = 0;
        for (int i = 0;i<6;i++){
            for(int j = 0; j<7;j++){
                if (verif1 == 0){
                    if (grille[i][j].lireCouleurDuJeton()== couleur){
                        win+=1;
                    }else{
                        verif1 = 1;
                    }

                }
            }
        }
        return verif;
    }
}


