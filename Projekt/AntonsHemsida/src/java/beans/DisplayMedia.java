/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.MediaEntity;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author maski
 */
@Named(value = "displayMedia")
@SessionScoped
public class DisplayMedia implements Serializable {

    @PersistenceContext(unitName = "AntonsHemsidaPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    public DisplayMedia() {
    }

     public String displayAllMediaImages() {
        TypedQuery<MediaEntity> tq = em.createNamedQuery("MediaEntity.selectAllMedia", MediaEntity.class);
        List<MediaEntity> resultList = tq.getResultList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultList.size(); i++) {
            MediaEntity mediaImageAndDescription = resultList.get(i);
            sb.append("<img title='" + mediaImageAndDescription.getDescription()+"' width='150px' height='100%' src='/Images/"+mediaImageAndDescription.getUrl()+"'");
            sb.append(" alt='poster is missing'></img>");
            
            
            
        }
        return sb.toString();
    }
    
}
