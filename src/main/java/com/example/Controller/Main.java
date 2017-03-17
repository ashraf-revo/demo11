/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Controller;


import com.example.Domain.*;
import com.example.Model.Check_Like_Visted_Responce;
import com.example.Model.Search_Object_Responce;
import com.example.Repository.*;
import com.example.Service.CloudinaryService;
import com.example.Service.MailService;
import com.example.Service.Methods;
import com.example.Service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ashraf Atef
 */
@RestController
public class Main {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    TypeRepository typeRepository;
    @Autowired
    PlacePostRepository placePostRepository;
    @Autowired
    Liked_Place_Repository liked_place_repository;
    @Autowired
    Visted_Place_Repository visted_place_repository;
    @Autowired
    TypeGroupRepository typeGroupRepository;
    @Autowired
    TrafficEventRepository trafficEventRepository;

    @Autowired
    CloudinaryService cloudinary;

    @Autowired
    Methods methods;

    @Autowired
    MailService mailService;

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    SecurityService securityservice;

    @RequestMapping(value = "/api/user/aaa", method = RequestMethod.GET)
    List<User> getAll() {

        System.out.println(userRepository.findAll().size());
        return userRepository.findAll();
    }

    @RequestMapping(value = "/api0/Registeration", method = RequestMethod.POST)
    public User save(@Valid @RequestBody User user, BindingResult result) throws Exception {

        System.out.println(user.getPhone());
        boolean flag_con = true;

        //check for errors
        if (result.hasErrors()) {
            System.out.println(result.getFieldErrors());
            flag_con = false;
        }

        //check Email Redanadncy
        if (userRepository.findOneByEmail(user.getEmail()) != null) {
            user.setEmail("false");
            flag_con = false;
        }

        //check username redanancy
        if (userRepository.findOneByUsername(user.getUsername()) != null) {
            user.setUsername("false");
            flag_con = false;
        }

        //check Phone redanancy
        if (user.getPhone() != null && user.getPhone().length() > 0) {
            if (userRepository.findOneByPhone(user.getPhone()) != null) {
                user.setPhone("false");
                flag_con = false;
            }
        }

        if (flag_con == false) {
            return user;
        }


//        //set tooken to user
//        user.setTooken(methods.MakeTooken(150));


        // encode password
        user.setPassword(encoder.encode(user.getPassword()));

        // set photo usrl to user
        if (user.getPhotourl() != null)
            user.setPhotourl(cloudinary.upload(user.getPhotourl()));

        return userRepository.save(user);

    }

    //    @RequestMapping(value = "/Login", method = RequestMethod.POST)
//    public User Login(@RequestBody User user) {
//       User RealUser=userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//           if (RealUser!=null)
//            {
//           //  RealUser.setTooken(new MethodsImpl().MakeTooken(150));
//             userRepository.save(RealUser);
//             return RealUser;
//            }
//        return user;
//    }
    @RequestMapping(value = "/api0/getverificationcode", method = RequestMethod.POST)
    public User getverificationcode(@RequestBody User user) {
        User RealUser = userRepository.findOneByEmail(user.getEmail());
        if (RealUser != null) {


            RealUser.setVerificationCode(methods.MakeTooken(35));
            userRepository.save(RealUser);
            mailService.SendVerification(RealUser);
            return RealUser;
        }
        return user;
    }

    @RequestMapping(value = "/api0/changepassword", method = RequestMethod.POST)
    public User changepassword(@RequestBody User user) {
//        user.setTooken(methods.MakeTooken(150));
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @RequestMapping(value = "/api/user/getuser", method = RequestMethod.GET)
    public User getuser() {

        User user = null;
        try {

            user = securityservice.GetCurrentUser();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @RequestMapping(value = "/api/user/gettypies", method = RequestMethod.GET)
    public List<Type> gettypies() {
        return typeRepository.findAll();
    }

    @RequestMapping(value = "/api/user/addplace", method = RequestMethod.POST)
    public Place addplace(@Valid @RequestBody Place place, BindingResult result) throws Exception {
        System.out.println(place.getPlace_address());

        //check for errors
        if (result.hasErrors()) {
            System.out.println(result.getFieldErrors());
            return place;
        }


        place.setPlace_owner(securityservice.GetCurrentUser());
        place.setPlace_date(new Date());

        place.setLike_num(0L);
        place.setVisted_times_num(0L);
        if (place.getPlace_photourl() != null)
            place.setPlace_photourl(cloudinary.upload(place.getPlace_photourl()));
        return placeRepository.save(place);

    }

    @RequestMapping(value = "/api/user/get_nearly_places", method = RequestMethod.GET)
    public List<Place> get_nearly_places(
            @RequestParam(value = "latitude") double latitude,
            @RequestParam(value = "longitude") double longitude,
            @RequestParam(value = "limit") int limit,
            @RequestParam(value = "ids") List<Long> ids
    ) {

        return placeRepository.get_near_to_location(ids, latitude, longitude, new PageRequest(0, limit));
    }

    @RequestMapping(value = "/api/user/object_search/{query}", method = RequestMethod.GET)
    public List<Search_Object_Responce> object_search(
            @PathVariable("query") String query
    ) {
        System.out.println(query);
        List<Place> places = placeRepository.search_Place_name("%" + query + "%");
        List<Search_Object_Responce> search_object_responces = new ArrayList<>();
        for (Place place : places)
            search_object_responces.add(new Search_Object_Responce(place.getPlace_id(), place.getPlace_name()));
        System.out.println(search_object_responces.size());
        return search_object_responces;
    }

    @RequestMapping(value = "/api/user/getplace/{id}", method = RequestMethod.GET)
    public Place find_place_by_id(
            @PathVariable("id") Long id
    ) {

        return placeRepository.search_Place_id(id);
    }

    @RequestMapping(value = "/api/user/addpost", method = RequestMethod.POST)
    public Place_Post addpost(@Valid @RequestBody Place_Post post, BindingResult result) throws Exception {
        System.out.println(post.getPost_title());


        //check for errors
        if (result.hasErrors()) {
            System.out.println(result.getFieldErrors());
            return post;
        }

        boolean flag = false;
        List<Place> places_list = placeRepository.searchByPlaceOwner(securityservice.GetCurrentUser());
        for (Place place : places_list) {
            if (place.getPlace_id() == post.getPlace_owner().getPlace_id()) {
                flag = true;
            }
        }
        System.out.println(flag);
        if (flag == false) return post;


        if (post.getPhoto_url() != null)
            post.setPhoto_url(cloudinary.upload(post.getPhoto_url()));

        post.setDate(new Date());


        return placePostRepository.save(post);
    }

    @RequestMapping(value = "/api/user/get_posts", method = RequestMethod.GET)
    public List<Place_Post> get_posts(
            @RequestParam(value = "place_id") Long place_id,
            @RequestParam(value = "limit") int limit,
            @RequestParam(value = "ids") List<Long> ids
    ) {
        System.out.println(ids);
        return placePostRepository.get_posts(ids, place_id, new PageRequest(0, limit));
    }

    @RequestMapping(value = "/api/user/check_visted_likes", method = RequestMethod.POST)
    public Check_Like_Visted_Responce check_visted_liked(@RequestBody Place place) throws Exception {
        Check_Like_Visted_Responce check_like_visted_responce = new Check_Like_Visted_Responce();

        if (liked_place_repository.findByPlaceAndUser(place, securityservice.GetCurrentUser()).size() > 0)
            check_like_visted_responce.setLiked_flag(true);
        if (visted_place_repository.findByPlaceAndUser(place, securityservice.GetCurrentUser()).size() > 0)
            check_like_visted_responce.setVisited_flag(true);

        System.out.println(check_like_visted_responce.isLiked_flag() + " " + check_like_visted_responce.isVisited_flag());
        return check_like_visted_responce;
    }

    @RequestMapping(value = "/api/user/like_dislike_place", method = RequestMethod.POST)
    public String Like_dislike_place(@RequestBody Place place) throws Exception {

        System.out.println(place.getLike_num());
        String responce = "";

        if (placeRepository.findByPlace_id_(place.getPlace_id()).size() > 0) {
            place = placeRepository.findByPlace_id_(place.getPlace_id()).get(0);
            User user = securityservice.GetCurrentUser();
            List<Liked_Place> liked_places = liked_place_repository.findByPlaceAndUser(place, user);
            if (liked_places.size() > 0) {
                liked_place_repository.delete(liked_places.get(0));
                place.setLike_num(place.getLike_num() - 1);
                placeRepository.save(place);

            } else {
                Liked_Place liked_place = new Liked_Place();
                liked_place.setPlace(place);
                liked_place.setUser(user);
                liked_place.setDate(new Date());
                liked_place_repository.save(liked_place);
                place.setLike_num(place.getLike_num() + 1);
                placeRepository.save(place);

            }
            responce = "1";
        } else {
            responce = "0";
        }
        return responce;
    }

    @RequestMapping(value = "/api/user/visted_invisited_place", method = RequestMethod.POST)
    public String visited_unvisited_place(@RequestBody Place place) throws Exception {
        System.out.println("visited");
        String responce = "";
        if (placeRepository.findByPlace_id_(place.getPlace_id()).size() > 0) {
            place = placeRepository.findByPlace_id_(place.getPlace_id()).get(0);
            User user = securityservice.GetCurrentUser();
            List<Visted_Place> visted_places = visted_place_repository.findByPlaceAndUser(place, user);
            if (visted_places.size() > 0) {
                visted_place_repository.delete(visted_places.get(0));
                place.setVisted_times_num(place.getVisted_times_num() - 1);
                placeRepository.save(place);

            } else {
                Visted_Place visted_place = new Visted_Place();
                visted_place.setPlace(place);
                visted_place.setUser(user);
                visted_place.setDate(new Date());
                visted_place_repository.save(visted_place);
                place.setVisted_times_num(place.getVisted_times_num() + 1);
                placeRepository.save(place);

            }
            responce = "1";
        } else {
            responce = "0";
        }
        return responce;

    }

    @RequestMapping(value = "/api/user/get_my_vistings", method = RequestMethod.GET)
    public List<Visted_Place> get_my_vistings(@RequestParam(value = "limit") int limit,
                                              @RequestParam(value = "ids") List<Long> ids) throws Exception {

//       return visted_place_repository.findByUser(securityservice.GetCurrentUser());
        return visted_place_repository.get_my_visiting(ids, securityservice.GetCurrentUser(), new PageRequest(0, limit));
    }

    @RequestMapping(value = "/api/user/get_related_places", method = RequestMethod.GET)
    public List<Place> get_related_places(
            @RequestParam(value = "type_id") Long type_id,
            @RequestParam(value = "latitude") double latitude,
            @RequestParam(value = "longitude") double longitude,
            @RequestParam(value = "limit") int limit,
            @RequestParam(value = "ids") List<Long> ids
    ) {
        Type type = new Type();
        type.setType_id(type_id);
        System.out.println("-----------------------");
        List<Type> types = typeGroupRepository.findAll().get(0).getTypes();
        System.out.println(types.size());
        System.out.println(ids);
        System.out.println("0," + limit);
        List<Place> placess = placeRepository.get_near_to_location_realted_types(ids, types, latitude, longitude, new PageRequest(0, limit));
        System.out.println(placess.size());
        return placess;
    }

    @RequestMapping(value = "/api/user/gettime", method = RequestMethod.GET)
    public Date gettime(

    ) {
        System.out.println(new Date());
        return new Date();
    }

    @RequestMapping(value = "/api/user/get_nearly_traffic_events", method = RequestMethod.GET)
    public List<Place> get_nearly_traffic_events(
            @RequestParam(value = "latitude") double latitude,
            @RequestParam(value = "longitude") double longitude,
            @RequestParam(value = "limit") int limit,
            @RequestParam(value = "ids") List<Long> ids
    ) {

        return trafficEventRepository.get_near_to_location(ids, latitude, longitude, new PageRequest(0, limit));
    }

    @RequestMapping(value = "/api/user/between_path", method = RequestMethod.GET)
    public List<Traffic_Event> between_path(
            @RequestParam(value = "latitudes") double[] latitudes,
            @RequestParam(value = "longitudes") double[] longitudes

    ) {
        List<Traffic_Event> retu = new ArrayList<>();
        List<Traffic_Event> traffic_events = trafficEventRepository.findAll();
        System.out.println(latitudes.length + " " + longitudes.length);
        for (Traffic_Event traffic_event : traffic_events) {
            for (int i = 0; i < latitudes.length; i++) {
                double dis = CalculationByDistance(traffic_event.getLatitude(), latitudes[i], traffic_event.getLongitude(), longitudes[i]);
                if (dis <= 100) {
                    retu.add(traffic_event);
                    System.out.println(dis + " " + traffic_event.getId());
                    break;
                }


            }
        }
        System.out.println(retu.size());
        return retu;
    }

    public double CalculationByDistance(double lat1, double lat2, double lon1, double lon2) {
        int Radius = 6371;// radius of earth in Km

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        System.out.println("km" + km);
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));


        return meter;
    }
}
