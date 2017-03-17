package com.example.Service.Impl;

import com.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Ashraf Atef on 5/13/2016.
 */
@Service
public class UserDetilesServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.example.Domain.User u = userRepository.findOneByUsername(s);
        if (u == null) throw new UsernameNotFoundException("not found");
//     return new User(s, u.getPassword(), AuthorityUtils.createAuthorityList("ROLES_USER"));
      //  System.out.println(u.getEmail());
       return u ;
    }


}
