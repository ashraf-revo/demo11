package com.example.Domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Ashraf Atef on 7/9/2016.
 */
@Entity
public class TypeGroup {
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

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    @Id
    @GeneratedValue
    private Long id ;
    @Length(min = 1, max = 100, message = "Group Type Name Error Messsage")
    @Column(length = 100 ,nullable = false )
    @NotBlank(message = "should not be empty")
    @NotNull
    private String name ;
    @ManyToMany
    @JoinColumn
    private List<Type> types;
}
