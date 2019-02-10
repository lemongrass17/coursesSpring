package com.squirrel.courses.dataaccess.model;

/**
 * Class Answer represents the entity of answer to the question with main information about it.
 *
 * @author    Natalie Tkachenko
 */
public class Answer {
    private int id;
    private int question;
    private String ansText;

    /** Var coef defines correctness of answer from 0(absolutely wrong) to 1(absolutely right). */
    private double coef;

    public Answer(int id, int question, String ansText, double coef) {
        this.id = id;
        this.question = question;
        this.ansText = ansText;
        this.coef = coef;
    }

    public Answer(int question, String ansText, double coef) {
        this.question = question;
        this.ansText = ansText;
        this.coef = coef;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public String getAnsText() {
        return ansText;
    }

    public void setAnsText(String ansText) {
        this.ansText = ansText;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }
}
