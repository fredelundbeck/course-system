package edu.dat18c.coursesystem.coursesystem.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.dat18c.coursesystem.coursesystem.models.User;
import edu.dat18c.coursesystem.coursesystem.services.UserService;

/**
 * TeacherRestController
 */
@RestController
public class TeacherRestController 
{
    /**The base api url for teachers. https://localhost:8080/api/v1/teacher */
    private final String BASE_URL = "/api/v1/teacher";

    @Autowired
    private UserService userService;
    
    @GetMapping(value = BASE_URL)
    public Iterable<User> getAllTeachers() 
    {
        return userService.findAllTeachers();
    }    
}