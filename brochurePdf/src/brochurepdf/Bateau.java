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
public class Bateau {
    
    private String idBateau;
    private String nomBateau;
    private double longueurBateau;
    private double largeurBateau;


    public void setIdBateau(String idB) {
        this.idBateau = idB;
    }

    public void setNomBateau(String nomB) {
        this.nomBateau = nomB;
    }

    public void setLongueurBateau(double longueurB) {
        this.longueurBateau = longueurB;
    }

    public void setLargeurBateau(double largeurB) {
        this.largeurBateau = largeurB;
    }

    public String getIdBateau() {
        return idBateau;
    }

    public String getNomBateau() {
        return nomBateau;
    }

    public double getLongueurBateau() {
        return longueurBateau;
    }

    public double getLargeurBateau() {
        return largeurBateau;
    }
    
    
    
    public Bateau (String idB, String nomB, double longueurB, double largeurB) {
        this.setIdBateau(idB);
        this.setNomBateau(nomB);
        this.setLongueurBateau(longueurB);
        this.setLargeurBateau(largeurB);
    }
    
    
    public String versChaine(){
        
        return ("Nom du Bateau: " + this.getNomBateau() +"\n Longueur: " + this.getLongueurBateau() +"\n Largeur: " + this.getLargeurBateau());
    }
    
    
}
