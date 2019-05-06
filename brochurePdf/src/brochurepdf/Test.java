/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brochurepdf;
import com.itextpdf.text.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;



/**
 *
 * @author mahammed.yazid
 */
public class Test {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, DocumentException {
        
        
        /*
        Equipement equip1 = new Equipement(1, "Coque Renforcée");
        Equipement equip2 = new Equipement(2, "Gyroscope");

        
        BateauVoyageur bateau1 = new BateauVoyageur(1,"p'tit Bateau", 5.3, 2.5, 36.5,"image.png");
        bateau1.ajouterEquipement(equip1);
        bateau1.ajouterEquipement(equip2);
        
        /*PDF docu1 = new PDF("test.pdf");
        Desktop.getDesktop().open(new File("C:\\Users\\mahammed.yazid\\Desktop\\test.pdf"));
        
        
        System.out.println(bateau1.versChaine());*/
        
        PDF unPdf = new PDF("test.pdf");
        unPdf.ecrirePDF("jecris dans le fichier");
        unPdf.Fermer();
        
         
    }
    
}
