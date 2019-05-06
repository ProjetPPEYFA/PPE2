/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brochurepdf;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.scenario.effect.ImageData;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *
 * @author WESHALORS
 */
public class PDF {
      private  String FILE = "C://Users//WESHALORS//Documents//NetBeansProjects//marieteam//";
    private String name;
    Document unDoc;
    
    public PDF(String nom){    
         try {
            this.name = nom;
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(this.FILE+nom));
            this.unDoc = document;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ecrirePDF(String chaine) throws FileNotFoundException, DocumentException{
       
      
         Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
         Chunk chunk = new Chunk(chaine, font);
         this.unDoc.add(new Paragraph(chunk));

    }
    public void ChargerImage(String ImageLink) throws URISyntaxException, BadElementException, IOException, DocumentException{
        
         PdfWriter.getInstance(this.unDoc, new FileOutputStream(this.FILE+this.name));
         this.unDoc.open();
         Image img = Image.getInstance(ImageLink);
         this.unDoc.add(img);
    }
    public void Fermer(){
        this.unDoc.close();
    }
    
}
