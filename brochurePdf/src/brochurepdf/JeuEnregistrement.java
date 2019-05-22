/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brochurepdf;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JeuEnregistrement {
    public ResultSet SQLResult;
    //constructeur de la classe et incrémation du curseur a la première ligne de la requête SQL
    public JeuEnregistrement(String SQL){
        try {
            DBConnect unedb = new DBConnect();
            Statement smt = unedb.getConnect().createStatement();
            this.SQLResult = smt.executeQuery(SQL);
            this.SQLResult.next();
        } catch (SQLException ex) {
            Logger.getLogger(JeuEnregistrement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //déplacement du curseur du SQLResult
    public void suivant() throws SQLException{
        this.SQLResult.next();
    }
    //récupération des valeurs stocker dans les champ int double ou string
    public String getChampString(String Champ) throws SQLException{
        return this.SQLResult.getString(Champ);
    }
    public int getChampInt(String champ) throws SQLException{
        return this.SQLResult.getInt(champ);
    }
    public double getChampDouble(String champ) throws SQLException{
        return this.SQLResult.getDouble(champ);
    }
    //Fermer la requête
    public void close() throws SQLException{
        this.SQLResult.close();
    }
    //Vérification de la dernière ligne de la bdd
    public boolean fin() throws SQLException{
        return this.SQLResult.isLast();
    }
    
}
