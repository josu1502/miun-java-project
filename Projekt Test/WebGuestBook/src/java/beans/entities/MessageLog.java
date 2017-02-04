package beans.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * En entitetsböna lägger grunden till hur man vill att en tabell ska vara
 * utformad i en databas.
 *
 * @author Joakim Sundqvist
 */
@NamedQuery(name = "getAll", query = "SELECT Object(o) FROM MessageLog o")
@Entity
@XmlRootElement
public class MessageLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String message;

    /*Alla getters och setter för medlemmarna i tabellen måste finnas med*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    /*Gratis kod som förljer med entitetsbönan och måste finnas med*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageLog)) {
            return false;
        }
        MessageLog other = (MessageLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.entities.MessageLog[ id=" + id + " ]";
    }
}
