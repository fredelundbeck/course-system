package edu.dat18c.coursesystem.coursesystem.services;

import java.util.ArrayList;
import java.util.List;
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

    public Iterable<User> findAllStudents()
    {
        List<User> students = new ArrayList<User>();

        for (User user : userRepository.findAll()) 
        {
            if (user.getRole().getName().equals("student")) 
            {
                students.add(user);
            }    
        }
        return students;
    }

    public Iterable<User> findAllTeachers()
    {
        List<User> teachers = new ArrayList<>();

        for (User user : userRepository.findAll()) 
        {
            if (user.getRole().getName().equals("teacher")) 
            {
                teachers.add(user);
            }    
        }
        return teachers;
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