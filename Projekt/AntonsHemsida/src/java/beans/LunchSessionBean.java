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
    
    private Integer index;

    /**
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @return the måndag_name
     */
    public String getMåndag_name() {
        return måndag_name;
    }

    /**
     * @param måndag_name the måndag_name to set
     */
    public void setMåndag_name(String måndag_name) {
        this.måndag_name = måndag_name;
    }

    /**
     * @return the måndag_desc
     */
    public String getMåndag_desc() {
        return måndag_desc;
    }

    /**
     * @param måndag_desc the måndag_desc to set
     */
    public void setMåndag_desc(String måndag_desc) {
        this.måndag_desc = måndag_desc;
    }

    /**
     * @return the måpndag_price
     */
    public Integer getMåndag_price() {
        return måndag_price;
    }

    /**
     * @param måpndag_price the måpndag_price to set
     */
    public void setMåndag_price(Integer måpndag_price) {
        this.måndag_price = måndag_price;
    }

    /**
     * @return the tisdag_name
     */
    public String getTisdag_name() {
        return tisdag_name;
    }

    /**
     * @param tisdag_name the tisdag_name to set
     */
    public void setTisdag_name(String tisdag_name) {
        this.tisdag_name = tisdag_name;
    }

    /**
     * @return the tisdag_desc
     */
    public String getTisdag_desc() {
        return tisdag_desc;
    }

    /**
     * @param tisdag_desc the tisdag_desc to set
     */
    public void setTisdag_desc(String tisdag_desc) {
        this.tisdag_desc = tisdag_desc;
    }

    /**
     * @return the tisdag_price
     */
    public Integer getTisdag_price() {
        return tisdag_price;
    }

    /**
     * @param tisdag_price the tisdag_price to set
     */
    public void setTisdag_price(Integer tisdag_price) {
        this.tisdag_price = tisdag_price;
    }

    /**
     * @return the onsdag_name
     */
    public String getOnsdag_name() {
        return onsdag_name;
    }

    /**
     * @param onsdag_name the onsdag_name to set
     */
    public void setOnsdag_name(String onsdag_name) {
        this.onsdag_name = onsdag_name;
    }

    /**
     * @return the onsdag_desc
     */
    public String getOnsdag_desc() {
        return onsdag_desc;
    }

    /**
     * @param onsdag_desc the onsdag_desc to set
     */
    public void setOnsdag_desc(String onsdag_desc) {
        this.onsdag_desc = onsdag_desc;
    }

    /**
     * @return the onsdag_price
     */
    public Integer getOnsdag_price() {
        return onsdag_price;
    }

    /**
     * @param onsdag_price the onsdag_price to set
     */
    public void setOnsdag_price(Integer onsdag_price) {
        this.onsdag_price = onsdag_price;
    }

    /**
     * @return the torsdag_name
     */
    public String getTorsdag_name() {
        return torsdag_name;
    }

    /**
     * @param torsdag_name the torsdag_name to set
     */
    public void setTorsdag_name(String torsdag_name) {
        this.torsdag_name = torsdag_name;
    }

    /**
     * @return the torsdag_desc
     */
    public String getTorsdag_desc() {
        return torsdag_desc;
    }

    /**
     * @param torsdag_desc the torsdag_desc to set
     */
    public void setTorsdag_desc(String torsdag_desc) {
        this.torsdag_desc = torsdag_desc;
    }

    /**
     * @return the torsdag_price
     */
    public Integer getTorsdag_price() {
        return torsdag_price;
    }

    /**
     * @param torsdag_price the torsdag_price to set
     */
    public void setTorsdag_price(Integer torsdag_price) {
        this.torsdag_price = torsdag_price;
    }

    /**
     * @return the fredag_name
     */
    public String getFredag_name() {
        return fredag_name;
    }

    /**
     * @param fredag_name the fredag_name to set
     */
    public void setFredag_name(String fredag_name) {
        this.fredag_name = fredag_name;
    }

    /**
     * @return the fredag_desc
     */
    public String getFredag_desc() {
        return fredag_desc;
    }

    /**
     * @param fredag_desc the fredag_desc to set
     */
    public void setFredag_desc(String fredag_desc) {
        this.fredag_desc = fredag_desc;
    }

    /**
     * @return the fredag_price
     */
    public Integer getFredag_price() {
        return fredag_price;
    }

    /**
     * @param fredag_price the fredag_price to set
     */
    public void setFredag_price(Integer fredag_price) {
        this.fredag_price = fredag_price;
    }

    
    
    private class LunchStruct {

        public String day;
        public String name;
        public String desc;
        public Integer price;
    }
        private String day;
        private String måndag_name;
        private String måndag_desc;
        private Integer måndag_price;
        
        private String tisdag_name;
        private String tisdag_desc;
        private Integer tisdag_price;
        
        private String onsdag_name;
        private String onsdag_desc;
        private Integer onsdag_price;
        
        private String torsdag_name;
        private String torsdag_desc;
        private Integer torsdag_price;
        
        private String fredag_name;
        private String fredag_desc;
        private Integer fredag_price;
    
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
    
    public void createLunchByDay(String day) {
        LunchEntity lunchname = new LunchEntity();
        lunchname.setLunchday(day);
        if(day == "Måndag") {
            lunchname.setName(getMåndag_name());
            lunchname.setDescription(getMåndag_desc());
            lunchname.setPrice(getMåndag_price());
        }
        else if(day == "Tisdag") {
            lunchname.setName(getTisdag_name());
            lunchname.setDescription(getTisdag_desc());
            lunchname.setPrice(getTisdag_price());
        }
        else if(day == "Onsdag"){
            lunchname.setName(getOnsdag_name());
            lunchname.setDescription(getOnsdag_desc());
            lunchname.setPrice(getOnsdag_price());
        }
        else if(day == "Torsdag"){
            lunchname.setName(getTorsdag_name());
            lunchname.setDescription(getTorsdag_desc());
            lunchname.setPrice(getTorsdag_price());
        }
        else if(day == "Fredag"){
            lunchname.setName(getFredag_name());
            lunchname.setDescription(getFredag_desc());
            lunchname.setPrice(getFredag_price());
        }
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
    public String displayLunchMenu() {
        TypedQuery<LunchEntity> q = em.createNamedQuery("getAll", LunchEntity.class
        );
        List<LunchEntity> resultList = q.getResultList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultList.size(); i++) {
            LunchEntity nameAndMessage = resultList.get(i);
            sb.append("<h1>");
            sb.append(nameAndMessage.getLunchday());
            sb.append("</h1>");
            sb.append("<h2>");
            sb.append(nameAndMessage.getName());
            sb.append(" ");
            sb.append(nameAndMessage.getPrice());
            sb.append(":-");
            sb.append("</h2>");
            sb.append(nameAndMessage.getDescription());
        }
        return sb.toString();
    }
    
    public String displayLunchByDay(String day){
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
    

}
