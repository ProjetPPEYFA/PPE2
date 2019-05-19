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
    
    private int idBateau;
    private String nomBateau;
    private double longueurBateau;
    private double largeurBateau;


    public void setIdBateau(int idB) {
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

    public int getIdBateau() {
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
    
    
    public Bateau (int idB, String nomB, double longueurB, double largeurB) {
        this.idBateau = idB;
        this.nomBateau = nomB;
        this.largeurBateau = largeurB;
        this.longueurBateau = longueurB;
    }
    
    
    public String versChaine(){
        
        return (" Nom du Bateau: " + this.getNomBateau() +"\n Longueur: " + this.getLongueurBateau() +"\n Largeur: " + this.getLargeurBateau());
    }
    
    
}
