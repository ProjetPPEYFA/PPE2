/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brochurepdf;

public class BateauFret extends Bateau {

    private double poidsMaxBatFret; 
    
    public BateauFret(int idB, String nomB, double longueurB, double largeurB, double poid) {
        /**Crée un bateau de fret **/
        super(idB, nomB, longueurB, largeurB);
        this.poidsMaxBatFret = poid;
    }

    public double getPoidsMaxBatFret() {
        return poidsMaxBatFret;
    }

    public void setPoidsMaxBatFret(double poidsMaxBatFret) {
        this.poidsMaxBatFret = poidsMaxBatFret;
    }
}
