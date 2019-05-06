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
    
    private int idEquip;
    private String libEquip;
    

    public void setIdEquip(int unId) {
        this.idEquip = unId;
    }

    public void setLibEquip(String unLib) {
        this.libEquip = unLib;
    }

    public int getIdEquip() {
        return idEquip;
    }

    public String getLibEquip() {
        return libEquip;
        
    }
    
    
    public Equipement(int unId, String unLib){
        
        this.idEquip = unId;
        this.libEquip = unLib;
        
    }
    
    public void versChaine(){
        
        System.out.println("Libellé équipement" + getLibEquip());
    }
}
