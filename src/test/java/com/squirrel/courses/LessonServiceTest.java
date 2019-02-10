package com.squirrel.courses;

import com.squirrel.courses.dataaccess.dao.course.CourseDAO;
import com.squirrel.courses.dataaccess.dao.lesson.LessonDAO;
import com.squirrel.courses.dataaccess.model.Lesson;
import com.squirrel.courses.service.lesson.ILessonService;
import com.squirrel.courses.service.lesson.LessonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
public class LessonServiceTest {

    @TestConfiguration
    static class LessonServiceTestContextConfiguration {
        @Bean
        public ILessonService lessonService() {
            return new LessonService();
        }
    }

    @Autowired
    private ILessonService lessonService;

    @MockBean
    private LessonDAO lessonDAO;

    @MockBean
    private CourseDAO courseDao;

    @Before
    public void setUp(){
        Lesson lesson = new Lesson(1000, 7, "testLesson",
                "Test description", "Test material");

        Mockito.when(lessonDAO.getLessonByID(lesson.getId())).thenReturn(lesson);
    }

    @Test
    public void whenValidName_thenLessonFound() {
        int id = 1000;
        Lesson found = lessonService.getLessonById(id);

        assertThat(found.getId()).isEqualTo(id);
    }
}
