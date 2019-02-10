package com.squirrel.courses.dataaccess.dao.test;

import com.squirrel.courses.dataaccess.model.Answer;

import java.util.List;

/**
 * Interface IAnswerDAO assigns data-access methods related to working with table Answer.
 *
 * @author    Natalie Tkachenko
 */
public interface IAnswerDAO {
    List<Answer> findAnswersByQuestion(int quest);
    boolean addAnswer(Answer answer);
}

