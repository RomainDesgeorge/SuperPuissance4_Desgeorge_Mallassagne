/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sp4_mallassagne_desgeorge;

import java.util.Scanner;

/**
 *
 * @author rom
 */
public class fenetreDeJeu extends javax.swing.JFrame {
    private Joueur[] listeJoueurs=new Joueur[2];
    private Joueur joueurCourant;
    private PlateauDeJeu plateau=new PlateauDeJeu();
    /**
     * Creates new form fenetreDeJeu
     */
    public fenetreDeJeu() {
        initComponents();
        panneau_info_joueur.setVisible(false);
        panneau_info_jeu.setVisible(false);
        
        for (int i=5; i>=0;i--){
            for (int j=0; j<7;j++){
                CelluleGraphique cellgraph = new CelluleGraphique(plateau.grille[j][i]);
                panneau_grille.add(cellgraph);
            }
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneau_grille = new javax.swing.JPanel();
        panneau_creation_partie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nom_joueur_2 = new javax.swing.JTextField();
        nom_joueur_1 = new javax.swing.JTextField();
        btn_start = new javax.swing.JButton();
        panneau_info_joueur = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_j1_nbdesint = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_j1_nom = new javax.swing.JLabel();
        lbl_j1_couleur = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        lbl_j2_nbdesint = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_j2_couleur = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_j2_nom1 = new javax.swing.JLabel();
        panneau_info_jeu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_jcourant = new javax.swing.JLabel();
        message = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btn_cln_0 = new javax.swing.JButton();
        btn_cln_1 = new javax.swing.JButton();
        btn_cln_2 = new javax.swing.JButton();
        btn_cln_3 = new javax.swing.JButton();
        btn_cln_4 = new javax.swing.JButton();
        btn_cln_5 = new javax.swing.JButton();
        btn_cln_6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneau_grille.setBackground(new java.awt.Color(255, 255, 255));
        panneau_grille.setLayout(new java.awt.GridLayout(6, 7));
        getContentPane().add(panneau_grille, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 672, 576));

        panneau_creation_partie.setBackground(new java.awt.Color(153, 255, 153));
        panneau_creation_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nom joueur 2 : ");
        panneau_creation_partie.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel2.setText("Nom joueur 1 : ");
        panneau_creation_partie.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        panneau_creation_partie.add(nom_joueur_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 130, -1));
        panneau_creation_partie.add(nom_joueur_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 130, -1));

        btn_start.setText("Démarrer partie");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        getContentPane().add(panneau_creation_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 290, 100));

        panneau_info_joueur.setBackground(new java.awt.Color(153, 255, 153));
        panneau_info_joueur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Désintegrateur(s):");
        panneau_info_joueur.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        lbl_j1_nbdesint.setText("nbdesint_joueur_1");
        panneau_info_joueur.add(lbl_j1_nbdesint, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel6.setText("Couleur :");
        panneau_info_joueur.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel7.setText("Joueur 1 :");
        panneau_info_joueur.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        lbl_j1_nom.setText("nom_joueur_1");
        panneau_info_joueur.add(lbl_j1_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        lbl_j1_couleur.setText("couleur_joueur_1");
        panneau_info_joueur.add(lbl_j1_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        panneau_info_joueur.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 123, 290, 10));

        jLabel5.setText("Désintegrateur(s):");
        panneau_info_joueur.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        lbl_j2_nbdesint.setText("nbdesint_joueur_2");
        panneau_info_joueur.add(lbl_j2_nbdesint, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        jLabel8.setText("Couleur :");
        panneau_info_joueur.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        lbl_j2_couleur.setText("couleur_joueur_2");
        panneau_info_joueur.add(lbl_j2_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel10.setText("Infos joueurs");
        panneau_info_joueur.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel11.setText("Joueur 2 :");
        panneau_info_joueur.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        lbl_j2_nom1.setText("nom_joueur_2");
        panneau_info_joueur.add(lbl_j2_nom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        getContentPane().add(panneau_info_joueur, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 290, 270));

        panneau_info_jeu.setBackground(new java.awt.Color(153, 255, 153));
        panneau_info_jeu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel3.setText("Infos jeu");
        panneau_info_jeu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel9.setText("Joueur courant :");
        panneau_info_jeu.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lbl_jcourant.setText("Nomjoueur");
        panneau_info_jeu.add(lbl_jcourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        message.setViewportView(jTextArea1);

        panneau_info_jeu.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 260, 80));

        getContentPane().add(panneau_info_jeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 450, 290, 170));

        btn_cln_0.setText("1");
        getContentPane().add(btn_cln_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        btn_cln_1.setText("2");
        getContentPane().add(btn_cln_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 10, 90, -1));

        btn_cln_2.setText("3");
        getContentPane().add(btn_cln_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 10, 90, -1));

        btn_cln_3.setText("4");
        getContentPane().add(btn_cln_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 10, 90, -1));

        btn_cln_4.setText("5");
        getContentPane().add(btn_cln_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 10, 90, -1));

        btn_cln_5.setText("6");
        getContentPane().add(btn_cln_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 90, -1));

        btn_cln_6.setText("7");
        getContentPane().add(btn_cln_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 10, 90, -1));

        setBounds(0, 0, 1044, 672);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        panneau_info_joueur.setVisible(true);
        panneau_info_jeu.setVisible(true);
        initialiserPartie();
        panneau_grille.repaint();
        btn_start.setEnabled(false);
    }//GEN-LAST:event_btn_startActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetreDeJeu().setVisible(true);
            }
        });
    }
    
    
     public void attribuerCouleurAuxJoueurs(){
         String nomJoueur1 = nom_joueur_1.getText();
         Joueur J1 = new Joueur(nomJoueur1);
         String nomJoueur2 = nom_joueur_2.getText();
         Joueur J2 = new Joueur(nomJoueur2);
         
         listeJoueurs[0] = J1;
         listeJoueurs[1] = J2;
         joueurCourant = listeJoueurs[0];
         
         lbl_j1_nom.setText(nomJoueur1);
         lbl_j1_couleur.setText(J1.getCouleur());
         lbl_j1_nbdesint.setText(J1.getNombreDesintegrateurs()+"");
         lbl_j2_nbdesint.setText(J2.getNombreDesintegrateurs()+"");
         lbl_j2_couleur.setText(J2.getCouleur());
         lbl_j2_nom1.setText(nomJoueur2);
         
         lbl_jcourant.setText(joueurCourant.nom);
        int valeur=(int) (Math.random() * (2));
        if (valeur==0){
            listeJoueurs[0].affecterCouleur("rouge");
            listeJoueurs[1].affecterCouleur("jaune");
        }
        else{
            listeJoueurs[0].affecterCouleur("jaune");
            listeJoueurs[1].affecterCouleur("rouge");
        }
        
    }
     
      public void creerEtAffecterJeton(Joueur j1){
        if ("rouge".equals(j1.getCouleur())){
            for (int i=0;i<31;i++){
                Jeton jeton=new Jeton ("rouge");
                j1.ajouterJeton(jeton);
            }
            
        }
        if ("jaune".equals(j1.getCouleur())){
            for (int i=0;i<31;i++){
                Jeton jeton=new Jeton ("jaune");
                j1.ajouterJeton(jeton);
            }
            
        }
    }
      
      public void placerTrousNoirsEtDesintegrateurs(){
        int i=0;
        while (i<3){
            int x=(int) (Math.random() * (9-3));
            int y=(int) (Math.random() * (8-3));
            if (plateau.presenceDesintegrateur(x,y)==false){
                if (plateau.presenceTrouNoir(x,y)==false){
                    plateau.placerTrouNoir(x,y);
                    plateau.placerDesintegrateur(x,y);
                    i+=1;
                }
            }
                
        }
        while (i<5){
            int x=(int) (Math.random() * (9-3));
            int y=(int) (Math.random() * (8-3));
            if (plateau.presenceDesintegrateur(x,y)==false){
                if (plateau.presenceTrouNoir(x,y)==false){
                    plateau.placerTrouNoir(x,y);
                    i+=1;
                }
            }
        }
        while(i<7){
            int x=(int) (Math.random() * (9-3));
            int y=(int) (Math.random() * (8-3));
            if (plateau.presenceDesintegrateur(x,y)==false){
                if (plateau.presenceTrouNoir(x,y)==false){
                    plateau.placerDesintegrateur(x,y);
                    i+=1;
                }
            }
        }
    }
     
      public void initialiserPartie(){
        attribuerCouleurAuxJoueurs();
        creerEtAffecterJeton(listeJoueurs[1]);
        creerEtAffecterJeton(listeJoueurs[0]);
        plateau.viderGrille(listeJoueurs[0], listeJoueurs[1]);
        placerTrousNoirsEtDesintegrateurs();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cln_0;
    private javax.swing.JButton btn_cln_1;
    private javax.swing.JButton btn_cln_2;
    private javax.swing.JButton btn_cln_3;
    private javax.swing.JButton btn_cln_4;
    private javax.swing.JButton btn_cln_5;
    private javax.swing.JButton btn_cln_6;
    private javax.swing.JButton btn_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbl_j1_couleur;
    private javax.swing.JLabel lbl_j1_nbdesint;
    private javax.swing.JLabel lbl_j1_nom;
    private javax.swing.JLabel lbl_j2_couleur;
    private javax.swing.JLabel lbl_j2_nbdesint;
    private javax.swing.JLabel lbl_j2_nom1;
    private javax.swing.JLabel lbl_jcourant;
    private javax.swing.JScrollPane message;
    private javax.swing.JTextField nom_joueur_1;
    private javax.swing.JTextField nom_joueur_2;
    private javax.swing.JPanel panneau_creation_partie;
    private javax.swing.JPanel panneau_grille;
    private javax.swing.JPanel panneau_info_jeu;
    private javax.swing.JPanel panneau_info_joueur;
    // End of variables declaration//GEN-END:variables
}
