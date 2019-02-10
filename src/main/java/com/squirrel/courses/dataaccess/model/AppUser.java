package com.squirrel.courses.dataaccess.model;

/**
 * Class AppUser represents the entity of user in system with main information about him.
 *
 * @author    Bogdan Popovich
 */
public class AppUser {
    private String login;
    private String hashPass;

    /**
     * Var role defines user's role and rights in system.
     * It can be "admin", "lecturer" or "student".
     */
    private String role;
    private String userName;

    /** Var description keeps information that user wrote about himself. */
    private String description;

    public AppUser(String login, String hashPass, String role, String userName, String description) {
        this.login = login;
        this.hashPass = hashPass;
        this.role = role;
        this.userName = userName;
        this.description = description;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
