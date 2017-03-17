package com.example.Domain;

import com.example.Service.Phone;
import com.example.config.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Ashraf Atef on 6/14/2016.
 */
@Entity
public class Place {

    @Id
    @GeneratedValue
    private Long place_id ;
    @Length(min = 3, max = 100, message = "Place Name Error Messsage")
    @Column(length = 100 ,nullable = false )
    @NotBlank(message = "should not be empty")
    @NotNull
    private String place_name ;
    @OneToOne
    @JoinColumn
    private Type place_type ;

    @Length(min = 10, max = 100, message = "Place Description Error Messsage")
    @Column(length = 100 ,nullable = false )
    @NotBlank(message = "should not be empty")
    @NotNull
    private String place_description ;

    @Column(nullable = true)
    private String place_photourl ;
    @Length(min = 10, max = 100, message = "Place Address Error Messsage")
    @Column(length = 100 ,nullable = false )
    @NotBlank(message = "should not be empty")
    @NotNull
    private String place_address ;
    @Column( nullable = false)
    private double place_longitude ;
    @Column( nullable = false)
    private double place_latitude ;


    public String getPlace_knownname() {
        return place_knownname;
    }

    public void setPlace_knownname( String place_knownname) {
        this.place_knownname = place_knownname;
    }

    public String getPlace_gps_address() {
        return place_gps_address;
    }

    public void setPlace_gps_address(String place_gps_address) {
        this.place_gps_address = place_gps_address;
    }


    public String getPlace_city() {
        return place_city;
    }

    public void setPlace_city( String place_city) {
        this.place_city = place_city;
    }


    public String getPlace_state() {
        return place_state;
    }

    public void setPlace_state( String place_state) {
        this.place_state = place_state;
    }

    public String getPlace_country() {
        return place_country;
    }

    public void setPlace_country(String place_country) {
        this.place_country = place_country;
    }


    public String getPlace_postalcode() {
        return place_postalcode;
    }

    public void setPlace_postalcode( String place_postalcode) {
        this.place_postalcode = place_postalcode;
    }

    @Length( max = 100, message = "Place Known Name Error Messsage")
    @Column(length = 100 ,nullable = true )

    private String place_knownname ;
    @Length( max = 100, message = "Place Gps Address Error Messsage")
    @Column(length = 100 ,nullable = false )
    @NotNull
    private String place_gps_address ;
    @Length( max = 100, message = "Place City Error Messsage")
    @Column(length = 100 ,nullable = true )

    private String place_city ;
    @Length( max = 100, message = "Place State Error Messsage")
    @Column(length = 100 ,nullable = true )

    String place_state ;
    @Length( max = 100, message = "Place Country Error Messsage")
    @Column(length = 100 ,nullable = false )
    @NotNull
    private String place_country ;
    @Length( max = 100, message = "Postal Code Error Messsage")
    @Column(length = 100 ,nullable = true )

    private String place_postalcode ;


    public Date getPlace_date() {
        return place_date;
    }

    public void setPlace_date(Date place_date) {
        this.place_date = place_date;
    }

    public User getPlace_owner() {
        return place_owner;
    }

    public void setPlace_owner(User place_owner) {
        this.place_owner = place_owner;
    }


    public String getPlace_google_plus() {
        return place_google_plus;
    }

    public void setPlace_google_plus( String place_google_plus) {
        this.place_google_plus = place_google_plus;
    }


    public String getPlace_instgram_page() {
        return place_instgram_page;
    }

    public void setPlace_instgram_page( String place_instgram_page) {
        this.place_instgram_page = place_instgram_page;
    }


    public String getPlace_twiter_page() {
        return place_twiter_page;
    }

    public void setPlace_twiter_page( String place_twiter_page) {
        this.place_twiter_page = place_twiter_page;
    }


    public String getPlace_facebook_page() {
        return place_facebook_page;
    }

    public void setPlace_facebook_page( String place_facebook_page) {
        this.place_facebook_page = place_facebook_page;
    }


    public String getPlace_website() {
        return place_website;
    }

    public void setPlace_website( String place_website) {
        this.place_website = place_website;
    }


    public String getPlace_phone() {
        return place_phone;
    }

    public void setPlace_phone( String place_phone) {
        this.place_phone = place_phone;
    }

    public double getPlace_latitude() {
        return place_latitude;
    }

    public void setPlace_latitude(double place_latitude) {
        this.place_latitude = place_latitude;
    }

    public double getPlace_longitude() {
        return place_longitude;
    }

    public void setPlace_longitude(double place_longitude) {
        this.place_longitude = place_longitude;
    }

    public String getPlace_address() {
        return place_address;
    }

    public void setPlace_address(String place_address) {
        this.place_address = place_address;
    }


    public String getPlace_photourl() {
        return place_photourl;
    }

    public void setPlace_photourl( String place_photourl) {
        this.place_photourl = place_photourl;
    }

    public String getPlace_description() {
        return place_description;
    }

    public void setPlace_description(String place_description) {
        this.place_description = place_description;
    }

    public Type getPlace_type() {
        return place_type;
    }

    public void setPlace_type(Type place_type) {
        this.place_type = place_type;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public Long getPlace_id() {
        return place_id;
    }

    public void setPlace_id(Long place_id) {
        this.place_id = place_id;
    }

    @Column(length = 30 , nullable = true)
    @Phone(message = "Phone Error Messsage")

    private String place_phone ;
    @Column(length = 100 , nullable = true)

    @URL
    private String place_website ;
    @Column(length = 100 , nullable = true)

    @URL
    private String place_facebook_page ;
    @Column(length = 100 , nullable = true)

    @URL
    private String place_twiter_page ;
    @Column(length = 100 , nullable = true)

    @URL
    private String place_instgram_page ;
    @Column(length = 100 , nullable = true)

    @URL
    private String place_google_plus ;
    @ManyToOne
    @JoinColumn
    private User place_owner ;

    private Date place_date ;

    public Long getLike_num() {
        return like_num;
    }

    public void setLike_num(Long like_num) {
        this.like_num = like_num;
    }

    public Long getVisted_times_num() {
        return visted_times_num;
    }

    public void setVisted_times_num(Long visted_times_num) {
        this.visted_times_num = visted_times_num;
    }

    @Column( nullable = false)
    @NotNull
    private Long like_num ;
    @Column( nullable = false)
    @NotNull
    private Long visted_times_num ;




    public Place() {
    }
}
