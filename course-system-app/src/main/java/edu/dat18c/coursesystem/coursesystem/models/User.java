package edu.dat18c.coursesystem.coursesystem.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * User
 */
@Entity
@Table(name = "user")
public class User
{
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToMany
    @JoinTable(
        name = "course_teacher",
        joinColumns = @JoinColumn(name = "teacher_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

    public User() {}

    public long getId() 
    {
        return id;
    }

    public void setId(long id) 
    {
        this.id = id;
    }

    public String getFirstname() 
    {
        return firstname;
    }

    public void setFirstname(String firstname) 
    {
        this.firstname = firstname;
    }

    public String getLastname() 
    {
        return lastname;
    }

    public void setLastname(String lastname) 
    {
        this.lastname = lastname;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Role getRole() 
    {
        return role;
    }

    public void setRole(Role role) 
    {
        this.role = role;
    }

    
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() 
    {
        return String.format("[User (id: %s, created_at: %s)]", this.id, this.createdAt.toString());
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

        User user = (User)obj;
        return this.id == user.id && 
               this.email == user.email && 
               this.password == user.password;
    }

    @Override
    public int hashCode() 
    {
        return (id + firstname + lastname + email + password).hashCode();
    }
}