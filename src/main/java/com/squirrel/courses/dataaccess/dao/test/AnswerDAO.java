package com.squirrel.courses.dataaccess.dao.test;

import com.squirrel.courses.dataaccess.model.Answer;
import com.squirrel.courses.dataaccess.mapper.AnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Class AnswerDAO realizes data-access methods related to working with table Answer.
 *
 * @author    Natalie Tkachenko
 */
@Repository
@javax.transaction.Transactional
public class AnswerDAO extends JdbcDaoSupport implements IAnswerDAO {

    @Autowired
    public AnswerDAO(DataSource dataSource){
        this.setDataSource(dataSource);
    }

    @Override
    public List<Answer> findAnswersByQuestion(int quest) {
        String sql = AnswerMapper.BASE_SQL + " WHERE question = ?";

        Object [] params = new Object[]{quest};
        AnswerMapper mapper = new AnswerMapper();

        try {
            List<Answer> answers = getJdbcTemplate().query(sql, params, mapper);
            return answers;
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public boolean addAnswer(Answer answer){
        String sql = AnswerMapper.INSERT_SQL + " VALUES(?, ?, ?)";

        Object [] params = new Object[]{answer.getQuestion(), answer.getAnsText(), answer.getCoef()};
        try{
            this.getJdbcTemplate().update(sql, params);
            return true;
        }
        catch (DataAccessException e){
            return false;
        }
    }
}
