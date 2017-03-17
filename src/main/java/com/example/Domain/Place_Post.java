package com.example.Domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Ashraf Atef on 7/1/2016.
 */
@Entity
public class Place_Post {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public Long getLike_num() {
        return like_num;
    }

    public void setLike_num(Long like_num) {
        this.like_num = like_num;
    }


    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url( String website_url) {
        this.website_url = website_url;
    }


    public String getFace_book_url() {
        return face_book_url;
    }

    public void setFace_book_url( String face_book_url) {
        this.face_book_url = face_book_url;
    }


    public String getTwitter_url() {
        return twitter_url;
    }

    public void setTwitter_url( String twitter_url) {
        this.twitter_url = twitter_url;
    }


    public String getGoogle_plus_url() {
        return google_plus_url;
    }

    public void setGoogle_plus_url( String google_plus_url) {
        this.google_plus_url = google_plus_url;
    }


    public String getInstgram_url() {
        return instgram_url;
    }

    public void setInstgram_url( String instgram_url) {
        this.instgram_url = instgram_url;
    }

    public Place getPlace_owner() {
        return place_owner;
    }

    public void setPlace_owner(Place place_owner) {
        this.place_owner = place_owner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Id
    @GeneratedValue
    private  Long id ;
    @Length(min = 3, max = 100, message = "Post Name Error Messsage")
    @Column(length = 100 ,nullable = false )
    @NotBlank(message = "should not be empty")
    @NotNull
    private String post_title ;

    @Length(min = 10, max = 1000, message = "Place Description Error Messsage")
    @Column(length = 1000 ,nullable = false )
    @NotBlank(message = "should not be empty")
    @NotNull
    private String description ;

    private String photo_url ;
    @Column( nullable = false)
    @NotNull
    private Long like_num ;
    @Column(length = 100 , nullable = true)

    @URL
    private String website_url ;
    @Column(length = 100 , nullable = true)

    @URL
    private String face_book_url ;
    @Column(length = 100 , nullable = true)

    @URL
    private String twitter_url ;
    @Column(length = 100 , nullable = true)

    @URL
    private String google_plus_url ;
    @Column(length = 100 , nullable = true)

    @URL
    private String instgram_url ;
    @ManyToOne
    @JoinColumn
    private Place place_owner ;

    private Date date ;
}
