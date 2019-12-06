package ictgradschool.industry.questions;

public interface IQuestion {
    void printQuestion();
    boolean isValidAnswer(String userAnswer);
    boolean isCorrect(String userAnswer);

}
