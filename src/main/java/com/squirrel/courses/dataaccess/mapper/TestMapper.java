package com.squirrel.courses.dataaccess.mapper;

import com.squirrel.courses.dataaccess.model.Test;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class TestMapper realizes RowMapper method to convert query result to object Test.
 * Also it contains basic queries as constants.
 *
 * @author    Natalie Tkachenko
 */
public class TestMapper implements RowMapper<Test> {
    public static final String BASE_SQL = "SELECT id, lesson, evaluation, isExam FROM test";
    public static final String INSERT_SQL = "INSERT INTO test(lesson, evaluation, isExam)";
    public static final String DELETE_SQL = "DELETE FROM test";

    @Override
    public Test mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        int lesson = resultSet.getInt("lesson");
        int evaluation = resultSet.getInt("evaluation");
        byte isExam = resultSet.getByte("isExam");

        return new Test(id, lesson, evaluation, isExam);
    }
}
