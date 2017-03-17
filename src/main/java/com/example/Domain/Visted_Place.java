package com.example.Domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ashraf Atef on 7/1/2016.
 */
@Entity
public class Visted_Place {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Id
    @GeneratedValue
    private Long id ;
    @ManyToOne
    @JoinColumn
    private Place place ;
    @ManyToOne
    @JoinColumn
    private User user ;
    private Date date ;
}
