package edu.dat18c.coursesystem.models.enums;

public enum RoleType 
{
    STUDENT(1),
    TEACHER(2),
    ADMIN(3),
    UNKNOWN(4);

    private final int index;

    RoleType(int index) 
    {
        this.index = index;
    }

    public static RoleType fromInt(int index)
    {
        switch (index) 
        {
            case 1:
                return RoleType.STUDENT;
            case 2: 
                return RoleType.TEACHER;
            case 3: 
                return RoleType.ADMIN;
            default:
                return RoleType.UNKNOWN;
        }
    }

    public int getRoleIndex(RoleType roleType)
    {
        return roleType.index;
    }
}