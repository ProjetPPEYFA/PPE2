/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brochurepdf;


import java.io.BufferedReader;
import java.io.FileReader;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maison
 */
public class PDFTest {
    
    PDF fichier_test = new PDF("fichier de test", "fichier_test.pdf");
    public PDFTest() {
        Assert.assertNotNull(fichier_test);
        
    }
    


    /**
     * Test of ecrirePDF method, of class PDF.
     */
    @Test
    public void testEcrirePDF() throws Exception {
        String chaine = "Test d'écriture";
        fichier_test.ecrirePDF(chaine);
        BufferedReader br = new BufferedReader(new FileReader("fichier_test.pdf"));

        Assert.assertNotNull(br.readLine());
    }

    /**
     * Test of ChargerImage method, of class PDF.
     */
    @Test
    public void testChargerImage() throws Exception {
        String ImageLink = "image/Titanic.jpg";
        fichier_test.ChargerImage(ImageLink);
        /** A FINIR **/

    }

    /**
     * Test of Fermer method, of class PDF.
     */
   
}

