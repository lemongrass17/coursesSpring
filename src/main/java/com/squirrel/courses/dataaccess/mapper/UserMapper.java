package com.squirrel.courses.dataaccess.mapper;

import com.squirrel.courses.dataaccess.model.AppUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class UserMapper realizes RowMapper method to convert query result to object AppUser.
 * Also it contains basic queries as constants.
 *
 * @author    Bogdan Popovich
 */
public class UserMapper implements RowMapper<AppUser> {
    public static final String BASE_SQL = "SELECT login, hash_pass, role, user_name, description FROM user";
    public static final String INSERT_SQL = "INSERT INTO user (login, hash_pass, role, user_name, description)";

    @Override
    public AppUser mapRow(ResultSet resultSet, int i) throws SQLException {
        String login = resultSet.getString("login");
        String hashPass = resultSet.getString("hash_pass");
        String role = resultSet.getString("role");
        String userName = resultSet.getString("user_name");
        String description = resultSet.getString("description");

        return new AppUser(login, hashPass, role, userName, description);
    }
}
