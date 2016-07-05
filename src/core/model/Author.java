/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Rogerio
 */
public class Author {
    private int id;
    private String uid;
    private String shortName;
    private String fullName;
    private List<Review> comentarios;

    public Author(String uid, String shortName, String fullName, List<Review> comentarios) {
        this.uid = uid;
        this.shortName = shortName;
        this.fullName = fullName;
        this.comentarios = comentarios;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Review> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Review> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.uid);
        hash = 53 * hash + Objects.hashCode(this.shortName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Author other = (Author) obj;
        if (!Objects.equals(this.uid, other.uid)) {
            return false;
        }
        if (!Objects.equals(this.shortName, other.shortName)) {
            return false;
        }
        return true;
    }
    
    
}
