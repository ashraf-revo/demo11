package com.example.Repository;

import com.example.Domain.Liked_Place;
import com.example.Domain.Place;
import com.example.Domain.Place_Post;
import com.example.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Ashraf Atef on 7/7/2016.
 */
@RepositoryRestResource
public interface Liked_Place_Repository extends CrudRepository<Liked_Place, Long> {
    List<Liked_Place> findByUser(User user) ;
    List<Liked_Place> findByPlaceAndUser(  Place place , User user) ;

}
