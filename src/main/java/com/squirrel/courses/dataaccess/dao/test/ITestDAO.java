package com.squirrel.courses.dataaccess.dao.test;

import com.squirrel.courses.dataaccess.model.Test;

import java.util.List;

/**
 * Interface ITestDAO assigns data-access methods related to working with table Test.
 *
 * @author    Natalie Tkachenko
 */
public interface ITestDAO {
    Test findTestById(int id);
    Test findTestByLesson(int lesson);
    Test findExamByCourse(int course);
    boolean addTest(Test test);
    boolean deleteTest(int testId);
    int getLastTest();
}
