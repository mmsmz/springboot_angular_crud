package com.userservice.userservice;

import com.userservice.userservice.entity.UserEntity;
import com.userservice.userservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity adminUser = userRepository.findByEmail(username);
        if(adminUser==null)
           throw new UsernameNotFoundException("User not Found 404");

        return new UserPrincipal(adminUser);
    }


}
