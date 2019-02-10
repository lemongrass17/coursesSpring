package com.squirrel.courses.dataaccess.mapper;

import com.squirrel.courses.dataaccess.model.Lesson;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class LessonMapper realizes RowMapper method to convert query result to object Lesson.
 * Also it contains basic queries as constants.
 *
 * @author    Vladislava Prokopenko
 */
public class LessonMapper implements RowMapper<Lesson> {
    public static final String BASE_SQL = "SELECT id, course, less_name, description, material FROM lesson";
    public static final String INSERT_SQL = "INSERT INTO lesson (id, course, less_name, description, material)";
    public static final String DELETE_SQL = "DELETE FROM lesson";


    @Override
    public Lesson mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        int course = resultSet.getInt("course");
        String name = resultSet.getString("less_name");
        String description = resultSet.getString("description");
        String material = resultSet.getString("material");

        return new Lesson(id,course, name, description, material);
    }
}
