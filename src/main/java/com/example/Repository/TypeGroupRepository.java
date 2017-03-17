package com.example.Repository;

import com.example.Domain.Place;
import com.example.Domain.Type;
import com.example.Domain.TypeGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Ashraf Atef on 7/9/2016.
 */
@RepositoryRestResource
public interface TypeGroupRepository extends CrudRepository<TypeGroup, Long> {

    @Override
    List<TypeGroup> findAll();

    @Query("select G from TypeGroup G where ?1 IN G.types ")
    List<TypeGroup> search_type_in_group(Type type) ;
}
