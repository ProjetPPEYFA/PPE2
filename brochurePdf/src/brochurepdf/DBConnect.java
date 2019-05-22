/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brochurepdf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vervisch.florian
 */
public class DBConnect {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public ArrayList<BateauVoyageur> bateauList(){
        /**Méthode qui renvoie les bateaux contenus dans la base de données sous forme de collection **/
        
        ArrayList<BateauVoyageur> lesBateaux = new ArrayList();
        try{
            
            String query = "SELECT * FROM bateau";
            rs = st.executeQuery(query);
            System.out.println("Records from Database / bateau");
            BateauVoyageur bateau;
            while(rs.next())
            {
                bateau = new BateauVoyageur(rs.getInt("idBateau"),rs.getString("NomBateau"),rs.getDouble("LongueurEnMetre"),rs.getDouble("LargeurEnMetre"),rs.getDouble("VitesseMaxEnNoeud"),rs.getString("PathImage"));
                lesBateaux.add(bateau);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Probleme de lecture de la table bateau : "+ ex);
        }
        
        return lesBateaux;
        
    }
    
    
    
    public ArrayList<Equipement> equipementList(int id){
        /**Renvoie la liste des équipements du bateau demandé sous forme d'une collection **/
        
        ArrayList<Equipement> lesEquipements = new ArrayList();
        try{
            String query = "select Libelle,equipementbateau.id FROM equipementbateau,bateauequipe WHERE equipementbateau.id = bateauequipe.idEquipement AND bateauequipe.idBateau="+id+"  ORDER BY `equipementbateau`.`id` ASC";
            rs = st.executeQuery(query);
            System.out.println("Records from Database / equipement");
            Equipement unEquipement;
            
            while(rs.next())
            {   
                unEquipement = new Equipement(rs.getInt("id"),rs.getString("Libelle")); 
                lesEquipements.add(unEquipement);       
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Probleme de lecture de la table equipement : "+ ex);
        }
        
        return lesEquipements;
        
        
    }
    
    public ArrayList equipementList(){
        /**Renvoie la liste des équipements qui existent dans la table Equipements **/
        
        
        ArrayList<String> lesEquipements = new ArrayList();
        try{
            String query = "SELECT * FROM equipementbateau";
            rs = st.executeQuery(query);
            
            while(rs.next())
            {   
                lesEquipements.add(""+rs.getInt("id")+" - "+rs.getString("Libelle")+"");       
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Probleme de lecture de la table equipement : "+ ex);
        }
        
        return lesEquipements;
    }
    
    public ArrayList bateauListString(){
        /**Renvoie la liste des bateaux dans la base de données **/
        
        ArrayList<String> lesBateaux = new ArrayList();
        try{
            String query = "SELECT * FROM bateau";
            rs = st.executeQuery(query);
            
            while(rs.next())
            {   
                lesBateaux.add(""+rs.getInt("idBateau")+" - "+rs.getString("NomBateau")+"");     
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Probleme de lecture de la table bateau : "+ ex);
        }
        
        return lesBateaux;
    }
    
    public DBConnect(){
        try{ 
            Class.forName("com.mysql.cj.jdbc.Driver");
            //jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mariateam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            st = con.createStatement();
                    
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Probleme de connexion à la bdd erreur : "+ex);
        }   
    }
    
   
    
    
    public void InsertBateau(String Nom,Double Largeur,Double Longeur,Double Vitesse,String path){     
        /**Méthode qui permet de rajouter un bateau dans la base de données **/
        
        try{
            String query = "INSERT INTO bateau (nomBateau,vitesseMaxEnNoeud,LongueurEnMetre,LargeurEnMetre,PathImage) VALUES ('"+Nom+"', "+Largeur+","+Longeur+","+Vitesse+",'"+path+"'); ";
            st.executeUpdate(query);
            System.out.println("Insert into Database"); 
        }catch(Exception ex){
            System.out.println(ex);
        }  
    }
    
    public void InsertEquipement(int idBateau ,int idEquip){    
        /**Méthode qui permet de rajouter un équipement dans la base de données **/
        try{
            String query = "INSERT INTO bateauequipe (idBateau,idEquipement) VALUES ("+idBateau+","+idEquip+"); ";
            st.executeUpdate(query);
            System.out.println("Insert into Database"); 
        }catch(Exception ex){
            System.out.println(ex);
        }  
    }
    
    public void ModifierBateau(int id,String Nom,Double Largeur,Double Longeur,Double Vitesse,String path){ 
        /**Méthode qui permet de modifier un bateau dans la base de données **/
        try{
            String query = "UPDATE bateau SET NomBateau = '"+Nom+"',LongueurEnMetre = "+Largeur+",LargeurEnMetre = "+Longeur+",VitesseMaxEnNoeud = "+Vitesse+", PathImage = '"+path+"' WHERE idBateau="+id+"; ";
            st.executeUpdate(query);
            System.out.println("upload Database"); 
        }catch(Exception ex){
            System.out.println(ex);
        }  
    }
    
    public void DeleteBateau(int id){
        /** Permet de supprimer un bateau de la table Bateau **/
        try{
            String query = "DELETE FROM bateau WHERE idBateau="+id+" ";
            st.executeUpdate(query);
            System.out.println("Delete From Database"); 
        }catch(Exception ex){
            System.out.println(ex);
        }  
    }
    
    public void DeleteEquipement(int idBateau,int idEquipement){
        /** Permet de supprimer un équipement de la table Equipements **/
        try{
            String query = "DELETE FROM `bateauequipe` WHERE idEquipement = "+idEquipement+" and idBateau ="+idBateau+"";
            st.executeUpdate(query);
            System.out.println("Delete From Database"); 
        }catch(Exception ex){
            System.out.println(ex);
        }  
    }

    void InsertEquipement(char idEquip, char idBateau) {
        /** Permet de rajouter un équipement dans la table Equipements **/
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
