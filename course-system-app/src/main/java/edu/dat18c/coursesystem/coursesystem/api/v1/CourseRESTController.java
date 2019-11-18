package edu.dat18c.coursesystem.coursesystem.api.v1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import edu.dat18c.coursesystem.coursesystem.models.Course;
import edu.dat18c.coursesystem.coursesystem.services.CourseService;


/**
 * CourseController
 */
@RestController
public class CourseRESTController 
{
    private final String BASE_URL = "/api/v1/course";

    @Autowired
    private CourseService courseService;

    @GetMapping(value = BASE_URL)
    public Iterable<Course> getAllCourses() 
    {
        return courseService.findAllUsers();
    }

    @GetMapping(value = BASE_URL + "/{id}")
    public Course getCourseById(@ModelAttribute(name = "id") String id) 
    {
        Optional<Course> optionalCourse = courseService.findByCourseCode(id);

        if (optionalCourse.isPresent()) 
        {
            return optionalCourse.get();
        }
        return null;
    }
    
    
    
}