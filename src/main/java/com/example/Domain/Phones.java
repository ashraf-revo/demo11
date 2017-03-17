///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.example.Domain;
//
//import java.io.Serializable;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
///**
// *
// * @author Ashraf Atef
// */
//@Entity
//public class Phones implements Serializable {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//    private String phone;
//    @ManyToOne
//    @JoinColumn
//    private User user;
//
//    public Phones() {
//    }
//
//    public Phones(String phone, User user) {
//        this.phone = phone;
//        this.user = user;
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
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//}
