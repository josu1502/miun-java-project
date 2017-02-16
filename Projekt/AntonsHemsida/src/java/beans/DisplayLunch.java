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
import java.util.ArrayList;
import java.util.Calendar;
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
@Named(value = "displayLunch")
@SessionScoped
public class DisplayLunch implements Serializable {

    @PersistenceContext(unitName = "AntonsHemsidaPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    
    public DisplayLunch() {
    }

    public String displayLunchByDay(String day) {
        TypedQuery<LunchEntity> tq = em.createNamedQuery("getDay", LunchEntity.class).setParameter("weekday", day);
        List<LunchEntity> resultlist = tq.getResultList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultlist.size(); i++) {
            LunchEntity nameAndMessage = resultlist.get(i);

            sb.append("<h3>");
            sb.append(nameAndMessage.getName());
            sb.append(" ");
            sb.append(nameAndMessage.getPrice());
            sb.append(":-");
            sb.append("</h3>");
            sb.append(nameAndMessage.getDescription());
        }
        return sb.toString();
    }
    
    public String displayLunchToday() {
        
    
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        String currentDay;
        if(day == 2){
            currentDay = "Måndag";
        }
        else if(day == 3){
            currentDay = "Tisdag";
        }
        else if(day == 4){
            currentDay = "Onsdag";
        }
        else if(day == 5){
            currentDay = "Torsdag";
        }
        else if(day == 6){
            currentDay = "Fredag";
        }
        else if(day == 7){
            currentDay = "Lördag";
        }
        else {
            currentDay = "Söndag";
        }
        TypedQuery<LunchEntity> tq = em.createNamedQuery("getDay", LunchEntity.class).setParameter("weekday", currentDay);
        List<LunchEntity> resultlist = tq.getResultList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultlist.size(); i++) {
            LunchEntity nameAndMessage = resultlist.get(i);

            sb.append("<h3>");
            sb.append(nameAndMessage.getName());
            sb.append(" ");
            sb.append(nameAndMessage.getPrice());
            sb.append(":-");
            sb.append("</h3>");
            sb.append(nameAndMessage.getDescription());
        }
        return sb.toString();

    }

}
