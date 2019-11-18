package edu.dat18c.coursesystem.coursesystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.dat18c.coursesystem.coursesystem.models.User;
import edu.dat18c.coursesystem.coursesystem.repositories.UserRepository;

/**
 * UserService
 */
@Service
public class UserService 
{
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> findAllUsers()
    {
        return userRepository.findAll();
    }

    public boolean emailAlreadyExists(User user)
    {
        return userRepository.existsByEmail(user.getEmail());
    }

    public Optional<User> findById(long id)
    {
        return userRepository.findById(id);
    }
}