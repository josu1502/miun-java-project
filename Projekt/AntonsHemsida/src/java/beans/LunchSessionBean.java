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
import javax.persistence.PersistenceContext;
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
    
    /**
     * Creates a new instance of LunchSessionBean
     */
    public LunchSessionBean() {
    }
    
    public void setlunch() {
        String name = "Pannkakor";
        LunchEntity lunchname = new LunchEntity();
        lunchname.setName(name);
        lunchname.setDescription("Med grädde och sylt");
        lunchname.setPrice(79);
        persist(lunchname);
        
    }
    public String getlunch() {
         TypedQuery<LunchEntity> q = em.createNamedQuery("getAll", LunchEntity.class);
        List<LunchEntity> resultList = q.getResultList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultList.size(); i++) {
            LunchEntity nameAndMessage = resultList.get(i);
            sb.append("<h3>");
            sb.append(nameAndMessage.getName());
            sb.append(" "); 
            sb.append(nameAndMessage.getPrice());
            sb.append(":-");
            sb.append("</h3>");
            //sb.append("</ br>");
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
