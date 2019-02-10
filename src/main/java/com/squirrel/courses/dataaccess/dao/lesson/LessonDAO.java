package com.squirrel.courses.dataaccess.dao.lesson;

import com.squirrel.courses.dataaccess.mapper.CourseMapper;
import com.squirrel.courses.dataaccess.mapper.LessonMapper;
import com.squirrel.courses.dataaccess.model.Course;
import com.squirrel.courses.dataaccess.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class LessonDAO realizes data-access methods related to working with table Lesson.
 *
 * @author    Vladislava Prokopenko
 */
@Repository
@Transactional
public class LessonDAO extends JdbcDaoSupport implements ILessonDAO {

    @Autowired
    public LessonDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    @Override
    public List<Lesson> allLessonsByCourse(int idCourse) {

        String sql = LessonMapper.BASE_SQL + " WHERE course = ?";

        Object[] params = new Object[]{idCourse};
        LessonMapper mapper = new LessonMapper();

        try {
            List<Lesson> lessons = getJdbcTemplate().query(sql, params, mapper);                       //
            return lessons;
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public String getCourseName(int id) {
        String sql = CourseMapper.BASE_SQL + " WHERE id = ?";

        Object[] params = new Object[]{id};
        CourseMapper mapper = new CourseMapper();

        try {
            Course course = getJdbcTemplate().queryForObject(sql, params, mapper);                        //возможно неправильно
            return course.getCourseName();
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public String getLessonName(int id){
        String sql = LessonMapper.BASE_SQL + " WHERE id = ?";

        Object[] params = new Object[]{id};
        LessonMapper mapper = new LessonMapper();

        try {
            String lessonName = getJdbcTemplate().queryForObject(sql, params, mapper).getLessName();                        //возможно неправильно
            return lessonName;
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }


    @Override
    public Lesson getLessonByID(int id) {
        String sql = LessonMapper.BASE_SQL + " WHERE id = ?";

        Object[] params = new Object[]{id};
        LessonMapper mapper = new LessonMapper();

        try {
            Lesson lesson = getJdbcTemplate().queryForObject(sql, params, mapper);                        //возможно неправильно
            return lesson;
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Lesson> getLessonsByName(String name) {
        String sql = LessonMapper.BASE_SQL + " WHERE less_name = ?";

        Object[] params = new Object[]{name};
        LessonMapper mapper = new LessonMapper();

        try {
            List<Lesson> lessons = getJdbcTemplate().query(sql, params, mapper);                       //
            return lessons;
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public boolean addLesson(Lesson lesson) {

        String sql = LessonMapper.INSERT_SQL + " VALUES(?, ?, ?, ? ,?)";

        Object[] params = new Object[]{lesson.getId(), lesson.getCourse(),
                lesson.getLessName(), lesson.getDescription(), lesson.getMaterial()};

        try {
            this.getJdbcTemplate().update(sql, params);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }

    @Override
    public boolean deleteLesson(int lessonId) {
        String sql = LessonMapper.DELETE_SQL + " WHERE id = ?";

        Object[] params = new Object[]{lessonId};
        try {
            this.getJdbcTemplate().update(sql, params);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }

}
