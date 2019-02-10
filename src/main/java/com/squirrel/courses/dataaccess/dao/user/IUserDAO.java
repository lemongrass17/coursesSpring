package com.squirrel.courses.dataaccess.dao.user;

import com.squirrel.courses.dataaccess.model.AppUser;

/**
 * Interface IUserDAO assigns data-access methods related to working with table User.
 *
 * @author    Bogdan Popovich
 */
public interface IUserDAO {
    boolean addUser(AppUser appUser);
    AppUser findByLogin(String login);
}
