package com.example.itakademija.easy_notes_2020.business.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "NOTE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdat","updatedat"})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n")
    , @NamedQuery(name = "Note.findById", query = "SELECT n FROM Note n WHERE n.id = :id")
    , @NamedQuery(name = "Note.findByTitle", query = "SELECT n FROM Note n WHERE n.title = :title")
    , @NamedQuery(name = "Note.findByDescription", query = "SELECT n FROM Note n WHERE n.description = :description")
    , @NamedQuery(name = "Note.findByCreatedat", query = "SELECT n FROM Note n WHERE n.createdat = :createdat")
    , @NamedQuery(name = "Note.findByUpdatedat", query = "SELECT n FROM Note n WHERE n.updatedat = :updatedat")})
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "CREATEDAT")
    @Temporal(TemporalType.TIME)
    private Date createdat;
    @Column(name = "UPDATEDAT")
    @Temporal(TemporalType.TIME)
    private Date updatedat;

    public Note() {
    }

    public Note(Integer id) {
        this.id = id;
    }

    public Note(Integer id, String title, String description, Date createdat) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdat = createdat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.itakademija.easy_notes_2020.business.model.Note[ id=" + id + " ]";
    }
    
}
