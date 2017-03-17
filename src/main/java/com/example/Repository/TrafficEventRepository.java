package com.example.Repository;

import com.example.Domain.Place;
import com.example.Domain.Traffic_Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Ashraf Atef on 7/12/2016.
 */
@RepositoryRestResource
public interface TrafficEventRepository extends CrudRepository<Traffic_Event, Long> {

    @Override
    List<Traffic_Event> findAll() ;

    @Query("select P from Place P where P.place_id = ?1  ")
    Place search_Place_id(Long Place_id) ;

    //http://stackoverflow.com/questions/34303585/writing-custom-queries-in-spring-boot
    @Query("select P from Traffic_Event P where P.id not IN (?1)  order by sqrt(pow(P.latitude-?2,2)+pow(P.longitude-?3,2))   ")
    List<Place> get_near_to_location(List<Long> ids , double place_latitude , double place_longitude , Pageable pageable) ;

    @Query("select P from Traffic_Event P where P.id not IN (?1)  order by sqrt(pow(P.latitude-?2,2)+pow(P.longitude-?3,2))   ")
    List<Place> between_path( double place_latitude , double place_longitude , Pageable pageable) ;
}
