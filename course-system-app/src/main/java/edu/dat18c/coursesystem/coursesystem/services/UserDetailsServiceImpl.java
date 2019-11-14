package edu.dat18c.coursesystem.coursesystem.services;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.dat18c.coursesystem.coursesystem.models.User;
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

        UserDetails userDetails = new UserDetails()
        {
            @Override
            public boolean isEnabled() 
            {
                return true;
            }
        
            @Override
            public boolean isCredentialsNonExpired() 
            {
                return true;
            }
        
            @Override
            public boolean isAccountNonLocked() 
            {
                return true;
            }
        
            @Override
            public boolean isAccountNonExpired() 
            {
                return true;
            }
        
            @Override
            public String getUsername() 
            {
                return optionalUser.get().getEmail();
            }
        
            @Override
            public String getPassword() 
            {
                return optionalUser.get().getPassword();
            }
        
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() 
            {
                int role_id = (int)optionalUser.get().getRole().getId();

                switch (role_id) 
                {
                    case 1:
                        return Collections.singleton(new SimpleGrantedAuthority("ROLE_STUDENT"));
                    case 2:
                        return Collections.singleton(new SimpleGrantedAuthority("ROLE_TEACHER"));
                    case 3:
                        return Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    default:
                        return null;
                }
            }
        };
        
        return userDetails;
    }
}