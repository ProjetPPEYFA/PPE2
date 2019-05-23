/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brochurepdf;


import java.util.ArrayList;

/**
 *
 * @author mahammed.yazid
 */
public class BateauVoyageur extends Bateau {
    
    /** Crée un bateau voyageur **/
    private double vitesseBatVoy;
    private String imageBatVoy;
    ArrayList<Equipement> lesEquipements = new ArrayList<Equipement>();
    

    public double getVitesseBatVoy() {
        return vitesseBatVoy;
    }

    public String getImageBatVoy() {
        return imageBatVoy;
    }

    public ArrayList<Equipement> getLesEquipements() {
        return lesEquipements;
    }

    public void setVitesseBatVoy(double uneVitesseBatVoy) {
        this.vitesseBatVoy = uneVitesseBatVoy;
    }

    public void setImageBatVoy(String uneImageBatVoy) {
        this.imageBatVoy = uneImageBatVoy;
    }

    public void setLesEquipements(ArrayList<Equipement> uneCollectionEquipements) {
        this.lesEquipements = uneCollectionEquipements;
    }
    
    public void ajouterEquipement(Equipement nouvel_equip){
        
        /**Ajoute un équipement au bateau**/
        
        this.lesEquipements.add(nouvel_equip);
    }
    
    
    
    public BateauVoyageur(int unId, String unNom, double uneLongueur, double uneLargeur, double uneVitesse, String uneImage){
        super(unId, unNom, uneLongueur, uneLargeur);
        this.setVitesseBatVoy(uneVitesse);
        this.setImageBatVoy(uneImage);
    }
    
    public String listeEquipements(){
        String liste = "";
        for (Equipement unEquip : this.lesEquipements){
            liste = liste+"-"+unEquip.getLibEquip()+"\n";
        }
        return liste;
    }
    
    @Override
    public String versChaine(){
        return ( super.versChaine() + "\n Vitesse Bateau: "+ this.getVitesseBatVoy() +"\n Liste des équipements: \n"+this.listeEquipements()+"\n\n");
    }
    
}
