/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brochurepdf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author mahammed.yazid
 */
public class Interface extends javax.swing.JFrame {

    public void reloadBateau(){
        DBConnect con = new DBConnect();        
        ArrayList<BateauVoyageur>list = con.bateauList();
        DefaultTableModel model = (DefaultTableModel)jTableBateau.getModel();
        Object[] row = new Object[6];
        model.setRowCount(0);
        for(int i=0;i<list.size();i++)
        {
         row[0]=list.get(i).getIdBateau();
         row[1]=list.get(i).getNomBateau();
         row[2]=list.get(i).getLongueurBateau();
         row[3]=list.get(i).getLargeurBateau();
         row[4]=list.get(i).getVitesseBatVoy();
         row[5]=list.get(i).getImageBatVoy();
         model.addRow(row); 
        }   
    }
    
    public void reloadEquipement(int id){
        DBConnect con = new DBConnect();        
        ArrayList<Equipement>list = con.equipementList(id);
        DefaultTableModel model = (DefaultTableModel)jTableEquipement.getModel();
        Object[] row = new Object[2];
        model.setRowCount(0);
        for(int i=0;i<list.size();i++)
        {
         row[0]=list.get(i).getIdEquip();
         row[1]=list.get(i).getLibEquip();
         model.addRow(row); 
        }   
    }
    
    public void initCombobox(){
        DBConnect con = new DBConnect();
        ArrayList<String>listEquip = con.equipementList();
        ArrayList<String>listBateaux = con.bateauListString();
        for(int i=0;i<listEquip.size();i++)
        {
            String item = listEquip.get(i);
            jComboBoxEquipement.addItem(item);
         
        }   
        
        for(int i=0;i<listBateaux.size();i++)
        {
            String item2 = listBateaux.get(i);
            jComboBoxBateau.addItem(item2);
         
        }   
        
        

    }
    
    public Interface() {
        initComponents();
        reloadBateau();
        initCombobox();
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldLongueur = new javax.swing.JTextField();
        jTextFieldLargeur = new javax.swing.JTextField();
        jTextFieldVitesse = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableBateau = new javax.swing.JTable();
        jButtonReload = new javax.swing.JButton();
        jTextFieldPath = new javax.swing.JTextField();
        jButtonInsert = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEquipement = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonPdf = new javax.swing.JButton();
        jComboBoxBateau = new javax.swing.JComboBox<>();
        jComboBoxEquipement = new javax.swing.JComboBox<>();
        jButtonValider = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Caractéristique du bateau");

        jTextFieldNom.setText("Nom");

        jTextFieldLongueur.setText("Longueur");

        jTextFieldLargeur.setText("Largeur");

        jTextFieldVitesse.setText("Vitesse");

        jTableBateau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nom", "Longueur", "Largeur", "Vitesse en noeud", "chemin img"
            }
        ));
        jTableBateau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBateauMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableBateau);

        jButtonReload.setText("Actualiser");
        jButtonReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReloadActionPerformed(evt);
            }
        });

        jTextFieldPath.setText("Chemin image");

        jButtonInsert.setText("Inserer");
        jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Supprimer");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonModifier.setText("Modifier");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        jTableEquipement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "id", "Nom"
            }
        ));
        jTableEquipement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEquipementMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEquipement);

        jLabel2.setText("équipements");

        jLabel3.setText("Bateaux");

        jButtonPdf.setBackground(new java.awt.Color(255, 0, 0));
        jButtonPdf.setText("Générer le pdf");
        jButtonPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPdfActionPerformed(evt);
            }
        });

        jComboBoxBateau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBateauActionPerformed(evt);
            }
        });

        jButtonValider.setText("Ajouter");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldNom)
                            .addComponent(jTextFieldLongueur)
                            .addComponent(jTextFieldLargeur, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldVitesse)
                            .addComponent(jTextFieldPath)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButtonInsert)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModifier)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxEquipement, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxBateau, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonValider)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSupprimer)))))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24)
                                .addComponent(jButtonReload)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(445, 445, 445)
                .addComponent(jButtonPdf)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonReload)
                        .addComponent(jLabel3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldLongueur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldLargeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldVitesse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonInsert)
                            .addComponent(jButtonModifier)
                            .addComponent(jButtonDelete)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxBateau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxEquipement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonValider)
                            .addComponent(jButtonSupprimer))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jButtonPdf)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReloadActionPerformed
        reloadBateau();
    }//GEN-LAST:event_jButtonReloadActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        DBConnect con = new DBConnect();
        int ligne = jTableBateau.getSelectedRow();
        String id = jTableBateau.getModel().getValueAt(ligne, 0).toString();
        
        double intId = Integer.parseInt(id);
        con.DeleteBateau((int) intId);
        
        jTextFieldNom.setText("Nom");
        jTextFieldLongueur.setText("Longueur");
        jTextFieldLargeur.setText("Largeur");
        jTextFieldVitesse.setText("Vitesse");
        jTextFieldPath.setText("Chemin image");
        
        reloadBateau();
        
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
        DBConnect con = new DBConnect();
        int ligne = jTableBateau.getSelectedRow();
        
        String id = jTableBateau.getModel().getValueAt(ligne, 0).toString();
        double intId = Integer.parseInt(id);
        
        String nom = jTextFieldNom.getText();
        String largeur = jTextFieldLargeur.getText();
        String longueur = jTextFieldLongueur.getText();
        String vitesse = jTextFieldVitesse.getText();
        String path = jTextFieldPath.getText();
        
        double doubleLargeur = Double.parseDouble(largeur);
        double doubleLongueur = Double.parseDouble(longueur);
        double doubleVitesse = Double.parseDouble(vitesse);
        
        con.ModifierBateau((int) intId,nom,doubleLongueur, doubleLargeur, doubleVitesse,path);
        reloadBateau();
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertActionPerformed
        DBConnect con = new DBConnect();
        
        String nom = jTextFieldNom.getText();
        String largeur = jTextFieldLargeur.getText();
        String longueur = jTextFieldLongueur.getText();
        String vitesse = jTextFieldVitesse.getText();
        String path = jTextFieldPath.getText();
        
        double doubleLargeur = Double.parseDouble(largeur);
        double doubleLongueur = Double.parseDouble(longueur);
        double doubleVitesse = Double.parseDouble(vitesse);
        
        con.InsertBateau(nom, doubleLargeur, doubleLongueur, doubleVitesse, path);
        
        reloadBateau();
        
    }//GEN-LAST:event_jButtonInsertActionPerformed

    private void jTableBateauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBateauMouseClicked
        int ligne = jTableBateau.getSelectedRow();
        
        String id = jTableBateau.getModel().getValueAt(ligne, 0).toString();
        int intId = Integer.parseInt(id);
        
        reloadEquipement(intId);
        
        String nomBateau = jTableBateau.getModel().getValueAt(ligne, 1).toString();
        String longueur = jTableBateau.getModel().getValueAt(ligne, 2).toString();
        String largeur = jTableBateau.getModel().getValueAt(ligne, 3).toString();
        String vitesse = jTableBateau.getModel().getValueAt(ligne, 4).toString();
        String path = jTableBateau.getModel().getValueAt(ligne, 5).toString();
        
        jTextFieldNom.setText(nomBateau);
        jTextFieldLongueur.setText(longueur);
        jTextFieldLargeur.setText(largeur);
        jTextFieldVitesse.setText(vitesse);
        jTextFieldPath.setText(path);
        
    }//GEN-LAST:event_jTableBateauMouseClicked

    private void jButtonPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPdfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPdfActionPerformed

    private void jComboBoxBateauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBateauActionPerformed
        
    }//GEN-LAST:event_jComboBoxBateauActionPerformed

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        String bateau = jComboBoxBateau.getSelectedItem().toString();
        char iBateau = bateau.charAt(0);
        int idBateau = Character.getNumericValue(iBateau); 
        
        String equip = jComboBoxEquipement.getSelectedItem().toString();
        char iEquip = equip.charAt(0);
        int idEquip = Character.getNumericValue(iEquip); 
        
        
        
        
        
        System.out.println(""+idBateau+""+idEquip);
        
        DBConnect con = new DBConnect();
        con.InsertEquipement(idBateau, idEquip);
        
        
    }//GEN-LAST:event_jButtonValiderActionPerformed

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        DBConnect con = new DBConnect();
        int ligne = jTableEquipement.getSelectedRow();
        String id = jTableEquipement.getModel().getValueAt(ligne, 0).toString();
        int intId = Integer.parseInt(id);
        
        String nomBateau = jTextFieldNom.getText();
        
        con.DeleteEquipement(nomBateau, intId);
        
        
    
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void jTableEquipementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEquipementMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableEquipementMouseClicked

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonPdf;
    private javax.swing.JButton jButtonReload;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JComboBox<String> jComboBoxBateau;
    private javax.swing.JComboBox<String> jComboBoxEquipement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableBateau;
    private javax.swing.JTable jTableEquipement;
    private javax.swing.JTextField jTextFieldLargeur;
    private javax.swing.JTextField jTextFieldLongueur;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldPath;
    private javax.swing.JTextField jTextFieldVitesse;
    // End of variables declaration//GEN-END:variables
}
