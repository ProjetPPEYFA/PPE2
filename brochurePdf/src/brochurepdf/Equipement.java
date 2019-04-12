/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brochurepdf;

/**
 *
 * @author mahammed.yazid
 */
public class Equipement {
    
    private String idEquip = new String();
    private String libEquip = new String();
    

    public void setIdEquip(String unId) {
        this.idEquip = idEquip;
    }

    public void setLibEquip(String unLib) {
        this.libEquip = libEquip;
    }

    public String getIdEquip() {
        return idEquip;
    }

    public String getLibEquip() {
        return libEquip;
    }
    
    
    public Equipement(String unId, String unLib){
        
        this.idEquip = unId;
        this.libEquip = unLib;
        
    }
    
    public String versChaine(){
        
        return ("Libellé équipement" + this.getLibEquip());
    }
}
