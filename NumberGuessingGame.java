// Code by : Kiran
// Task 1 : NUMBER GAME


import java.util.Scanner;
import java.util.Random;


public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;
            rounds++;

            System.out.println("Round " + rounds + ": Guess a number between " + minRange + " and " + maxRange);

            while (!guessedCorrectly && attempts < maxAttempts) {
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the correct number " + generatedNumber);
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low. Try again. Attempts left: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Too high. Try again. Attempts left: " + (maxAttempts - attempts));
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + generatedNumber);
            }

            score += maxAttempts - attempts;
            System.out.println("Your current score: " + score);

            System.out.println("Do you want to play again? (yes/no)");
            String playAgainResponse = sc.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes") || playAgainResponse.equals("y");
        }

        System.out.println("Thank you for playing!");
        sc.close();
    }
}
