package com.squirrel.courses.dataaccess.dao.test;

import com.squirrel.courses.dataaccess.model.Question;
import com.squirrel.courses.dataaccess.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;
import java.util.List;

/**
 * Class QuestionDAO realizes data-access methods related to working with table Question.
 *
 * @author    Natalie Tkachenko
 */
@Repository
@Transactional
public class QuestionDAO extends JdbcDaoSupport implements IQuestionDAO{

    @Autowired
    public QuestionDAO(DataSource dataSource){
        this.setDataSource(dataSource);
    }

    @Override
    public List<Question> findQuestionsByTest(int test) {
        String sql = QuestionMapper.BASE_SQL + " WHERE test = ?";

        Object [] params = new Object[]{test};
        QuestionMapper mapper = new QuestionMapper();

        try {
            List<Question> quests = getJdbcTemplate().query(sql, params, mapper);                                //возможно неправильно
            return quests;
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public boolean addQuestion(Question quest) {
        String sql = QuestionMapper.INSERT_SQL + " VALUES(?, ?, ?, ?)";

        Object [] params = new Object[]{quest.getTest(), quest.getQuestText(), quest.getPoints(), quest.getIsOpen()};
        try{
            this.getJdbcTemplate().update(sql, params);
            return true;
        }
        catch (DataAccessException e){
            return false;
        }
    }

    @Override
    public int getLastQuestion() {
        String sql = "SELECT MAX(id) as questId FROM question";

        try {
            int testId = this.getJdbcTemplate().queryForObject(sql, Integer.class);        //возможно неправильно
            return testId;
        } catch (EmptyResultDataAccessException e) {
            return -1;
        }
    }
}
