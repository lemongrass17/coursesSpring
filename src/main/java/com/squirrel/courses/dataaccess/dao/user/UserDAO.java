package com.squirrel.courses.dataaccess.dao.user;

import com.squirrel.courses.dataaccess.model.AppUser;
import com.squirrel.courses.dataaccess.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;

/**
 * Class UserDAO realizes data-access methods related to working with table User.
 *
 * @author    Bogdan Popovich
 */
@Repository
@Transactional
public class UserDAO extends JdbcDaoSupport implements IUserDAO {

    @Autowired
    public UserDAO(DataSource dataSource){
        this.setDataSource(dataSource);
    }

    @Override
    public boolean addUser(AppUser appUser) {
        String sql = UserMapper.INSERT_SQL + " VALUES(?, ?, ?, ?, ?)";

        Object [] params = new Object[]{appUser.getLogin(), appUser.getHashPass(), appUser.getRole(), appUser.getUserName(), appUser.getDescription()};
        try{
            this.getJdbcTemplate().update(sql, params);
            return true;
        }
        catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public AppUser findByLogin(String login) {
        String sql = UserMapper.BASE_SQL + " WHERE login = ?";

        Object[] params = new Object[]{login};
        UserMapper mapper = new UserMapper();
        try {
            AppUser appUser = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return appUser;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
