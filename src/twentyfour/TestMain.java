package twentyfour;

public class TestMain {

    /**
     * Main program flow
     */
    private void start() {

        // Get all questions to ask
        IQuestion[] questions = createQuestions();

        // Keep track of score
        int score = 0;

        // For each question...
        for (IQuestion question : questions) {

            // Ask that question, and increment the score if the user was correct
            score += askQuestion(question);

            System.out.println();

        }

        // Print final results
        System.out.println("You answered " + score + " out of " + questions.length + " questions correctly.");
    }

    /**
     * Asks the given question to the user, and displays a message indicating whether the user was correct or not. Returns the amount to add to the user's score.
     *
     * @param question the question to ask
     * @return the addition to the user's score (1 if correct, 0 if incorrect)
     */
    private int askQuestion(IQuestion question) {
        String userAnswer = getUserAnswer(question);

        if (question.isCorrect(userAnswer)) {
            System.out.println("Your answer is correct.");
            return 1;
        } else {
            System.out.println("Your answer is incorrect.");
            return 0;
        }
    }

    /**
     * Gets the user's answer to the given question. If the user doesn't enter a valid answer, re-prompt until they do.
     *
     * @param question the question to ask
     * @return the user's answer to that question
     */
    private String getUserAnswer(IQuestion question) {
        String userAnswer;
        while (true) {
            question.printQuestion();
            System.out.print("Your answer: ");
            userAnswer = Keyboard.readInput();
            if (question.isValidAnswer(userAnswer)) {
                break;
            }
            System.out.println("'" + userAnswer + "' is not a valid answer. Please try again!");
            System.out.println();
        }
        return userAnswer;
    }

    /**
     * Creates and returns an array of all questions to ask the user.
     *
     * @return the array of questions.
     */
    private IQuestion[] createQuestions() {
        IQuestion[] questions = new IQuestion[5];
        questions[0] = new TwentyFourQuestion(1,2,3,4);
        questions[1] = new TwentyFourQuestion(2,2,6,4);
        questions[2] = new TwentyFourQuestion(3,2,2,4);
        questions[3] = new TwentyFourQuestion(0,8,3,4);
        questions[4] = new TwentyFourQuestion(5,3,1,4);


        return questions;

    }

    public static void main(String[] args) {
        TestMain p = new TestMain();
        p.start();

    }
}
