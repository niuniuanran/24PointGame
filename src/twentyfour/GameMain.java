package twentyfour;

import java.security.Key;

public class GameMain {
    private NumbersGenerator numbersGenerator;

    private void start () {
        System.out.println("Welcome to 24 points game!");
        System.out.println("In this game, you will be given four numbers a, b, c, d.");
        System.out.print("Your goal is to write a java expression using +, -, *, /, % with ALL these four numbers,");
        System.out.println("so that your expression evaluates to 24.");
        System.out.println("Take advantage of Java int operator rules, for example, 17/2  = 8");
        System.out.println();
        setDifficulty();
        System.out.println("Now have fun!");
        singleGame();
        System.out.println("Thank you for playing! Goodbye!");

    }

    private void setDifficulty() {
        System.out.println("Please pick a difficulty level to start. ");
        System.out.println("Enter a number between 1 and 5. \n1 for the easiest, and 5 for the hardest.");

        try {
            int difficulty = Integer.parseInt(Keyboard.readInput());
            numbersGenerator = new NumbersGenerator(difficulty * 10);
            System.out.println("Awesome! You've picked a difficulty level of " + difficulty +". Game is ON!\n");
        } catch (NumberFormatException e) {
            setDifficulty();
        }

    }

    private void singleGame() {
        NumAnsCombo combo = numbersGenerator.generateCombo();
        TwentyFourQuestion question24 = new TwentyFourQuestion(combo.nums[0],combo.nums[1],combo.nums[2],combo.nums[3]);
        question24.printQuestion();
        boolean gotIt = false;
        for (int i = 0; i < 3; i++) {
            System.out.printf("Attempt %d - Please enter your expression: ", i+1);
            String userAnswer = Keyboard.readInput();
            if (!question24.isValidAnswer(userAnswer)) {
                if (i<2) System.out.println("Please try again");
                continue;
            }
            if (!question24.isCorrect(userAnswer)) {
                if (i<2) System.out.println("Please try again!");
                continue;
            }
            if (question24.isCorrect(userAnswer)) {
                System.out.println("Yay! You got it!!\n");
                gotIt = true;
                break;
            }
        }
        if (!gotIt) {
            System.out.println("Oh no! You used up all your three attempts...");
            System.out.println("Press 'Y' to see a sample answer");
            if (Keyboard.readInput().toUpperCase().charAt(0) == 'Y')
                System.out.println("A sample answer could be: " + combo.ans);
        }

        System.out.println("\nPress Y to start another game, D to pick a new difficulty level, any other key to exit");
        char choice = Keyboard.readInput().toUpperCase().charAt(0);
        if (choice == 'Y') singleGame();
        else if (choice == 'D') {setDifficulty();singleGame();}
    }


    public static void main(String[] args) {
        GameMain game = new GameMain();
        game.start();
    }
}
