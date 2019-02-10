package com.squirrel.courses.service.lesson;

import com.squirrel.courses.dataaccess.dao.lesson.ILessonDAO;
import com.squirrel.courses.dataaccess.model.Lesson;
import com.squirrel.courses.dataaccess.dao.course.ICourseDAO;
import com.squirrel.courses.dataaccess.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Class LessonService is a interlayer between controller and data-access classes for working with lessons.
 *
 * @author    Vladislava Prokopenko
 */
@Service
public class LessonService implements ILessonService{

    private ILessonDAO lessonDAO;
    private ICourseDAO courseDAO;

    @Autowired
    public void setLessonDAO(ILessonDAO lessonDAO, ICourseDAO courseDAO) {
        this.lessonDAO = lessonDAO;
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Lesson> getLessonsByCourse(int courseId){
        return lessonDAO.allLessonsByCourse(courseId);
    }

    @Override
    public boolean addLesson(Lesson lesson){
        return lessonDAO.addLesson(lesson);
    }

    @Override
    public Lesson getLessonById(int lessonId) {return lessonDAO.getLessonByID(lessonId);}

    @Override
    public boolean deleteLesson(int id) {
        return lessonDAO.deleteLesson(id);
    }


}
