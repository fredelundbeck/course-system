package edu.dat18c.coursesystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.dat18c.coursesystem.models.Course;
import edu.dat18c.coursesystem.repositories.CourseRepository;

/**
 * CourseController
 */
@Controller
public class CourseController 
{
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(value="/admin/courses/create")
    public String getCreateCourseView() 
    {
        return "admin/course/course_create";
    }
    
    @PostMapping(value="/admin/courses/create")
    public String saveCourse(@ModelAttribute Course course) 
    {
        courseRepository.save(course);
        return "redirect:/admin/courses";
    }
    
    @GetMapping(value="/admin/courses")
    public String getAllCoursesView(Model model) 
    {
        model.addAttribute("courses", courseRepository.findAll());
        return "admin/course/courses";
    }

    @GetMapping(value="/admin/courses/edit/{id}")
    public String getEditCourseView(@PathVariable String id, Model model) 
    {
        model.addAttribute("course", courseRepository.findById(id));
        return "admin/course/course_edit";
    }

    @GetMapping(value="/admin/courses/delete/{id}")
    public String deleteCourse(@PathVariable String id) 
    {
        courseRepository.deleteById(id);
        return "redirect:/admin/courses";
    }
}