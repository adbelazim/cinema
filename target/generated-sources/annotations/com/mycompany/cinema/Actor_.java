package com.mycompany.cinema;

import com.mycompany.cinema.Movie;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-16T17:37:49")
@StaticMetamodel(Actor.class)
public class Actor_ { 

    public static volatile SingularAttribute<Actor, String> nameActor;
    public static volatile SingularAttribute<Actor, Integer> idActor;
    public static volatile SingularAttribute<Actor, Date> birthdayActor;
    public static volatile CollectionAttribute<Actor, Movie> movieCollection;
    public static volatile SingularAttribute<Actor, String> lastnameActor;

}