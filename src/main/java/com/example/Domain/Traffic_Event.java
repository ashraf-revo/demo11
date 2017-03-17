package com.example.Domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Ashraf Atef on 7/1/2016.
 */
@Entity
public class Traffic_Event {
    @Id
    @GeneratedValue
    private Long id ;
    @Length(min = 3, max = 100, message = "Place Name Error Messsage")
    @Column(length = 100 ,nullable = false )
    @NotBlank(message = "should not be empty")
    @NotNull
    private String title ;
    @OneToOne
    @JoinColumn
    private Traffic_Type type ;
    @Length(min = 10, max = 100, message = "Place Description Error Messsage")
    @Column(length = 100 ,nullable = false )
    @NotBlank(message = "should not be empty")
    @NotNull
    private String description ;

    @Column(nullable = true)
    private String photo_url ;
    @Length(min = 10, max = 100, message = "Place Address Error Messsage")
    @Column(length = 100 ,nullable = false )
    @NotBlank(message = "should not be empty")
    @NotNull
    private String address ;
    @Column( nullable = false)
    private double longitude ;
    @Column( nullable = false)
    private double latitude ;
    @Length( max = 100, message = "Place Known Name Error Messsage")
    @Column(length = 100 ,nullable = true )

    private String knownname ;
    @Length( max = 100, message = "Place Gps Address Error Messsage")
    @Column(length = 100 ,nullable = false )
    @NotNull
    private String gps_address ;
    @Length( max = 100, message = "Place City Error Messsage")
    @Column(length = 100 ,nullable = true )

    private String city ;
    @Length( max = 100, message = "Place State Error Messsage")
    @Column(length = 100 ,nullable = true )

    String state ;
    @Length( max = 100, message = "Place Country Error Messsage")
    @Column(length = 100 ,nullable = false )
    @NotNull
    private String country ;
    @Length( max = 100, message = "Postal Code Error Messsage")
    @Column(length = 100 ,nullable = true )

    private String postalcode ;
    @ManyToOne
    @JoinColumn
    private User user_owner;
    private Date date;

    public int getPerment_opetion() {
        return perment_opetion;
    }

    public void setPerment_opetion(int perment_opetion) {
        this.perment_opetion = perment_opetion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser_owner() {
        return user_owner;
    }

    public void setUser_owner(User user_owner) {
        this.user_owner = user_owner;
    }


    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode( String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getState() {
        return state;
    }

    public void setState( String state) {
        this.state = state;
    }


    public String getCity() {
        return city;
    }

    public void setCity( String city) {
        this.city = city;
    }

    public String getGps_address() {
        return gps_address;
    }

    public void setGps_address(String gps_address) {
        this.gps_address = gps_address;
    }


    public String getKnownname() {
        return knownname;
    }

    public void setKnownname( String knownname) {
        this.knownname = knownname;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url( String photo_url) {
        this.photo_url = photo_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Traffic_Type getType() {
        return type;
    }

    public void setType(Traffic_Type type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(length = 1 ,nullable = false)
    private int perment_opetion ;


}
