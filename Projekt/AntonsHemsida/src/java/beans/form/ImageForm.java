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
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.persistence.TypedQuery;

/**
 *
 * @author maski
 */
@Named(value = "imageForm")
@RequestScoped
public class ImageForm {

    private Part image;
    private String description;
    private final String localPath = "\\Users\\maski\\OneDrive\\Documents\\";
    private final String imagePath = localPath + "GitHub\\miun-java-project\\Projekt\\Images\\web\\";
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

    private String getImagesFileName() {
        String fileName = "image";
        Random random = new Random();
        fileName += String.format("%1$06x", random.nextInt(4000));
        return fileName;
    }

    public String delete(Long id) {
        try {
            utx.begin();
            TypedQuery<Image> imageListQuery = em.createNamedQuery("Image.removeById", Image.class);
            imageListQuery.setParameter("IMGID", id);
            imageListQuery.executeUpdate();
            System.out.println(imageListQuery.toString());
            utx.commit();
            return "imageHandler.xhtml";

        } catch (Exception ex) {
            Logger.getLogger(ImageForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "error.xhtml";
    }

    public String save() {
        if (image != null) {
            try (InputStream input = image.getInputStream()) {
                Path outPath = FileSystems.getDefault().getPath(imagePath, getImagesFileName());
                while (Files.exists(outPath)) {
                    outPath = FileSystems.getDefault().getPath(imagePath, getImagesFileName());
                }
                Files.copy(input, outPath);
                Image img = new Image();
                img.setDescription(description);
                img.setUrl(outPath.getFileName().toString());
                persist(img);
            } catch (Exception ex) {
                return "error.xthml";
            }
        }
        
        return "imageHandler.xhtml";
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
