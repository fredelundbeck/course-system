package edu.dat18c.coursesystem.coursesystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController
 */
@Controller
public class HomeController 
{
    @GetMapping(value = "/")
    public String getHomeIndex()
    {
        return "home/index";
    }
}