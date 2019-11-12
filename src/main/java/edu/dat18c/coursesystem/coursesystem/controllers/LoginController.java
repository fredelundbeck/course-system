package edu.dat18c.coursesystem.coursesystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * LoginController
 */
@Controller
public class LoginController 
{

    @GetMapping(value = "/login")
    public String getLoginPage() 
    {
        return "login/index";
    }
    
}