package edu.dat18c.coursesystem.coursesystem.api.v1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import edu.dat18c.coursesystem.coursesystem.models.User;
import edu.dat18c.coursesystem.coursesystem.services.UserService;


/**
 * UserRESTController
 */
@RestController
public class UserRESTController 
{
    private final String BASE_URL = "/api/v1/user";
    
    @Autowired
    private UserService userService;

    @GetMapping(value = BASE_URL)
    public Iterable<User> getAllUsers() 
    {
        return userService.findAllUsers();
    }

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