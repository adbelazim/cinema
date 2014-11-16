package com.mycompany.cinema;

import com.mycompany.cinema.Actor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-16T17:37:49")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, Integer> yearMovie;
    public static volatile SingularAttribute<Movie, String> descriptionMovie;
    public static volatile CollectionAttribute<Movie, Actor> actorCollection;
    public static volatile SingularAttribute<Movie, String> nameMovie;
    public static volatile SingularAttribute<Movie, Integer> idMovie;

}