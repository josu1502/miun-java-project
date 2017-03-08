/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.form;

import db.Image;
import db.MediaEntity;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author maski
 */
@Named(value = "imageList")
@RequestScoped
public class ImageList {

    @PersistenceContext(unitName = "AntonsHemsidaPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    
    public ImageList() {
    }

    public List<Image> getPosterImages() {
        TypedQuery<Image> selectAllImages = em.createNamedQuery("Image.selectAll", Image.class);
        return selectAllImages.getResultList();
    }
    public List<MediaEntity> getMediaImages() {
        TypedQuery<MediaEntity> selectAllMediaImages = em.createNamedQuery("MediaEntity.selectAllMedia", MediaEntity.class);
        return selectAllMediaImages.getResultList();
    }
}
