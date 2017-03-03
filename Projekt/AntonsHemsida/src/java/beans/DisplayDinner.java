/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.entities.DinnerEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author and12edi
 */
@Named(value = "displayDinner")
@Dependent
public class DisplayDinner {

    @PersistenceContext(unitName = "AntonsHemsidaPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of DisplayDinner
     */
    public DisplayDinner() {
    }

    public String displayDinnerByType(String type){
        TypedQuery<DinnerEntity> tq = em.createNamedQuery("getType", DinnerEntity.class).setParameter("type_arg", type);
        List<DinnerEntity> resultlist = tq.getResultList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultlist.size(); i++) {
            DinnerEntity nameAndMessage = resultlist.get(i);

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
        sb.append("<br/>");
        return sb.toString();
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
