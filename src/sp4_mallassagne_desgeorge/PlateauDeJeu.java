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
    CelluleDeGrille[][] grille = new CelluleDeGrille [7][6];
 
    public void PlateauDeJeu(){
        for (int i=0;i<6;i++){
            for (int j=0; j<7;j++){
                grille[j][i] = new CelluleDeGrille();
            }
        }
    }
    public void ajouterJetonDansColonne(Jeton jeton, int nb){
        int nbligne = 0;
        for(int i=0;i<7;i++){
            if (grille[nb][i] != null){
                nbligne += 1;
            }else{
                break;
            }
        grille[nb][nbligne].affecterJeton(jeton);   
        }

    }    
    public boolean grilleRemplie(){
        boolean verif = true;
        for (int i=0;i<6;i++){
            for (int j=0; j<7;j++){
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
                    if (grille[j][i].lireCouleurDuJeton().equals(couleur)){
                        if (grille[j][i+1].lireCouleurDuJeton().equals(couleur)){
                            if (grille[j][i+2].lireCouleurDuJeton().equals(couleur)){
                                if (grille[j][i+3].lireCouleurDuJeton().equals(couleur)){
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
                    if (grille[j][i].lireCouleurDuJeton().equals(couleur)){
                        if (grille[j+1][i].lireCouleurDuJeton().equals(couleur)){
                            if (grille[j+2][i].lireCouleurDuJeton().equals(couleur)){
                                if (grille[j+3][i].lireCouleurDuJeton().equals(couleur)){
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
                    if (grille[j][i].lireCouleurDuJeton().equals(couleur)){
                        if (grille[j+1][i+1].lireCouleurDuJeton().equals(couleur)){
                            if (grille[j+2][i+2].lireCouleurDuJeton().equals(couleur)){
                                if (grille[j+3][i+3].lireCouleurDuJeton().equals(couleur)){
                                   win = 1; 
                                }
                            }
                        }
                    }
        for (int a = 3;a<7;a++){
            for(int b = 0; b<3;b++){
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
        for (int i = 0;i<4;i++){
            for(int j = 3; j<6;j++){
                    if (grille[i][j].lireCouleurDuJeton().equals(couleur)){
                        if (grille[i-1][j+1].lireCouleurDuJeton().equals(couleur)){
                            if (grille[i-2][j+2].lireCouleurDuJeton().equals(couleur)){
                                if (grille[i-3][j+3].lireCouleurDuJeton().equals(couleur)){
                                   win = 1; 
                                }
                            }
                        }
                    }
        for (int a = 3;a<7;a++){
            for(int b = 3; b<6;b++){
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
        
        } 
    }

    return verif;
    }
    public void tasserLigne(int ligne){
        for (int i=0;i<5;i++){
            if (grille[ligne][i]==null){
                if (grille[ligne][i+1] != null){
                    grille[ligne][i] = grille[i+1][ligne];
                    grille[ligne][i+1] = null;
                }
            }
        }
    }
    public boolean colonneRemplie(int colonne){
        boolean verif = true;
        for (int i=0;i<7;i++){
                if (grille[i][colonne] == null){
                    verif = false;
                    break;
                }
            }
    return verif;    
    }
    
    public void placerTrouNoir(int x, int y){
        grille[x][y].placerTrouNoir();        
    }
    
    public void supprimerTrouNoir(int x, int y){
        grille[x][y].supprimerTrouNoir();        
    }
    
    public void placerDesintegrateur(int x, int y){
        grille[x][y].placerDesintegrateur();        
    }
    
    public void supprimerJeton(int x, int y){
        grille[x][y].supprimerJeton();        
    }
    
    public void recupererJeton(int x, int y){
        grille[x][y].recupererJeton();        
    }
    public void viderGrille(Joueur joueur1, Joueur joueur2){
    String couleur;
    Jeton jeton;
        for(int i=0;i<7;i++){
            for(int j=0;j<6;j++){
                if(grille[i][j].presenceJeton() == true){
                    couleur = lireCouleurDuJeton(i,j);
                    jeton = grille[i][j].recupererJeton();
                    if(joueur1.getCouleur().equals(couleur)){
                        joueur1.ajouterJeton(jeton);
                    }else{
                        joueur2.ajouterJeton(jeton);
                    }
                }
            }
        }
    }
    public void afficherGrilleSurConsole(){
        for(int i=0;i<7;i++){
            for(int j=0;j<6;j++){
                if(grille[i][j].presenceJeton() == true){
                    System.out.println("["+grille[i][j].lireCouleurDuJeton()+"]");
                }else{
                    System.out.println("["+null+"]");
                }if(j==6){
                    System.out.println("\n");
                }
            }
        }
    }
    
}
