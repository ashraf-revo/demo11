package com.example.Domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by Ashraf Atef on 6/14/2016.
 */
@Entity
public class Type {
    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    @Id
    @GeneratedValue
    Long type_id ;
    @Length(min = 1, max = 100, message = "Type Name Error Messsage")
    @Column(length = 100 ,nullable = false )
    @NotBlank(message = "should not be empty")
    @NotNull
    String type_name ;


    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url( String photo_url) {
        this.photo_url = photo_url;
    }

    @Column(length = 100 , nullable = true)

    @URL
    private String photo_url ;

}
