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
        for (int i = 0;i<6;i++){
            for(int j = 0; j<4;j++){
                    if (grille[i][j].lireCouleurDuJeton().equals(couleur)){
                        if (grille[i][j+1].lireCouleurDuJeton().equals(couleur)){
                            if (grille[i][j+2].lireCouleurDuJeton().equals(couleur)){
                                if (grille[i][j+3].lireCouleurDuJeton().equals(couleur)){
                                   win = 1; 
                                }
                            }
                        }
                    }
                    if (win == 1){
                        verif = true;
                        break;
                    }
            }
        }
        return verif;
    }
    public boolean colonneGagnantePourCouleur(String couleur){
        boolean verif = false;
        int win = 0;
        for (int i = 0;i<3;i++){
            for(int j = 0; j<7;j++){
                    if (grille[i][j].lireCouleurDuJeton().equals(couleur)){
                        if (grille[i+1][j].lireCouleurDuJeton().equals(couleur)){
                            if (grille[i+2][j].lireCouleurDuJeton().equals(couleur)){
                                if (grille[i+2][j].lireCouleurDuJeton().equals(couleur)){
                                   win = 1; 
                                }
                            }
                        }
                    }
                    if (win == 1){
                        verif = true;
                        break;
                    }
            }
        }
        return verif;
    }
    public boolean diagonaleMontanteGagnantePourCouleur(String couleur){
        boolean verif = false;
        int win = 0;
        for (int i = 0;i<3;i++){
            for(int j = 0; j<4;j++){
                    if (grille[i][j].lireCouleurDuJeton().equals(couleur)){
                        if (grille[i+1][j+1].lireCouleurDuJeton().equals(couleur)){
                            if (grille[i+2][j+2].lireCouleurDuJeton().equals(couleur)){
                                if (grille[i+3][j+3].lireCouleurDuJeton().equals(couleur)){
                                   win = 1; 
                                }
                            }
                        }
                    }
        for (int a = 0;a<3;a++){
            for(int b = 3; b<7;b++){
                    if (grille[a][b].lireCouleurDuJeton().equals(couleur)){
                        if (grille[a+1][b-1].lireCouleurDuJeton().equals(couleur)){
                            if (grille[a+2][b-2].lireCouleurDuJeton().equals(couleur)){
                                if (grille[a+3][b-3].lireCouleurDuJeton().equals(couleur)){
                                   win = 1; 
                                }
                            }
                        }
                    }
                    if (win == 1){
                        verif = true;
                        break;
                    }
            }
        }
        return verif;
    }

    /**
     *
     * @param couleur
     * @return
     */
    public boolean diagonaleDescendanteGagnantePourCouleur(String couleur){
        boolean verif = false;
        int win = 0;
        for (int i = 3;i<6;i++){
            for(int j = 0; j<4;j++){
                    if (grille[i][j].lireCouleurDuJeton().equals(couleur)){
                        if (grille[i-1][j+1].lireCouleurDuJeton().equals(couleur)){
                            if (grille[i-2][j+2].lireCouleurDuJeton().equals(couleur)){
                                if (grille[i-3][j+3].lireCouleurDuJeton().equals(couleur)){
                                   win = 1; 
                                }
                            }
                        }
                    }
        for (int a = 3;a<6;a++){
            for(int b = 3; b<7;b++){
                    if (grille[a][b].lireCouleurDuJeton().equals(couleur)){
                        if (grille[a-1][b-1].lireCouleurDuJeton().equals(couleur)){
                            if (grille[a-2][b-2].lireCouleurDuJeton().equals(couleur)){
                                if (grille[a-3][b-3].lireCouleurDuJeton().equals(couleur)){
                                   win = 1; 
                                }
                            }
                        }
                    }
                    if (win == 1){
                        verif = true;
                        break;
                    }
            }
        }
        return verif;
    } 
}



