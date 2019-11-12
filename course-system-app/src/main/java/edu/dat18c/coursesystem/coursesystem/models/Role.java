package edu.dat18c.coursesystem.coursesystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Role
 */
@Entity(name = "Role")
@Table(name = "role")
public class Role 
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    public Role() {}

    public long getId() 
    {
        return id;
    }

    public void setId(long id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    @Override
    public String toString() 
    {
        return String.format("[User (id: %s, role_name: %s)]", this.id, this.name);
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

        Role role = (Role)obj;
        return this.id == role.id && 
               this.name == role.name;
    }

    @Override
    public int hashCode() 
    {
        return super.hashCode();
    }
}