/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.form;

import db.Image;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Part;
import java.nio.file.Path;
import javax.ws.rs.core.Configuration;

/**
 *
 * @author maski
 */
@Named(value = "imageForm")
@RequestScoped
public class ImageForm {
    private Part image;
    private String description;
    private final String localPath = "C:\\Users\\maski\\OneDrive\\Documents\\";
    private final String imagePath = localPath + "GitHub\\miun-java-project\\Projekt\\Images\\web"; 
    @PersistenceContext(unitName = "AntonsHemsidaPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    
    public ImageForm() {
    }
    
    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    private static String getImageFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for(String s: items) {
            if(s.trim().startsWith("filename")){
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "hittar inte filnamnet";
    }
    
    public String save() {
        if(image != null) {
            try(InputStream input = image.getInputStream()) {
                Path outPath = FileSystems.getDefault().getPath(imagePath, getImageFileName(image));
                while(Files.exists(outPath)) {
                    outPath = FileSystems.getDefault().getPath(imagePath, getImageFileName(image));
                }
                Files.copy(input, outPath);
                Image img = new Image();
                img.setDescription(description);
                img.setUrl(outPath.getFileName().toString());
                persist(image);
            } catch (IOException ex) {
                return "error.xthml";
            }
        }
        return "saved.xhtml";
    }
    
    
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    
    
    
    
}
