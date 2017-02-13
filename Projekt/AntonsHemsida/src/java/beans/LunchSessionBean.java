/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.entities.LunchEntity;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Joakim
 */
@Named(value = "lunchSessionBean")
@SessionScoped
public class LunchSessionBean implements Serializable {

    @PersistenceContext(unitName = "AntonsHemsidaPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    //Ex på ändra i en databas: https://www.mkyong.com/jsf2/how-to-update-row-in-jsf-datatable/
    /**
     * Creates a new instance of LunchSessionBean
     */
    public LunchSessionBean() {
    }
    
    public void setlunch() {
        /*TypedQuery<LunchEntity> q = em.createNamedQuery("getAll", LunchEntity.class);
        List<LunchEntity> resultList = q.getResultList();
        
        LunchEntity newLunch = resultList.get(0);
        newLunch.setName("Pannkakor 2");
        newLunch.setDescription("Med grädde och sylt 2");
        newLunch.setPrice(82);
        
        resultList.set(0, newLunch);
        
        em.merge(resultList);*/
        
        LunchEntity lunchname = new LunchEntity();
        lunchname.setLunchday("Måndag");
        lunchname.setName("Paj");
        lunchname.setDescription("Med grädde och sylt");
        lunchname.setPrice(82);
        persist(lunchname);    
    }
    public int updateLunchPrice(Integer price, String name) {
    Query update_query = em.createQuery("UPDATE LunchEntity p SET p.price= ?1 WHERE p.name= ?2 ");
    update_query.setParameter(1, price);
    update_query.setParameter(2, name);
    //update_query.executeUpdate();
    //em.setFlushMode(FlushModeType.COMMIT);
    //em.close();
    persist(update_query);
    return 1;
  }
    
    public String getlunch() {
        TypedQuery<LunchEntity> q = em.createNamedQuery("getAll", LunchEntity.class);
        List<LunchEntity> resultList = q.getResultList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultList.size(); i++) {
            LunchEntity nameAndMessage = resultList.get(i);
            sb.append("<h2>");
            sb.append(nameAndMessage.getLunchday());
            sb.append("</h2>");
            sb.append("<h3>");
            sb.append(nameAndMessage.getName());
            sb.append(" "); 
            sb.append(nameAndMessage.getPrice());
            sb.append(":-");
            sb.append("</h3>");
            sb.append("<p>");
            sb.append(nameAndMessage.getDescription());
            sb.append("</p>");
            
        }
        return sb.toString();
    }
    
    /*Hämta lunchmeny*/
    
    /*Hämta lunch på index*/

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
