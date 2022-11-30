package com.example.pizzeramorebackend.services;


import com.example.pizzeramorebackend.exceptions.UserNotFoundException;
import com.example.pizzeramorebackend.models.User;
import com.example.pizzeramorebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    public User saveUser(User user) {
        log.info("Saving user " + user.getName());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User getExact(User user) {
        return userRepository.findExact(user.getName(), user.getLastName(), user.getStreet(), user.getCity(), user.getEmail()).orElseThrow(UserNotFoundException::new);
    }

    public User getUserByEmail(String name) {
        return userRepository.findByEmail(name).orElseThrow(UserNotFoundException::new);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(UserNotFoundException::new);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.name()));
        });
        log.info("AUTHORITIES " + authorities);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
