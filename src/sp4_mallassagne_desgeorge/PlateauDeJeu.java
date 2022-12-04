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
 
    public  PlateauDeJeu(){
        for (int i=0;i<6;i++){
            for (int j=0; j<7;j++){
                grille[j][i] = new CelluleDeGrille();
            }
        }
    }
    public int ajouterJetonDansColonne(Joueur joueur1, int nb){
        int nbligne = 0;
        Jeton un_jeton = joueur1.jouerJeton();
        for(int i=0;i<5;i++){
            if (grille[nb][i].lireCouleurDuJeton() != "rien"){
                nbligne += 1;
            }else{
                break;
            }   
        }
        if (grille[nb][nbligne].presenceDesintegrateur() == true){
            grille[nb][nbligne].affecterJeton(un_jeton);
            grille[nb][nbligne].placerDesintegrateur();
        }else{
        grille[nb][nbligne].affecterJeton(un_jeton);
        }
        return nbligne;
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
        for (int i = 0;i<3;i++){
            for(int j = 0; j<7;j++){
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
        for (int i = 0;i<6;i++){
            for(int j = 0; j<4;j++){
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
            for(int b = 3; b<6;b++){
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
        for (int i = 4;i<7;i++){
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
    
    public boolean etreGagnantePourCouleur(String couleur){
        boolean verif;
        verif = ligneGagnantePourCouleur(couleur);
        if(verif == false){
            verif = colonneGagnantePourCouleur(couleur);
            if(verif == false){
                verif = diagonaleDescendanteGagnantePourCouleur(couleur);
                if (verif == false){
                    verif = diagonaleMontanteGagnantePourCouleur(couleur);
                }
            }
        }
        return verif;
    }
    public void tasserLigne(int ligne){
        for (int i=0;i<5;i++){
            Jeton jetonrecup;
            if (grille[ligne][i].lireCouleurDuJeton() == "rien"){
                if (grille[ligne][i+1].lireCouleurDuJeton() != "rien"){
                    jetonrecup = grille[ligne][i+1].recupererJeton();
                    grille[ligne][i].affecterJeton(jetonrecup);
                    grille[ligne][i+1].supprimerJeton();
                }
            }
        }
    }
    public boolean colonneRemplie(int colonne){
        boolean verif = true;
        for (int i=0;i<6;i++){
                if (grille[colonne][i].lireCouleurDuJeton() == "rien"){
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
    
    public void supprimerDesintegrateur(int x, int y){
        grille[x][y].supprimerDesintegrateur();        
    }
    
    public void placerDesintegrateur(int x, int y){
        grille[x][y].placerDesintegrateur();        
    }
    
    public boolean presenceDesintegrateur(int x, int y){
        boolean verif1=false;
        if(grille[x][y].presenceDesintegrateur()==true){
            verif1 = true;
        }
        return verif1;        
    }
    
    public void utiliserDesintegrateur(int x,int y,Joueur joueur){
        grille[x][y].supprimerJeton();
        joueur.utiliserDesintegrateur();
    }
    
    public boolean presenceTrouNoir(int x, int y){
        boolean verif1=false;
        if(grille[x][y].presenceTrouNoir()==true){
            verif1 = true;
        }
        return verif1;        
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
                if(grille[i][j].presenceTrouNoir() == true){
                    grille[i][j].supprimerTrouNoir();
                }
                if(grille[i][j].presenceDesintegrateur() == true){
                    grille[i][j].supprimerDesintegrateur();
                }
            }
        }
    }
    public void afficherGrilleSurConsole(){
        for(int j=5;j>-1;j--){
            for(int i=0;i<7;i++){
                if(grille[i][j].presenceJeton() == true){
                    System.out.print("["+grille[i][j].lireCouleurDuJeton()+"]");
                }
                else{
                    if (grille[i][j].presenceDesintegrateur()== true && grille[i][j].presenceTrouNoir()== true){                        
                            System.out.print("[ @@ ]");
                    }
                    if (grille[i][j].presenceDesintegrateur()== false && grille[i][j].presenceTrouNoir()== true){
                        System.out.print("[ @@ ]");
                    }
                    if (grille[i][j].presenceDesintegrateur()== true && grille[i][j].presenceTrouNoir()== false){
                        System.out.print("[ OO ]");
                    }
                    if (grille[i][j].presenceDesintegrateur()== false && grille[i][j].presenceTrouNoir()== false){
                        System.out.print("["+null+"]");
                    }
                
                }

                if(i==6){
                    System.out.println("\n"); 
                }    
            }
        }
    }
    
}
