package com.squirrel.courses.controller;

import com.squirrel.courses.dataaccess.model.*;
import com.squirrel.courses.service.course.ICourseService;
import com.squirrel.courses.service.test.ITestService;
import com.squirrel.courses.service.lesson.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Class TestController realizes controller's methods working with test.
 *
 * @author    Natalie Tkachenko, Maxim Tytskiy
 */
@Controller
public class TestController {
    private ITestService testService;
    private ILessonService lessonService;
    private ICourseService courseService;

    @Autowired
    public TestController(ITestService testService, ICourseService courseService, ILessonService lessonService) {
        this.testService = testService;
        this.lessonService = lessonService;
        this.courseService = courseService;
    }

    /**
     * Controller method to get access and show information for test.
     */
    @GetMapping({"/test"})
    public String showTestInfo(Model model, @RequestParam("lessonId") int lessonId, @RequestParam("isExam") byte isExam){
        Test test;
        List<Question> quests;
        List<Answer> answers = new ArrayList();

        if(isExam == 0) {                                               //if test isn't exam
            test = testService.findTestByLesson(lessonId);
        } else {
            test = testService.findExamByCourse(lessonId);
        }

        model.addAttribute("id", test.getId());
        model.addAttribute("course", lessonId);
        model.addAttribute("evaluation", test.getEvaluation());
        model.addAttribute("isExam", isExam);

        quests = testService.findQuestionsByTest(test.getId());
        model.addAttribute("questions", quests);

        for (Question quest: quests) {                                  //loop for adding answers to close questions
            if(quest.getIsOpen() == 0) {
                List<Answer> ans = testService.findAnswersByQuestion(quest.getId());

                if(ans.size() > 0 && ans != null){                      //if question contains answers, then add it
                    answers.addAll(ans);
                }
            }
        }

        model.addAttribute("answers", answers);

        return "test";
    }


    /**
     * Controller method to get access and show information for test.
     */
    @GetMapping("/addtest")
    public String showNewTest(Model model, @RequestParam("courseId") int courseId,
                              @RequestParam("lessonId") Optional<Integer> lessonId)
    {
        byte isExam;
        Lesson lesson = null;

        if (lessonId.isPresent()) {                                     //if test isn't exam
            isExam = 0;
            lesson = lessonService.getLessonById(lessonId.get());
        }else{
            isExam = 1;
        }
        Course course = courseService.getCourseById(courseId);

        model.addAttribute("isExam", isExam);
        model.addAttribute("course", course);
        model.addAttribute("lesson", lesson);

        return "addtest";
    }

    /**
     * Controller method to get access and show information for test.
     */
    @GetMapping("/edittest")
    public String showTest(Model model, @RequestParam("courseId") int courseId,
                           @RequestParam("testId") int testId)
    {
        Course course = courseService.getCourseById(courseId);
        Test test = testService.findTestById(testId);
        Lesson lesson = null;

        if (test.getIsExam() == 0)                                      //if test isn't exam
            lesson = lessonService.getLessonById(test.getLesson());

        List<Question> questions = testService.findQuestionsByTest(testId);
        Map<Question, List<Answer>> questionMap = new TreeMap<>();      //Collection of questions and lists of answers for every question

        for(Question question: questions){
            questionMap.put(question, testService.findAnswersByQuestion(question.getId()));
        }

        model.addAttribute("isExam", test.getIsExam());
        model.addAttribute("testId", test.getId());
        model.addAttribute("course", course);
        model.addAttribute("lesson", lesson);
        model.addAttribute("questionMap", questionMap);

        return "edittest";
    }

    /**
     * Controller method to receive query from user to delete course.
     *
     * @param params contains all parameters for adding new test from page addtest or edittest.
     */
    @RequestMapping({"/posttest"})
    public ModelAndView addTest(ModelMap model, @RequestParam Map<String, String> params)
    {
        String testId = params.get("testId");
        int courseId = Integer.parseInt(params.get("courseId"));
        int lessonId;
        byte isExam;

        if ((params.get("lessonId").equals("null"))){                   //if test is exam
            isExam = 1;
            lessonId=courseId;
        }
        else {
            isExam = 0;
            lessonId = Integer.parseInt(params.get("lessonId"));
        }

        if (testId != null){
            testService.deleteTest(Integer.parseInt(testId));           //if test already exists, delete it and create new one (editing old test).
        }

        String questCount = params.get("questCount");
        String questText;                                               //questText - var for text of question
        String ansCount;                                                //ansCount - var for number of answers on question
        int points;                                                     //points - var for grade for question
        String ansText;                                                 //ansText - var for text of answer
        double ansCoef;                                                 //ansCoef - var for coefficient of answer

        int evaluation = 0;                                             //evaluation - var for total grade of test

        int i = 0;
        while (i < Integer.parseInt(questCount)){                       //loop for calculating evaluation
             String grade = params.get("mark"+i);
             if (grade != null){
                 evaluation += Integer.parseInt(grade);
                 i++;
             }
        }

        testService.addTest(new Test(lessonId, evaluation, isExam));

        int addedTestId = testService.getLastTest();
        byte questType;                                                 //var questType - type of question (1 - open, 0 - close)

        i = 0;
        while (i < Integer.parseInt(questCount))                        //loop for adding questions to test
        {
            questText = params.get("quest" + i);
            if (questText != null)
            {
                points = Integer.parseInt(params.get("mark" + i));
                ansCount = params.get("ans_cnt" + i);

                if (ansCount == null) {                                 //if no param with number of answer is presented - it's open question
                    questType = 1;
                } else {
                    questType = 0;
                }

                testService.addQuestion(new Question(addedTestId, questText, points, questType));

                if(questType == 0){                                                 //if question is close (with answers)
                    for (int j = 0; j < Integer.parseInt(ansCount); j++) {          //loop for adding answers
                        ansText = params.get(j + "ans" + i);
                        ansCoef = Double.parseDouble(params.get(j + "coef" + i));

                        int addedQuestId = testService.getLastQuestion();
                        testService.addAnswer(new Answer(addedQuestId, ansText, ansCoef));
                    }
                }
                i++;
            }
        }

        return new ModelAndView("redirect:/course?courseId=" + courseId, model);
    }
}