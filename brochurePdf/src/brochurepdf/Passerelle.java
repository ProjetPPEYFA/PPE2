/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brochurepdf;

import java.util.ArrayList;
/**
 * Classe permettant la récupération des bateau voyageur depuis la bdd
 */
public class Passerelle {
  ArrayList <BateauVoyageur> BateauVoyageur = new ArrayList <BateauVoyageur> ();
  //constructeur
  public Passerelle(ArrayList <BateauVoyageur> bat){
      this.BateauVoyageur = bat;
  }
  //ajout de bateau dans l'arrayListe
  public void addBateau(BateauVoyageur unbat){
      this.BateauVoyageur.add(unbat);
  }
//getteur de l'arrayListe
    public ArrayList<BateauVoyageur> getBateauVoyageur() {
        return BateauVoyageur;
    }
  
}
