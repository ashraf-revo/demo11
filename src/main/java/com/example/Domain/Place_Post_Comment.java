package com.example.Domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Ashraf Atef on 7/1/2016.
 */
//@Entity
//public class Place_Post_Comment {
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser( User user) {
//        this.user = user;
//    }
//
//    public Place_Post getPlace_post() {
//        return place_post;
//    }
//
//    public void setPlace_post(Place_Post place_post) {
//        this.place_post = place_post;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    @Id
//    @GeneratedValue
//    private Long id ;
//    @Length(min = 1, max = 1000, message = "Place Description Error Messsage")
//    @Column(length = 1000 ,nullable = false )
//    @NotBlank(message = "should not be empty")
//    @NotNull
//    private String text ;
//    @ManyToOne
//    @JoinColumn
//
//    @Column(nullable = true)
//    private User user ;
//    @ManyToOne
//    @JoinColumn
//    private Place_Post place_post ;
//
//    private Date date ;
//}
