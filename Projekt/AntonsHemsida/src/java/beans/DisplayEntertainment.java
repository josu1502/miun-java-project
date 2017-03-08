/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Image;
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
 * @author and12edi
 */
@Named(value = "displayEntertainment")
@SessionScoped
public class DisplayEntertainment implements Serializable {

    @PersistenceContext(unitName = "AntonsHemsidaPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    public DisplayEntertainment() {
    }

    public String displayAllPosters() {
        TypedQuery<Image> tq = em.createNamedQuery("Image.selectAll", Image.class);
        List<Image> resultList = tq.getResultList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultList.size(); i++) {
            Image posterAndDescription = resultList.get(i);
            sb.append("<br/>");
            sb.append("<h3>");
            sb.append(posterAndDescription.getDescription());
            sb.append("</h3>");
            sb.append("<br/>");
            sb.append("<img width='400px' height='400px' src='/Images/"+posterAndDescription.getUrl()+"'");
            sb.append(" alt='poster is missing'></img>");
            sb.append("<br/>");
            sb.append("<br/>");
            sb.append("<br/>");
            sb.append("<h1></h1>");
            
        }
        return sb.toString();
    }
}
