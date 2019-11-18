package edu.dat18c.coursesystem.coursesystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.dat18c.coursesystem.coursesystem.models.User;
import edu.dat18c.coursesystem.coursesystem.models.UserDetailsImpl;
import edu.dat18c.coursesystem.coursesystem.repositories.UserRepository;

/**
 * UserDetailsService
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService 
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
    {
        Optional<User> optionalUser = userRepository.findByEmail(email); 
        
        if (!optionalUser.isPresent()) 
        {
            throw new UsernameNotFoundException(email + " not found!");
        }
        return new UserDetailsImpl(optionalUser.get());
    }
}