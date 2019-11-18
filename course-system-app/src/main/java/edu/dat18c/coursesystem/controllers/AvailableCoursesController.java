package edu.dat18c.coursesystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.dat18c.coursesystem.models.Course;

/**
 * AvailableCoursesController
 */
@Controller
public class AvailableCoursesController
{
    @GetMapping(value = "/courses")
    public String getAvailableCoursesView() 
    {
        return "student/availablecourses"; 
    }

    @PostMapping(value = "/courses")
    public String postNewCourse(@ModelAttribute Course course)
    {
        return "redirect:/courses";
    }
}