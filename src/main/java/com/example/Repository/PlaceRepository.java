package com.example.Repository;

import com.example.Domain.Place;

import com.example.Domain.Type;
import com.example.Domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

/**
 * Created by Ashraf Atef on 6/14/2016.
 */
@RepositoryRestResource
public interface PlaceRepository extends CrudRepository<Place, Long> {


    @Override
    List<Place> findAll();



    @Query("select P from Place P where P.place_id = ?1  ")
    Place search_Place_id(Long Place_id) ;

//http://stackoverflow.com/questions/34303585/writing-custom-queries-in-spring-boot
    @Query("select P from Place P where P.place_id not IN (?1)  order by sqrt(pow(P.place_latitude-?2,2)+pow(P.place_longitude-?3,2))   ")
     List<Place> get_near_to_location(List<Long> ids , double place_latitude , double place_longitude , Pageable pageable) ;

    @Query("select count(P) from Place P  order by sqrt(pow(P.place_latitude-?,2)+pow(P.place_longitude-?,2)) ")
     int get_between(int counter , int limit) ;

    @Query("select P from Place P where P.place_name like ?1  ")
    List<Place> search_Place_name(String Place_name) ;

    @Query("select P from Place P where P.place_owner = ?1  ")
    List<Place> searchByPlaceOwner(User user) ;

    @Query("select P from Place P where P.place_id=?1")
    List<Place> findByPlace_id_ (Long Place_id);

    @Query("select P from Place P where P.place_id not IN (?1) and  P.place_type IN (?2) order by sqrt(pow(P.place_latitude-?3,2)+pow(P.place_longitude-?4,2))   ")
    List<Place> get_near_to_location_realted_types(List<Long> ids , List<Type>types, double place_latitude , double place_longitude  ,Pageable pageable ) ;

}
