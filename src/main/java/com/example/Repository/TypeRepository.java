package com.example.Repository;


import com.example.Domain.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Ashraf Atef on 6/14/2016.
 */
@RepositoryRestResource
public interface TypeRepository extends CrudRepository<Type, Long> {
    @Override
    List<Type> findAll();
}
