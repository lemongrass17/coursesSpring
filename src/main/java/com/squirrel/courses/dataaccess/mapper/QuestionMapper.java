package com.squirrel.courses.dataaccess.mapper;

import com.squirrel.courses.dataaccess.model.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class QuestionMapper realizes RowMapper method to convert query result to object Question.
 * Also it contains basic queries as constants.
 *
 * @author    Natalie Tkachenko
 */
public class QuestionMapper implements RowMapper<Question> {
    public static final String BASE_SQL = "SELECT id, test, q_text, points, isOpen FROM question";
    public static final String INSERT_SQL = "INSERT INTO question(test, q_text, points, isOpen)";

    @Override
    public Question mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        int test = resultSet.getInt("test");
        String questText = resultSet.getString("q_text");
        int points = resultSet.getInt("points");
        byte isOpen = resultSet.getByte("isOpen");

        return new Question(id, test, questText, points, isOpen);
    }
}
