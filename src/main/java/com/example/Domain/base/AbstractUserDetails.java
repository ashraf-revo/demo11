package com.example.Domain.base;

/**
 * Created by Ashraf Atef on 6/9/2016.
 */
import com.fasterxml.jackson.annotation.JsonProperty ;
import com.fasterxml.jackson.annotation.JsonView ;

import org.springframework.security.core.GrantedAuthority ;
import org.springframework.security.core.authority.AuthorityUtils ;
import org.springframework.security.core.userdetails.UserDetails ;

import java.util.Collection;
import java.util.List;

/**
 * Created by revo on 5/5/16.
 */
public abstract class AbstractUserDetails implements UserDetails {
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return AuthorityUtils.createAuthorityList() ;
    }
}
