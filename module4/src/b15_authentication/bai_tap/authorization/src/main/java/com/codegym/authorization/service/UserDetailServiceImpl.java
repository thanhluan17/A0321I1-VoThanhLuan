package com.codegym.authorization.service;

import com.codegym.authorization.model.User;
import com.codegym.authorization.repository.UserRepository;
import com.codegym.authorization.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null){
            throw new UsernameNotFoundException("User " + username + " was not found!");
        }

        List<String> roles = userRoleRepository.findAllRoleByUser(user.getUserId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (roles != null){
            for(String roleName: roles){
                GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
                grantedAuthorities.add(authority);
            }
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
        return userDetails;
    }
}
