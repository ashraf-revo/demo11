package com.example.Service.Impl;

import com.example.Domain.User;
import com.example.Service.SecurityService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by Ashraf Atef on 5/13/2016.
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    @Override
//    public org.springframework.security.core.userdetails.User GetCurrentUser() throws Exception {
    public User GetCurrentUser() throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication() ;
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof User) {
//             return    (org.springframework.security.core.userdetails.User) authentication.getPrincipal()  ;
                return (User)authentication.getPrincipal()  ;
            } else {
                throw new Exception("not login user2") ;
            }
        } else throw new Exception("not login user1") ;
    }
}
