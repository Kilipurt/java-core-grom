package lesson8.Task1;

import java.util.Date;

public class Demo {
    Student createHighestParent() {
        Student[] students = new Student[0];
        Course firstCourse = new Course(new Date(), "first course", 100, "Teacher", students);
        Course[] courses = new Course[1];
        courses[0] = firstCourse;
        Student student = new Student("Jack", "Jackovich", 5, courses);
        return student;
    }

    SpecialStudent createLowestChild() {
        Student[] students = new Student[0];
        Course firstCourse = new Course(new Date(), "first course", 100, "Teacher", students);
        Course[] courses = new Course[1];
        courses[0] = firstCourse;
        SpecialStudent specStud = new SpecialStudent("Jack", "Jackovich", 5, courses, 123, "frt");
        return specStud;
    }
}
