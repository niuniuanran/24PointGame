package ictgradschool.industry.questions;

public class MathsQuestion implements IQuestion {

    private String question;
    private double correctAnswer;
    private double allowedDelta;

    public MathsQuestion(String question, double correctAnswer) {
        this(question, correctAnswer, 1e-15);
    }

    public MathsQuestion(String question, double correctAnswer, double allowedDelta) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.allowedDelta = allowedDelta;
    }

    @Override
    public void printQuestion() {
        System.out.println(question);
    }

    @Override
    public boolean isValidAnswer(String userAnswer) {
        try {
            Double.parseDouble(userAnswer);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isCorrect(String userAnswer) {
        return Math.abs(Double.parseDouble(userAnswer) - correctAnswer) <= allowedDelta;
    }
}
