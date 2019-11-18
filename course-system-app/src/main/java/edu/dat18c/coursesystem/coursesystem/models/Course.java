package edu.dat18c.coursesystem.coursesystem.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Course
 */
@Entity
@Table(name = "course")
public class Course 
{
    @Id
    @Column(name = "class_code")
    private String classCode;

    @Column(name = "name_danish")
    private String nameDanish;

    @Column(name = "name_english")
    private String nameEnglish;

    @Column(name = "semester")
    private int semester;

    @Column(name = "study_programme")
    private String studyProgramme;

    @Column(name = "mandatory")
    private boolean mandatory;

    @Column(name = "ects")
    private int ects;

    @Column(name = "language")
    private String language;

    @Column(name = "min_students")
    private int minimumStudents;

    @Column(name = "expected_students")
    private int expectedStudents;

    @Column(name = "max_students")
    private int maximumStudents;

    @Column(name = "prerequisites")
    private String prerequisites;

    @Column(name = "learning_outcome")
    private String learningOutcome;

    @Column(name = "content")
    private String content;

    @Column(name = "learning_activities")
    private String learningActivities;

    @Column(name = "exam_form")
    private String examForm;

    @ManyToMany
    @JoinTable(
        name = "course_teacher",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private Set<User> teachers;


    public Course() 
    {
        
    }

    public String getClassCode() 
    {
        return classCode;
    }

    public void setClassCode(String classCode) 
    {
        this.classCode = classCode;
    }

    public String getNameDanish() 
    {
        return nameDanish;
    }

    public void setNameDanish(String nameDanish) 
    {
        this.nameDanish = nameDanish;
    }

    public String getNameEnglish() 
    {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) 
    {
        this.nameEnglish = nameEnglish;
    }

    public int getSemester() 
    {
        return semester;
    }

    public void setSemester(int semester) 
    {
        this.semester = semester;
    }

    public String getStudyProgramme() 
    {
        return studyProgramme;
    }

    public void setStudyProgramme(String studyProgramme) 
    {
        this.studyProgramme = studyProgramme;
    }

    public boolean isMandatory() 
    {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) 
    {
        this.mandatory = mandatory;
    }

    public int getEcts() 
    {
        return ects;
    }

    public void setEcts(int ects) 
    {
        this.ects = ects;
    }

    public String getLanguage() 
    {
        return language;
    }

    public void setLanguage(String language) 
    {
        this.language = language;
    }

    public int getMinimumStudents() 
    {
        return minimumStudents;
    }

    public void setMinimumStudents(int minimumStudents) 
    {
        this.minimumStudents = minimumStudents;
    }

    public int getExpectedStudents() 
    {
        return expectedStudents;
    }

    public void setExpectedStudents(int expectedStudents) 
    {
        this.expectedStudents = expectedStudents;
    }

    public int getMaximumStudents() 
    {
        return maximumStudents;
    }

    public void setMaximumStudents(int maximumStudents) 
    {
        this.maximumStudents = maximumStudents;
    }

    public String getPrerequisites() 
    {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) 
    {
        this.prerequisites = prerequisites;
    }

    public String getLearningOutcome() 
    {
        return learningOutcome;
    }

    public void setLearningOutcome(String learningOutcome) 
    {
        this.learningOutcome = learningOutcome;
    }

    public String getContent() 
    {
        return content;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getLearningActivities() 
    {
        return learningActivities;
    }

    public void setLearningActivities(String learningActivities) 
    {
        this.learningActivities = learningActivities;
    }

    public String getExamForm() 
    {
        return examForm;
    }

    public void setExamForm(String examForm) 
    {
        this.examForm = examForm;
    }

    public Set<User> getTeachers() 
    {
        return teachers;
    }

    public void setTeachers(Set<User> teachers) 
    {
        this.teachers = teachers;
    }

    @Override
    public String toString() 
    {
        return String.format("[Course (ClassCode: %s)]", this.classCode);    
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (obj == this) 
        {
            return true;    
        }

        if (obj == null || (obj.getClass() != this.getClass())) 
        {
            return false;
        }

        Course course = (Course)obj;
        return this.classCode == course.classCode;
    }
}