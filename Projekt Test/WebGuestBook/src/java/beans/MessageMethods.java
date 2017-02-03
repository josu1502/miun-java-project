/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.entities.MessageLog;
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
@Named(value = "messageMethods")
@SessionScoped
public class MessageMethods implements Serializable {

    @PersistenceContext(unitName = "WebGuestBookPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    
    private String name;
    private String message;
    /**
     * Creates a new instance of MessageMethods
     */
    public MessageMethods() {
    }
    
    
    public void sendMessage() {
        MessageLog msglog = new MessageLog();
        msglog.setName(name);
        msglog.setMessage(message);
        
        persist(msglog);
        
        name = "";
        message = "";
    }
    
    public String getMessages() {
        TypedQuery<MessageLog> q = em.createNamedQuery("getAll", MessageLog.class);
        List<MessageLog> resultList = q.getResultList();
        
        String allMessages = "";
        
        for (int i = 0; i < resultList.size(); i++) {
            MessageLog nameAndMessage = resultList.get(i);
            allMessages += nameAndMessage.getName();
            allMessages += ": ";
            allMessages += nameAndMessage.getMessage();
            allMessages += "\n";
            //nameAndMessage.
            //allMessages += System.getProperty("line.Seperator");
        }
        
        return allMessages;
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
}
