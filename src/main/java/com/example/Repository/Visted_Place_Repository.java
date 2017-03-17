package com.example.Repository;



import com.example.Domain.Liked_Place;
import com.example.Domain.Place;
import com.example.Domain.User;
import com.example.Domain.Visted_Place;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Ashraf Atef on 7/7/2016.
 */

@RepositoryRestResource
public interface Visted_Place_Repository extends CrudRepository<Visted_Place, Long> {
    List<Visted_Place> findByUser(User user) ;
   List<Visted_Place>findByPlaceAndUser( Place place , User user ) ;
    @Query("select P from Visted_Place P where P.place.place_id not IN (?1) AND P.user =?2 order by P.date desc   ")
    List<Visted_Place> get_my_visiting(List<Long> ids , User user , Pageable pageable) ;
}