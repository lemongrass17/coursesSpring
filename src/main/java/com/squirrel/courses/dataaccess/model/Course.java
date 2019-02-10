package com.squirrel.courses.dataaccess.model;

/**
 * Class Course represents the entity of training course with main information about it.
 *
 * @author    Maxim Tytskiy
 */
public class Course {
    private int id;
    private String lecturer;
    private String courseName;
    private String theme;
    private String description;

    public Course(int id, String lecturer, String courseName, String theme, String description) {
        this.id = id;
        this.lecturer = lecturer;
        this.courseName = courseName;
        this.theme = theme;
        this.description = description;
    }

    public Course(String lecturer, String courseName, String theme, String description) {
        this.lecturer = lecturer;
        this.courseName = courseName;
        this.theme = theme;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
