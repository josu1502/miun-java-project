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
 * Detta är en sessionsböna. Den tillhör entitetsbönan MessageLog.java. I denna
 * fil anger man funktioner som används i xhtml filen som skickar och hämtar
 * information från tabellen MessageLog i databasen.
 *
 * @author Joakim Sundqvist
 */
@Named(value = "messageMethods")
@SessionScoped
public class MessageMethods implements Serializable {

    @PersistenceContext(unitName = "WebGuestBookPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    /*
    Anger två privata variabler med getters och setters som används i 
    textfältet på hemsidan
    */
    private String name;
    private String message;

    /**
     * Creates a new instance of MessageMethods
     */
    public MessageMethods() {
    }

    /**
     * Skapar en ny tupel/rad för tabellen "MessageLog". Fyller den med denna
     * klassens "name" och "message", skickar in den i databasen med persist och
     * återställer "name" och "message" till tomma strängar så att textfälten
     * blir tomma på hemsidan.
     */
    public void sendMessage() {
        MessageLog msglog = new MessageLog();
        msglog.setName(name);
        msglog.setMessage(message);

        persist(msglog);

        name = "";
        message = "";
    }

    /**
     * Skapar en lista med alla tupler/rader från tabellen "MessageLog". Bygger
     * en sträng med en for-loop som innehåller alla "name" och "message" och
     * rabyten. Returerar därefter denna långa sträng som innehåller alla
     * meddelanden så den kan visas på hemidan.
     *
     * @return - En sträng med alla meddelanden.
     */
    public String getMessages() {
        /*
        Skapar ett SQL-kall som hämtar alla rader. Denna är definierad i
        MessageLog och är döpt till "getAll"
        */
        TypedQuery<MessageLog> q = em.createNamedQuery("getAll",
                MessageLog.class);
        List<MessageLog> resultList = q.getResultList();

        String allMessages = ""; //String builder bör användas

        /*Bygger strängen som innehåller allt*/
        for (int i = 0; i < resultList.size(); i++) {
            MessageLog nameAndMessage = resultList.get(i);
            allMessages += nameAndMessage.getName();
            allMessages += ": ";
            allMessages += nameAndMessage.getMessage();
            allMessages += "\n";
        }

        return allMessages;
    }
    
    /**
     * Denna kod följer med gratis och används för att skicka in tupler/rader
     * till en databas.
     * @param object 
     */
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    /*
    Getters och setter för egenskapade variabler som används i textfälten på
    hemsidan
    */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
