package com.um5.iwam.g12.chatappserver.services;

import com.um5.iwam.g12.chatappserver.model.SecurityUser;
import com.um5.iwam.g12.chatappserver.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUsersDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JpaUsersDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).stream().map(SecurityUser::new).findFirst().orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }
}
