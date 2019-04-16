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

/**
 *
 * @author vervisch.florian
 */
public class DBConnect {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public DBConnect(){
        try{ 
            Class.forName("com.mysql.cj.jdbc.Driver");
            //jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mariateam?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            st = con.createStatement();
                    
        }catch(Exception ex){
            System.out.println("Erro: "+ex);
        }   
    }
    
    public void getBateau(){
        try{
            
            String query = "SELECT * FROM bateau";
            rs = st.executeQuery(query);
            System.out.println("Records from Database / bateau");
            while(rs.next())
            {
                String id=rs.getString("idBateau");
                System.out.println("id du bateau "+id);
            }
            
        }catch(Exception ex){
            System.out.println(ex);
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
    
    public void Insert(String code,String code_categorie,String designation,int quantite,double prix_unitaire,int date){     
        try{
            
     
            String query2 = "INSERT INTO `xelfi`.`article` (`code`, `code_categorie`,designation,quantite,prix_unitaire,date) VALUES ('"+code+"', '"+code_categorie+"','"+designation+"','"+quantite+"','"+prix_unitaire+"','"+date+"'); ";
            st.executeUpdate(query2);
            System.out.println("Insert into Database");
            
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    
}
