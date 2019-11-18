package edu.dat18c.coursesystem.coursesystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.dat18c.coursesystem.coursesystem.models.Role;
import edu.dat18c.coursesystem.coursesystem.models.User;
import edu.dat18c.coursesystem.coursesystem.models.enums.RoleType;
import edu.dat18c.coursesystem.coursesystem.repositories.UserRepository;

/**
 * SignUpController
 */
@Controller
public class SignUpController 
{
    @Autowired
    private UserRepository userRepository;

    @Autowired 
    private PasswordEncoder passwordEncoder;


    @GetMapping(value = "/signup")
    public String getSignUpView()
    {
        return "authentication/signup";
    }

    @PostMapping(value = "/signup")
    public String signUp(@ModelAttribute User user, @RequestParam(required = true, name = "roleValue") int roleValue)
    {
        //Set email to lowercase
        user.setEmail(user.getEmail().toLowerCase());

        if (!userRepository.existsByEmail(user.getEmail())) 
        {
            //Encode the raw text password with the bCrypt hashing algorithm
            String encodedPassword = passwordEncoder.encode(user.getPassword());

            //Set the roletype of the new user.
            RoleType roleType = RoleType.fromInt(roleValue);
            
            user.setPassword(encodedPassword);
            user.setRole(new Role(roleType));

            //Save to mysql
            userRepository.save(user);

            return "authentication/usercreated";   
        }
        else
        {
            return "redirect:/signup?failed";
        }
    }
}