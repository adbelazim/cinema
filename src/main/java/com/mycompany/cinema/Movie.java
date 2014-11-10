/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cinema;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristobal
 */
@Entity
@Table(name = "movie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findByIdMovie", query = "SELECT m FROM Movie m WHERE m.idMovie = :idMovie"),
    @NamedQuery(name = "Movie.findByNameMovie", query = "SELECT m FROM Movie m WHERE m.nameMovie = :nameMovie"),
    @NamedQuery(name = "Movie.findByYearMovie", query = "SELECT m FROM Movie m WHERE m.yearMovie = :yearMovie"),
    @NamedQuery(name = "Movie.findByDescriptionMovie", query = "SELECT m FROM Movie m WHERE m.descriptionMovie = :descriptionMovie")})
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_movie")
    private Integer idMovie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "name_movie")
    private String nameMovie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "year_movie")
    private int yearMovie;
    @Size(max = 200)
    @Column(name = "description_movie")
    private String descriptionMovie;
    @ManyToMany(mappedBy = "movieCollection")
    private Collection<Actor> actorCollection;

    public Movie() {
    }

    public Movie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    public Movie(Integer idMovie, String nameMovie, int yearMovie) {
        this.idMovie = idMovie;
        this.nameMovie = nameMovie;
        this.yearMovie = yearMovie;
    }

    public Integer getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public int getYearMovie() {
        return yearMovie;
    }

    public void setYearMovie(int yearMovie) {
        this.yearMovie = yearMovie;
    }

    public String getDescriptionMovie() {
        return descriptionMovie;
    }

    public void setDescriptionMovie(String descriptionMovie) {
        this.descriptionMovie = descriptionMovie;
    }

    @XmlTransient
    public Collection<Actor> getActorCollection() {
        return actorCollection;
    }

    public void setActorCollection(Collection<Actor> actorCollection) {
        this.actorCollection = actorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovie != null ? idMovie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.idMovie == null && other.idMovie != null) || (this.idMovie != null && !this.idMovie.equals(other.idMovie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cinema.Movie[ idMovie=" + idMovie + " ]";
    }
    
}
