package ictgradschool.industry.questions;

public class TrueFalseQuestion implements IQuestion {

    private String question;
    private boolean correctAnswer;

    public TrueFalseQuestion(String question, boolean correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void printQuestion() {
        System.out.println("True or False?: " + question);
    }

    @Override
    public boolean isValidAnswer(String userAnswer) {
        if (userAnswer == null) {
            return false;
        }
        userAnswer = userAnswer.toLowerCase();
        return userAnswer.equals("true") || userAnswer.equals("false");
    }

    @Override
    public boolean isCorrect(String userAnswer) {
        return Boolean.parseBoolean(userAnswer) == this.correctAnswer;
    }
}
