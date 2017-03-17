/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Repository;

import com.example.Domain.User;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Ashraf Atef
 */
@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();

    User findByUsernameAndPassword(String USername, String Password);

    User findOneByEmail(String Email);

    User findOneByUsername(String username);

    User findOneByPhone(String Phone);

}

