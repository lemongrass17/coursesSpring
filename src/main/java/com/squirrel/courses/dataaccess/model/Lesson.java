package com.squirrel.courses.dataaccess.model;

/**
 * Class Lesson represents the entity of educational lecture with main information about it.
 *
 * @author    Vladislava Prokopenko
 */
public class Lesson implements Comparable<Lesson>{
    private int id;
    private int course;
    private String lessName;
    private String description;
    private String material;

    public Lesson(int id, int course, String lessName, String description, String material) {
        this.id = id;
        this.course = course;
        this.lessName = lessName;
        this.description = description;
        this.material = material;
    }

    public Lesson(int course, String lessName, String description, String material) {
        this.course = course;
        this.lessName = lessName;
        this.description = description;
        this.material = material;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getLessName() {
        return lessName;
    }

    public void setLessName(String lessName) {
        this.lessName = lessName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public int compareTo(Lesson lesson) {
        if (this.id < lesson.id) {
            return -1;
        }
        else if (this.id == lesson.id){
            return 0;
        }
        else {
            return 1;
        }
    }
}
