package db;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
    @NamedQuery(name = "Image.selectAll", query = "SELECT img FROM Image img"),
    @NamedQuery(name = "Image.removeById", query = "DELETE FROM Image img WHERE img.id= :IMGID")     
})
@Entity

public class Image implements Serializable {
    private String description;
    private String url;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode():0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        //TODO: warning-this method wont work in the case the id fields are not set
        if(!(object instanceof Image)) {
            return false;
        }
        Image other = (Image) object;
        if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "db.Images[ id=" + id + " ]";
    }
    
}
