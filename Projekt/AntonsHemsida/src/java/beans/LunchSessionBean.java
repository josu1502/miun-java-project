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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

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

    private class LunchStruct {

        public String day;
        public String name;
        public String desc;
        public Integer price;
    }
    private List<LunchStruct> lunchList = new ArrayList<>();

    /**
     * Creates a new instance of LunchSessionBean
     */
    public LunchSessionBean() {
    }
    
    public void init() {
        TypedQuery<LunchEntity> q = em.createNamedQuery("getAll", LunchEntity.class);
        List<LunchEntity> resultList = q.getResultList();

        for (int i = 0; i < resultList.size(); i++) {
            LunchStruct ls = new LunchStruct();
            ls.day = resultList.get(i).getLunchday();
            ls.name = resultList.get(i).getName();
            ls.desc = resultList.get(i).getDescription();
            ls.price = resultList.get(i).getPrice();
            lunchList.add(ls);
        }
    }

    public void createLunchEntity(String day, String name, String desc, Integer price) {
        LunchEntity lunchname = new LunchEntity();
        lunchname.setLunchday(day);
        lunchname.setName(name);
        lunchname.setDescription(desc);
        lunchname.setPrice(price);
        persist(lunchname);
    }

    public void updateAll() {
        for (int i = 0; i < lunchList.size(); i++) {
            updateLunchDayIndex(lunchList.get(i).day, i);
            updateLunchNameIndex(lunchList.get(i).name, i);
            updateLunchDescIndex(lunchList.get(i).desc, i);
            updateLunchPriceIndex(lunchList.get(i).price, i);
        }
    }

    public void updateLunchDayIndex(String day, Integer index) {
        try {
            utx.begin();
            TypedQuery<LunchEntity> q = em.createNamedQuery("getAll", LunchEntity.class
            );
            List<LunchEntity> resultList = q.getResultList();
            LunchEntity updateEntity = resultList.get(index);
            updateEntity.setLunchday(day);
            utx.commit();

        } catch (Exception ex) {
            Logger.getLogger(LunchSessionBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateLunchNameIndex(String name, Integer index) {
        try {
            utx.begin();
            TypedQuery<LunchEntity> q = em.createNamedQuery("getAll", LunchEntity.class
            );
            List<LunchEntity> resultList = q.getResultList();
            LunchEntity updateEntity = resultList.get(index);
            updateEntity.setName(name);
            utx.commit();

        } catch (Exception ex) {
            Logger.getLogger(LunchSessionBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateLunchDescIndex(String desc, Integer index) {
        try {
            utx.begin();
            TypedQuery<LunchEntity> q = em.createNamedQuery("getAll", LunchEntity.class
            );
            List<LunchEntity> resultList = q.getResultList();
            LunchEntity updateEntity = resultList.get(index);
            updateEntity.setDescription(desc);
            utx.commit();

        } catch (Exception ex) {
            Logger.getLogger(LunchSessionBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateLunchPriceIndex(Integer price, Integer index) {
        try {
            utx.begin();
            TypedQuery<LunchEntity> q = em.createNamedQuery("getAll", LunchEntity.class
            );
            List<LunchEntity> resultList = q.getResultList();
            LunchEntity updateEntity = resultList.get(index);
            updateEntity.setPrice(price);
            utx.commit();

        } catch (Exception ex) {
            Logger.getLogger(LunchSessionBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String
            readLunchDayIndex(Integer index) {
        TypedQuery<LunchEntity> q = em.createNamedQuery("getAll", LunchEntity.class
        );
        List<LunchEntity> resultList = q.getResultList();
        return resultList.get(index).getLunchday();
    }

    public String
            readLunchNameIndex(Integer index) {
        TypedQuery<LunchEntity> q = em.createNamedQuery("getAll", LunchEntity.class
        );
        List<LunchEntity> resultList = q.getResultList();
        return resultList.get(index).getName();
    }

    public String
            readLunchDescIndex(Integer index) {
        TypedQuery<LunchEntity> q = em.createNamedQuery("getAll", LunchEntity.class
        );
        List<LunchEntity> resultList = q.getResultList();
        return resultList.get(index).getDescription();
    }

    public Integer
            readLunchPriceIndex(Integer index) {
        TypedQuery<LunchEntity> q = em.createNamedQuery("getAll", LunchEntity.class
        );
        List<LunchEntity> resultList = q.getResultList();
        return resultList.get(index).getPrice();
    }

    /*display... bygger html kod*/
    public String
            displayLunchMenu() {
        TypedQuery<LunchEntity> q = em.createNamedQuery("getAll", LunchEntity.class
        );
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

    /*Getter and setter for this object, not the entity. Used in textfields.*/
    public String getDay(Integer index) {
        return lunchList.get(index).day;
    }

    public void setDay(String day, Integer index) {
        this.lunchList.get(index).day = day;
    }

    public String getName(Integer index) {
        return lunchList.get(index).name;
    }

    public void setName(String name, Integer index) {
        this.lunchList.get(index).name = name;
    }

    public String getDesc(Integer index) {
        return lunchList.get(index).desc;
    }

    public void setDesc(String desc, Integer index) {
        this.lunchList.get(index).desc = desc;
    }

    public Integer getPrice(Integer index) {
        return lunchList.get(index).price;
    }

    public void setPrice(Integer price, Integer index) {
        this.lunchList.get(index).price = price;
    }

}
