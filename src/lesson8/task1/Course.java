package lesson8.task1;

import java.util.Date;

public class Course {
    Date startDate;
    String name;
    int hoursDuration;
    String teacherName;
    Student[] students;

    public Course(Date startDate, String name, int hoursDuration, String teacherName, Student[] students) {
        this.startDate = new Date();
        this.name = name;
        this.hoursDuration = hoursDuration;
        this.teacherName = teacherName;
        this.students = null;
    }
}
