package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

/**
 * Created by Ashraf Atef on 5/13/2016.
 */
@Configuration
@EnableResourceServer
public class Resource extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http

                 .authorizeRequests().antMatchers("/api0/**").permitAll()
              .and().authorizeRequests().antMatchers("/api/user/**").authenticated()
//                .and().authorizeRequests().antMatchers("/api/user/**").hasRole("USER")
                .and().authorizeRequests().antMatchers("/api/admin/**").hasRole("ADMIN")

                .and().headers().frameOptions().sameOrigin()
                .and().csrf().disable();
    }
}
