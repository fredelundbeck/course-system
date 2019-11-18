package edu.dat18c.coursesystem.coursesystem.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.dat18c.coursesystem.coursesystem.models.User;
import edu.dat18c.coursesystem.coursesystem.services.UserService;


/**
 * StudentRestController
 */
@RestController
public class StudentRestController 
{
    /**The base api url for students https://localhost:8080/api/v1/student */
    private final String BASE_URL = "/api/v1/student";

    @Autowired
    private UserService userService;
    
    @GetMapping(value = BASE_URL)
    public Iterable<User> getAllStudents() 
    {
        return userService.findAllStudents();
    }
}