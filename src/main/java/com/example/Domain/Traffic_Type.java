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
 * Created by Ashraf Atef on 7/1/2016.
 */
@Entity
public class Traffic_Type {
    @Id
    @GeneratedValue
    private Long id ;
    @Length(min = 1, max = 100, message = "Type Name Error Messsage")
    @Column(length = 100 ,nullable = false )
    @NotBlank(message = "should not be empty")
    @NotNull
    private String type ;
    @Column(length = 100 , nullable = true)

    @URL
    private String photo_url ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url( String photo_url) {
        this.photo_url = photo_url;
    }
}
