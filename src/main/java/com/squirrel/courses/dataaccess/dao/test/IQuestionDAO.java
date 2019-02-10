package com.squirrel.courses.dataaccess.dao.test;

import com.squirrel.courses.dataaccess.model.Question;

import java.util.List;

/**
 * Interface IQuestionDAO assigns data-access methods related to working with table Question.
 *
 * @author    Natalie Tkachenko
 */
public interface IQuestionDAO {

    List<Question> findQuestionsByTest(int test);
    boolean addQuestion(Question quest);
    int getLastQuestion();
}
