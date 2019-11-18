package edu.dat18c.coursesystem.api.v1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import edu.dat18c.coursesystem.models.Course;
import edu.dat18c.coursesystem.services.CourseService;

/**
 * A rest controller for the course entity.
 */
@RestController
public class CourseRestController 
{
    /**The base api url for the course entity. localhost:8080/api/v1/course */
    private final String BASE_URL = "/api/v1/course";

    @Autowired
    private CourseService courseService;

    /**
     * GET mapping for all courses.
     * @return All the courses.
     */
    @GetMapping(value = BASE_URL)
    public Iterable<Course> getAllCourses() 
    {
        return courseService.findAllUsers();
    }

    /**
     * GET mapping for a specific course, specified by a course code. <p>
     * Example: <p> localhost:8080/api/v1/course/WD-2020-F-NODEJS
     * @param id The unique course code
     * @return The specified course, if it exist.
     */
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