package org.eshop.service.impl;

import org.eshop.entity.Signon;
import org.eshop.persistence.SignonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/20.
 */
@Service("userDetailService")
public class MyUserDetailService implements UserDetailsService{

    @Autowired
    private SignonDAO signonDAO;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Signon signon = signonDAO.getSignon(username);
        if (signon == null) {
            throw new UsernameNotFoundException("signon not found");
        } else {
            return new User(signon.getUserId(), signon.getPassword(), getAuthorities(signon));
        }
    }

    public List<GrantedAuthority> getAuthorities(Signon signon){
        List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
        GrantedAuthority authority=new SimpleGrantedAuthority(signon.getAuthorities());
        authorities.add(authority);
        return authorities;
    }
}
