package com.squirrel.courses.dataaccess.mapper;

import com.squirrel.courses.dataaccess.model.Answer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class AnswerMapper realizes RowMapper method to convert query result to object Answer.
 * Also it contains basic queries as constants.
 *
 * @author    Natalie Tkachenko
 */
@Repository
public class AnswerMapper implements RowMapper<Answer> {
    public static final String BASE_SQL = "SELECT id, question, a_text, coefficient FROM answer";
    public static final String INSERT_SQL = "INSERT INTO answer(question, a_text, coefficient)";

    @Override
    public Answer mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        int question = resultSet.getInt("question");
        String ansText = resultSet.getString("a_text");
        double coef = resultSet.getDouble("coefficient");

        return new Answer(id, question, ansText, coef);
    }
}
