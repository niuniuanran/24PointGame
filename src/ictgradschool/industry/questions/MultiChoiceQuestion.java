package ictgradschool.industry.questions;

public class MultiChoiceQuestion implements IQuestion {

    private String question;
    private String correctAnswer;
    private String[] possibleAnswers;

    public MultiChoiceQuestion(String question, String[] possibleAnswers, String correctAnswer) {
        this.question = question;
        this.possibleAnswers = possibleAnswers;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void printQuestion() {
        System.out.println(question);
        for (int i = 0; i < possibleAnswers.length; i++) {

            System.out.println((char) ('A' + i) + ") " + possibleAnswers[i]);
        }

    }

    @Override
    public boolean isValidAnswer(String userAnswer) {
        if (userAnswer.length() > 1) {
            return false;
        }

        if (userAnswer.toUpperCase().charAt(0) >= 'A' && userAnswer.toUpperCase().charAt(0) <= 'A' + possibleAnswers.length - 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCorrect(String userAnswer) {
        if (userAnswer.toUpperCase().equals(correctAnswer)) {
            return true;
        }
        return false;
    }
}
