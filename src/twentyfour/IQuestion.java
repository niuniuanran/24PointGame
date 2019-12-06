package twentyfour;

public interface IQuestion {
    void printQuestion();
    boolean isValidAnswer(String userAnswer);
    boolean isCorrect(String userAnswer);

}
