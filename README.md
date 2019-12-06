In this session we will build a simple game that lets the user answer questions provided by the computer. The game will keep track of their score, which will be printed at the end.

1) Load up the project in IntelliJ.

2) Create a new interface, called `IQuestion` (remember IJ shortcuts!). This will represent some kind of question to be answered by the user. When doing this, ask yourself:
   - What is an interface?
   - When is it a good idea to use interfaces?
   
3) `IQuestion` should define three methods:
   - `printQuestion()`: will print out the question to the user, so they know what they are being asked.
   - `isValidAnswer()`: Will take a `String` argument representing the user's answer. Will return `true` if and only if the given answer is valid (but not necessarily correct). For example, if the question is a maths problem, then "2", or "8.5" might be valid answers, but "Bob" is probably not.
   - `isCorrect()`: Will take a `String` argument representing the user's answer. Will return `true` if their answer is actually correct.

4) Let's make an implementation of that interface - call it `MultiChoiceQuestion`. This will represent a question with some number of possible answers, and the user should choose from one of those answers.
   - Use IntelliJ shortcuts to make yourself a skeleton implementation of this class, which we'll then fill in.

5) Create the constructor for `MultiChoiceQuestion`. At the same time, also create instance variables to store the data supplied in the constructor. The constructor should take the following arguments:
   - A `String` representing the question to ask the user
   - A `String[]` array representing the possible answers to the MCQ. Each element in the array would be a valid answer.
   - A `String` representing the letter of the correct answer.
   
   For example:
   - The first argument could be the String "What is 1 + 1?"
   - The second argument could be a String[] containing the elements "0", "2", "-7", and "Infinity".
   - The third argument could be the String "B", because B is the correct answer to the above question.
			  
6) Implement the `printQuestion()` method for `MultiChoiceQuestion`. This should print the question that was supplied in the constructor, and then each of the possible answers, along with the letter the user should type for that answer. For example, following on from the question above, this should print:

    ```text
    What is 1 + 1?
    A) 0
    B) 2
    C) -7
    D) Infinity
    ```
    
    HINT:
    ```java
    char letter = 'A';
    letter ++;
    System.out.println(letter); // This will print "B".
    ```

7) Implement the `isCorrect()` method for `MultiChoiceQuestion`. This should return true if the supplied answer string is the correct letter (ignore case).
   - Continuing from the previous example, the method should return true if the supplied answer is "B" or "b". Otherwise it should return false.

8) Implement the `isValidAnswer()` method for `MultiChoiceQuestion`. This should return true if the supplied answer string is any of the possible answer letters (ignore case)
   - Continuing from the previous example, the method should return true if the supplied answer is "A", "B", "C", or "D", or any of the lowercase equivalents. Otherwise it should return false.

    HINT:
    ```java
    char letter = 'C';
    if (letter >= 'A' && letter <= 'D') {
        System.out.println("Hello"); // This message will be printed.
    }
    ```

9) Create a new method in the `Main` class called `createQuestions()`.
    - This method should create a new `IQuestion[]` array, of length 5.
    - The method should then populate the array with five `MultiChoiceQuestion` instances (the contents of which are up to you!).
    - Finally, the method should return the array.

10) Add code to the `start()` method to complete the program. The code should do the following:
    1. Call the `createQuestions()` method to get the array of questions to ask.
    
    2. Loop through the questions array. For each question:
    
    3. Ask the question to the user
    
    4. Get the user's answer (use `Keyboard` class)
    
    5. Check whether the user has entered a valid answer (i.e. that the question's `isValidAnswer()` method returns true). If they haven't, prompt them to enter a new answer, and go back to iii.
    
    6. Check whether the user has entered a correct answer (i.e. that the question's `isCorrect()` method returns true). Print a message saying whether or not their answer was correct. If it was correct, add one to the user's score.
    
    7. After the questions loop, print a message similar to "You answered 3 out of 5 questions correctly".

    For this step, try and think about how you might extract different code into different *methods*, rather than having everything in the `start()` method.

11) Extend your work by adding a new type of question. For example: a `MathsQuestion` (where the result is a number), a `TrueFalseQuestion` (where the result is a boolean), or something else imaginative.