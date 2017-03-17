package com.example.Model;

/**
 * Created by Ashraf Atef on 6/27/2016.
 */
public class Search_Object_Responce {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Search_Object_Responce(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private Long id ;
    private String name ;
}
