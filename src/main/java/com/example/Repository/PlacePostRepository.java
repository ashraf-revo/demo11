package com.example.Repository;



import com.example.Domain.Place;
import com.example.Domain.Place_Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Ashraf Atef on 7/5/2016.
 */
@RepositoryRestResource
public interface PlacePostRepository extends CrudRepository<Place_Post, Long> {
   @Override
    List<Place_Post>findAll();
    @Query("select PP from Place_Post PP where PP.id not IN (?1) and PP.place_owner.place_id= ?2 order by PP.date desc ")
    List<Place_Post> get_posts(List<Long> ids , Long place_id , Pageable pageable) ;
}
