/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Domain;

import com.example.Domain.base.AbstractUserDetails;
import com.example.Service.Phone;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * @author Ashraf Atef
 */
//@Entity
//public class User {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//    private String email;
//    private String password;
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
//    private List<Phones> phones;
//
//    public User() {
//    }
//
//    public User(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//}
@Entity
public class User extends AbstractUserDetails {

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone( String phone) {
        this.phone = phone;
    }

//
//    public String getTooken() {
//        return tooken;
//    }
//
//    public void setTooken( String tooken) {
//        this.tooken = tooken;
//    }


    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl( String photourl) {
        this.photourl = photourl;
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

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Id
    @GeneratedValue
    private Long userid;

    @Length(min = 3, max = 100, message = "Username_Error_Messsage")
    @Column(length = 100, nullable = false, unique = true)
    @NotBlank(message = "should not be empty")
    @NotNull
    private String username;


    @Length(min = 6, max = 100, message = "Password_Error_Messsage_Length")
    @Column(length = 100, nullable = false)
    @NotBlank(message = "should not be empty")
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "should not be empty")
    @Email(message = "Email_Error_Messsage")
    @NotNull
    private String email;

    @Column(unique = true, nullable = true)
    @Phone(message = "Phone_Error_Messsage")

    private String phone;

//
//    @Column( length = 255 , nullable = true  )
//    private String tooken;


    @Column(nullable = true)
    private String photourl;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(length = 10, nullable = true)
    private String verificationCode;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    int type;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (type == 1) {
            return AuthorityUtils.createAuthorityList("ROLE_ADMIN");
        } else return AuthorityUtils.createAuthorityList();

    }

    public User(String username, String password, String email, String phone, String photourl, double latitude, double longitude, String verificationCode) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        // this.tooken = tooken;
        this.photourl = photourl;
        this.latitude = latitude;
        this.longitude = longitude;
        this.verificationCode = verificationCode;
    }

    public User() {

    }

}
