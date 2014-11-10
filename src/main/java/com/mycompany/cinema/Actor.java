/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cinema;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristobal
 */
@Entity
@Table(name = "actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a"),
    @NamedQuery(name = "Actor.findByIdActor", query = "SELECT a FROM Actor a WHERE a.idActor = :idActor"),
    @NamedQuery(name = "Actor.findByNameActor", query = "SELECT a FROM Actor a WHERE a.nameActor = :nameActor"),
    @NamedQuery(name = "Actor.findByLastnameActor", query = "SELECT a FROM Actor a WHERE a.lastnameActor = :lastnameActor"),
    @NamedQuery(name = "Actor.findByBirthdayActor", query = "SELECT a FROM Actor a WHERE a.birthdayActor = :birthdayActor")})
public class Actor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_actor")
    private Integer idActor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name_actor")
    private String nameActor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastname_actor")
    private String lastnameActor;
    @Column(name = "birthday_actor")
    @Temporal(TemporalType.DATE)
    private Date birthdayActor;
    @JoinTable(name = "movie_has_actor", joinColumns = {
        @JoinColumn(name = "actor_id_actor", referencedColumnName = "id_actor")}, inverseJoinColumns = {
        @JoinColumn(name = "movie_id_movie", referencedColumnName = "id_movie")})
    @ManyToMany
    private Collection<Movie> movieCollection;

    public Actor() {
    }

    public Actor(Integer idActor) {
        this.idActor = idActor;
    }

    public Actor(Integer idActor, String nameActor, String lastnameActor) {
        this.idActor = idActor;
        this.nameActor = nameActor;
        this.lastnameActor = lastnameActor;
    }

    public Integer getIdActor() {
        return idActor;
    }

    public void setIdActor(Integer idActor) {
        this.idActor = idActor;
    }

    public String getNameActor() {
        return nameActor;
    }

    public void setNameActor(String nameActor) {
        this.nameActor = nameActor;
    }

    public String getLastnameActor() {
        return lastnameActor;
    }

    public void setLastnameActor(String lastnameActor) {
        this.lastnameActor = lastnameActor;
    }

    public Date getBirthdayActor() {
        return birthdayActor;
    }

    public void setBirthdayActor(Date birthdayActor) {
        this.birthdayActor = birthdayActor;
    }

    @XmlTransient
    public Collection<Movie> getMovieCollection() {
        return movieCollection;
    }

    public void setMovieCollection(Collection<Movie> movieCollection) {
        this.movieCollection = movieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActor != null ? idActor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.idActor == null && other.idActor != null) || (this.idActor != null && !this.idActor.equals(other.idActor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cinema.Actor[ idActor=" + idActor + " ]";
    }
    
}
