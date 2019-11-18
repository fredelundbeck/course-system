package edu.dat18c.coursesystem.coursesystem.api.v1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import edu.dat18c.coursesystem.coursesystem.models.User;
import edu.dat18c.coursesystem.coursesystem.services.UserService;

/**
 * A rest controller for the user entity. 
 */
@RestController
public class UserRestController 
{
    /**The base api url for the course entity. https://localhost:8080/api/v1/user */
    private final String BASE_URL = "/api/v1/user";
    
    @Autowired
    private UserService userService;

    @GetMapping(value = BASE_URL)
    public Iterable<User> getAllUsers() 
    {
        return userService.findAllUsers();
    }

    /**
     * GET mapping for a specific user, specified by a user id. <p>
     * Example: <p> localhost:8080/api/v1/user/1
     * @param id The unique user id.
     * @return The specified user, if the user exist.
     */
    @GetMapping(value = BASE_URL + "/{id}")
    public User getUserById(@ModelAttribute(name = "id") long id)
    {
        Optional<User> optionalUser = userService.findById(id);

        if (optionalUser.isPresent()) 
        {
            return optionalUser.get();    
        }
        return null;
    }
}