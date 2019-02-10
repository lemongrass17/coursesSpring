package com.squirrel.courses.dataaccess.dao.course;

import com.squirrel.courses.dataaccess.model.Course;
import java.util.List;

/**
 * Interface ICourseDAO assigns data-access methods related to working with table Course.
 *
 * @author    Maxim Tytskiy
 */
public interface ICourseDAO {
    Course findCourseByID(int id);
    List<Course> findAllCourses();
    List<Course> findCoursesByName(String name);
    List<Course> findCoursesByLecturer(String lecturer);
    List<Course> findCoursesByTheme(String theme);
    List<String> findCoursesThemes();
    List<String> findCoursesThemesByLecturer(String lecturer);
    boolean addCourse(Course course);
    boolean editCourse(Course course);
    boolean deleteCourse(int id);
}
