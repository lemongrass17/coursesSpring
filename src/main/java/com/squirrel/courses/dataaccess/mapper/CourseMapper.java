package com.squirrel.courses.dataaccess.mapper;

import com.squirrel.courses.dataaccess.model.Course;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class CourseMapper realizes RowMapper method to convert query result to object Course.
 * Also it contains basic queries as constants.
 *
 * @author    Maxim Tytskiy
 */
public class CourseMapper implements RowMapper<Course> {
    public static final String BASE_SQL = "SELECT id, lecturer, course_name, theme, description FROM course";
    public static final String INSERT_SQL = "INSERT INTO course (lecturer, course_name, theme, description)";
    public static final String DELETE_SQL = "DELETE FROM course";
    public static final String THEME_SQL = "SELECT DISTINCT theme FROM course";

    @Override
    public Course mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String lecturer = resultSet.getString("lecturer");
        String courseName = resultSet.getString("course_name");
        String theme = resultSet.getString("theme");
        String description = resultSet.getString("description");

        return new Course(id, lecturer, courseName, theme, description);
    }
}
