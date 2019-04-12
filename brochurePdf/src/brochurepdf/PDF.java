/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brochurepdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *
 * @author mahammed.yazid
 */
public class PDF {
    
     Document doc = new Document();
    
    public PDF(String nomDocument){
        
        try{
        PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\mahammed.yazid\\Desktop\\"+nomDocument+".pdf"));
        doc.open();
        doc.add (new Paragraph("test"));
        doc.close();
        
        }
        
        catch(FileNotFoundException f){
            System.out.println(f);
        }
        
        catch (DocumentException d){
            System.out.println(d);
        }
    }
    
    public void ouvrir(Document docu){
        
        docu.open();
    }
    
    public void fermer(Document docu){
        
        docu.close();
    }
    public void ecrireTexte(String leTexte) throws DocumentException{
        
        doc.add (new Paragraph(leTexte));
  
    }
    
    public void chargerImage(Document docu, String chemin) throws DocumentException, BadElementException, IOException{
        
        Image img = Image.getInstance(chemin);
        docu.add(img);
        
    }
    
}
