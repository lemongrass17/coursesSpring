package com.squirrel.courses.dataaccess.dao.test;

import com.squirrel.courses.dataaccess.mapper.TestMapper;
import com.squirrel.courses.dataaccess.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;

/**
 * Class TestDAO realizes data-access methods related to working with table Test.
 *
 * @author    Natalie Tkachenko
 */
@Repository
@Transactional
public class TestDAO extends JdbcDaoSupport implements ITestDAO{

    @Autowired
    public TestDAO(DataSource dataSource){
        this.setDataSource(dataSource);
    }

    @Override
    public Test findTestById(int id) {
        String sql = TestMapper.BASE_SQL + " WHERE id = ?";

        Object [] params = new Object[]{id};
        TestMapper mapper = new TestMapper();

        try {
            Test test = getJdbcTemplate().queryForObject(sql, params, mapper);                                //возможно неправильно
            return test;
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public Test findTestByLesson(int lesson) {
        String sql = TestMapper.BASE_SQL + " WHERE lesson = ? AND isExam = 0";

        Object [] params = new Object[]{lesson};
        TestMapper mapper = new TestMapper();

        try {
            Test test = getJdbcTemplate().queryForObject(sql, params, mapper);                                //возможно неправильно
            return test;
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public Test findExamByCourse(int course) {
        String sql = TestMapper.BASE_SQL + " WHERE lesson = ? AND isExam = 1";

        Object [] params = new Object[]{course};
        TestMapper mapper = new TestMapper();

        try {
            Test test = getJdbcTemplate().queryForObject(sql, params, mapper);                                //возможно неправильно
            return test;
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public boolean addTest(Test test) {
        String sql = TestMapper.INSERT_SQL + " VALUES(?, ?, ?)";

        Object [] params = new Object[]{test.getLesson(), test.getEvaluation(), test.getIsExam()};
        try{
            this.getJdbcTemplate().update(sql, params);
            return true;
        }
        catch (DataAccessException e){
            return false;
        }
    }

    public boolean deleteTest(int testId){
        String sql = TestMapper.DELETE_SQL + " WHERE id = ?";

        Object[] params = new Object[]{testId};
        try{
            this.getJdbcTemplate().update(sql, params);
            return true;
        }
        catch (DataAccessException e){
            return false;
        }
    }

    public int getLastTest() {
        String sql = "SELECT MAX(id) as testId FROM test";

        try {
            int testId = this.getJdbcTemplate().queryForObject(sql, Integer.class);        //возможно неправильно
            return testId;
        } catch (EmptyResultDataAccessException e) {
            return -1;
        }
    }
}
