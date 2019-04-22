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
            JOptionPane.showMessageDialog(null,"Probleme de lecteur de la table bateau : "+ ex);
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
    
    
    
    public void getEquipement(int idBateau){
        try{
            
            String query = "SELECT * FROM bateauequipe WHERE idBateau ="+idBateau+"";
            rs = st.executeQuery(query);
            System.out.println("Records from Database / equipement");
            while(rs.next())
            {
                String id=rs.getString("idEquipement");
                System.out.println("id de l'equipement : "+id);
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void InsertBateau(String Nom,Double Largeur,Double Longeur,Double Vitesse,String path){     
        try{
            String query = "INSERT INTO bateau (nomBateau,vitesseMaxEnNoeud,LongueurEnMetre,LargeurEnMetre,PathImage) VALUES ('"+Nom+"', "+Largeur+","+Longeur+","+Vitesse+",'"+path+"'); ";
            st.executeUpdate(query);
            System.out.println("Insert into Database"); 
        }catch(Exception ex){
            System.out.println(ex);
        }  
    }
    
    public void ModifierBateau(int id,String Nom,Double Largeur,Double Longeur,Double Vitesse,String path){     
        try{
            String query = "UPDATE bateau SET NomBateau = '"+Nom+"',LongueurEnMetre = "+Largeur+",LargeurEnMetre = "+Longeur+",VitesseMaxEnNoeud = "+Vitesse+", PathImage = '"+path+"' WHERE idBateau="+id+"; ";
            st.executeUpdate(query);
            System.out.println("upload Database"); 
        }catch(Exception ex){
            System.out.println(ex);
        }  
    }
    
    public void DeleteBateau(int id){
        try{
            String query = "DELETE FROM bateau WHERE idBateau="+id+" ";
            st.executeUpdate(query);
            System.out.println("Delete From Database"); 
        }catch(Exception ex){
            System.out.println(ex);
        }  
    }
    
}
