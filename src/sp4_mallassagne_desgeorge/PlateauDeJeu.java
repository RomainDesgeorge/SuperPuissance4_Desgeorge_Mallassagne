/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_mallassagne_desgeorge;

/**
 *
 * @author Romain Desgeorges et Alexis Mallassagne
 */
public class PlateauDeJeu {

    CelluleDeGrille[][] grille = new CelluleDeGrille[7][6];//attribut

    public PlateauDeJeu() {//constructeur
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                grille[j][i] = new CelluleDeGrille();//création de toutes les cases
            }
        }
    }

    /**
     * Selon le numero de colonne et le jeton, cette methode permet de placer le
     * jeton dans la colonne demandé Permet aussi la récuperation d'un
     * désintegrateur si il y en a un
     *
     * @param jeton
     * @param nb
     * @return le numero de ligne
     */
    public int ajouterJetonDansColonne(Jeton jeton, int nb) {
        int nbligne = 0;
        for (int i = 0; i < 5; i++) {
            if (!"rien".equals(grille[nb][i].lireCouleurDuJeton())) {//determination de la cellule vide la plus basse dans la colonne
                nbligne += 1;
            } else {
                break;
            }
        }
        if (grille[nb][nbligne].presenceDesintegrateur() == true) {//verification de la présence d'un désintegrateur 
            grille[nb][nbligne].affecterJeton(jeton);//placement du jeton dans l'emplacement voulu
            grille[nb][nbligne].placerDesintegrateur();
        } else {
            grille[nb][nbligne].affecterJeton(jeton);//placement du jeton dans l'emplacement voulu
        }
        return nbligne;
    }

    /**
     * Cette methode regarde si la grille est pleine
     *
     * @return true si la grille est pleine, false sinon
     */
    public boolean grilleRemplie() {
        boolean verif = true;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (grille[j][i] == null) {
                    verif = false;
                    break;
                }
            }
        }
        return verif;
    }

    /**
     * Verifie la présence d'un jeton dans une case demandé
     *
     * @param x
     * @param y
     * @return true si il y a un jeton false sinon
     */
    public boolean presenceJeton(int x, int y) {
        boolean verif = false;
        if (grille[x][y].presenceJeton() == true) {
            verif = true;
        }
        return verif;
    }

    /**
     * lis la couleur du jeton dans la grille
     *
     * @param x
     * @param y
     * @return la couleur du jeton et "rien" si il n'y a pas de jeton
     */
    public String lireCouleurDuJeton(int x, int y) {
        String couleur;
        couleur = grille[x][y].lireCouleurDuJeton();
        return couleur;
    }

    /**
     * Verifie si il y a 4 jetons à la suite de la même couleur sur la même
     * ligne
     *
     * @param couleur
     * @return true si il y a 4 jetons à la suite de la même couleur sur la même
     * ligne false sinon
     */
    public boolean ligneGagnantePourCouleur(String couleur) {
        boolean verif = false;
        int win = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (grille[j][i].lireCouleurDuJeton().equals(couleur)) {//verification si il y a 4 jetons à la suite de la même couleur sur la même ligne
                    if (grille[j][i + 1].lireCouleurDuJeton().equals(couleur)) {
                        if (grille[j][i + 2].lireCouleurDuJeton().equals(couleur)) {
                            if (grille[j][i + 3].lireCouleurDuJeton().equals(couleur)) {
                                win = 1;
                            }
                        }
                    }
                }
                if (win == 1) {
                    verif = true;
                    break;
                }
            }
        }
        return verif;
    }

    /**
     * Verifie si il y a 4 jetons à la suite de la même couleur sur la même
     * colonne
     *
     * @param couleur
     * @return true si il y a 4 jetons à la suite de la même couleur sur la même
     * ligne false sinon
     */
    public boolean colonneGagnantePourCouleur(String couleur) {
        boolean verif = false;
        int win = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (grille[j][i].lireCouleurDuJeton().equals(couleur)) {//verification si il y a 4 jetons à la suite de la même couleur sur la même colonne
                    if (grille[j + 1][i].lireCouleurDuJeton().equals(couleur)) {
                        if (grille[j + 2][i].lireCouleurDuJeton().equals(couleur)) {
                            if (grille[j + 3][i].lireCouleurDuJeton().equals(couleur)) {
                                win = 1;
                            }
                        }
                    }
                }
                if (win == 1) {
                    verif = true;
                    break;
                }
            }
        }
        return verif;
    }

    /**
     * Verifie si il y a 4 jetons à la suite de la même couleur sur la même
     * diagonale montante
     *
     * @param couleur
     * @return true si il y a 4 jetons à la suite de la même couleur sur la même
     * diagonale montante false sinon
     */
    public boolean diagonaleMontanteGagnantePourCouleur(String couleur) {
        boolean verif = false;
        int win = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (grille[j][i].lireCouleurDuJeton().equals(couleur)) {//verification si il y a 4 jetons à la suite de la même couleur sur la même diagonale montante
                    if (grille[j + 1][i + 1].lireCouleurDuJeton().equals(couleur)) {
                        if (grille[j + 2][i + 2].lireCouleurDuJeton().equals(couleur)) {
                            if (grille[j + 3][i + 3].lireCouleurDuJeton().equals(couleur)) {
                                win = 1;
                            }
                        }
                    }
                }
                for (int a = 3; a < 7; a++) {
                    for (int b = 3; b < 6; b++) {
                        if (grille[a][b].lireCouleurDuJeton().equals(couleur)) {
                            if (grille[a + 1][b - 1].lireCouleurDuJeton().equals(couleur)) {
                                if (grille[a + 2][b - 2].lireCouleurDuJeton().equals(couleur)) {
                                    if (grille[a + 3][b - 3].lireCouleurDuJeton().equals(couleur)) {
                                        win = 1;
                                    }
                                }
                            }
                        }
                        if (win == 1) {
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
     * Verifie si il y a 4 jetons à la suite de la même couleur sur la même
     * diagonale descendante
     *
     * @param couleur
     * @return true si il y a 4 jetons à la suite de la même couleur sur la même
     * diagonale descendante false sinon
     */
    public boolean diagonaleDescendanteGagnantePourCouleur(String couleur) {
        boolean verif = false;
        int win = 0;
        for (int i = 4; i < 7; i++) {
            for (int j = 3; j < 6; j++) {
                if (grille[i][j].lireCouleurDuJeton().equals(couleur)) {//verification si il y a 4 jetons à la suite de la même couleur sur la même diagonale descendante
                    if (grille[i - 1][j + 1].lireCouleurDuJeton().equals(couleur)) {
                        if (grille[i - 2][j + 2].lireCouleurDuJeton().equals(couleur)) {
                            if (grille[i - 3][j + 3].lireCouleurDuJeton().equals(couleur)) {
                                win = 1;
                            }
                        }
                    }
                }
                for (int a = 3; a < 7; a++) {
                    for (int b = 3; b < 6; b++) {
                        if (grille[a][b].lireCouleurDuJeton().equals(couleur)) {
                            if (grille[a - 1][b - 1].lireCouleurDuJeton().equals(couleur)) {
                                if (grille[a - 2][b - 2].lireCouleurDuJeton().equals(couleur)) {
                                    if (grille[a - 3][b - 3].lireCouleurDuJeton().equals(couleur)) {
                                        win = 1;
                                    }
                                }
                            }
                        }
                        if (win == 1) {
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
     * Verifie si une fonction de type *****GagnantePourCouleur renvoie un true
     *
     * @param couleur
     * @return true si une fonction de type *****GagnantePourCouleur renvoie un
     * true et renvoie false sinon
     */
    public boolean etreGagnantePourCouleur(String couleur) {
        boolean verif;
        verif = ligneGagnantePourCouleur(couleur);
        if (verif == false) {
            verif = colonneGagnantePourCouleur(couleur);
            if (verif == false) {
                verif = diagonaleDescendanteGagnantePourCouleur(couleur);
                if (verif == false) {
                    verif = diagonaleMontanteGagnantePourCouleur(couleur);
                }
            }
        }
        return verif;
    }

    /**
     * Permet de mettre tous les jetons sur les cases disponibles les plus basse
     *
     * @param ligne
     */
    public void tasserLigne(int ligne) {
        for (int i = 0; i < 5; i++) {
            Jeton jetonrecup;
            if ("rien".equals(grille[ligne][i].lireCouleurDuJeton())) {
                if (!"rien".equals(grille[ligne][i + 1].lireCouleurDuJeton())) {
                    jetonrecup = grille[ligne][i + 1].recupererJeton();
                    grille[ligne][i].affecterJeton(jetonrecup);
                    grille[ligne][i + 1].supprimerJeton();
                }
            }
        }
    }

    /**
     * Methode permettant de verifier si une colonne est pleine
     *
     * @param colonne
     * @return true si la colonne est pleine et false si elle ne l'est pas
     */
    public boolean colonneRemplie(int colonne) {
        boolean verif = true;
        for (int i = 0; i < 7; i++) {
            if (grille[i][colonne] == null) {//verifie la contenance des grilles de la colonne
                verif = false;
                break;
            }
        }
        return verif;
    }

    /**
     * Permet de placer un trou noir dans une case demandée
     *
     * @param x
     * @param y
     */
    public void placerTrouNoir(int x, int y) {
        grille[x][y].placerTrouNoir();
    }

    /**
     * Permet de supprimer un trou noir dans une case demandée
     *
     * @param x
     * @param y
     */
    public void supprimerTrouNoir(int x, int y) {
        grille[x][y].supprimerTrouNoir();
    }

    /**
     * Permet de supprimer un desintegrateur dans une case demandée
     *
     * @param x
     * @param y
     */
    public void supprimerDesintegrateur(int x, int y) {
        grille[x][y].supprimerDesintegrateur();
    }

    /**
     * Permet de placer un desintegrateur dans une case demandée
     *
     * @param x
     * @param y
     */
    public void placerDesintegrateur(int x, int y) {
        grille[x][y].placerDesintegrateur();
    }

    /**
     * Verifie la présence d'un désintegrateur dans une case demandée
     *
     * @param x
     * @param y
     * @return true si il y a une désintegrateur dans la case et false sinon
     */
    public boolean presenceDesintegrateur(int x, int y) {
        boolean verif1 = false;
        if (grille[x][y].presenceDesintegrateur() == true) {
            verif1 = true;
        }
        return verif1;
    }

    /**
     * Le joueur utilise (et donc perd) un desintegrateur, il choisi aussi la
     * case où il veut utiliser le desintegrateur et si il y a un jeton cela le
     * supprime
     *
     * @param x
     * @param y
     * @param joueur
     */
    public void utiliserDesintegrateur(int x, int y, Joueur joueur) {
        grille[x][y].supprimerJeton();
        joueur.utiliserDesintegrateur();
    }

    /**
     * Verifie la présence d'un trou noir dans une case demandée
     *
     * @param x
     * @param y
     * @return true si il y a un trou noir et false sinon
     */
    public boolean presenceTrouNoir(int x, int y) {
        boolean verif1 = false;
        if (grille[x][y].presenceTrouNoir() == true) {
            verif1 = true;
        }
        return verif1;
    }

    /**
     * Supprime le jeton dans la case demandée (si il y a un jeton)
     *
     * @param x
     * @param y
     */
    public void supprimerJeton(int x, int y) {
        grille[x][y].supprimerJeton();
    }

    /**
     * Recupere le jeton dans la case demandée (si il y a un jeton)
     *
     * @param x
     * @param y
     */
    public void recupererJeton(int x, int y) {
        grille[x][y].recupererJeton();
    }

    /**
     * Vide toutes les cellules de la grille
     *
     * @param joueur1
     * @param joueur2
     */
    public void viderGrille(Joueur joueur1, Joueur joueur2) {
        String couleur;
        Jeton jeton;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (grille[i][j].presenceJeton() == true) {
                    couleur = lireCouleurDuJeton(i, j);
                    jeton = grille[i][j].recupererJeton();
                    if (joueur1.getCouleur().equals(couleur)) {
                        joueur1.ajouterJeton(jeton);
                    } else {
                        joueur2.ajouterJeton(jeton);
                    }
                }
            }
        }
    }

    /**
     * Affiche chaque case de la grille avec leurs compositions
     *
     */
    public void afficherGrilleSurConsole() {
        for (int j = 5; j > -1; j--) {
            for (int i = 0; i < 7; i++) {
                if (grille[i][j].presenceJeton() == true) {
                    System.out.print("[" + grille[i][j].lireCouleurDuJeton() + "]");
                } else {
                    if (grille[i][j].presenceDesintegrateur() == true && grille[i][j].presenceTrouNoir() == true) {
                        System.out.print("[ @@ ]");
                    }
                    if (grille[i][j].presenceDesintegrateur() == false && grille[i][j].presenceTrouNoir() == true) {
                        System.out.print("[ @@ ]");
                    }
                    if (grille[i][j].presenceDesintegrateur() == true && grille[i][j].presenceTrouNoir() == false) {
                        System.out.print("[ OO ]");
                    }
                    if (grille[i][j].presenceDesintegrateur() == false && grille[i][j].presenceTrouNoir() == false) {
                        System.out.print("[" + null + "]");
                    }

                }

                if (i == 6) {
                    System.out.println("\n");
                }
            }
        }
    }

}
