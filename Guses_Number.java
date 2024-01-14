import java.util.Random;
import java.util.Scanner;

public class Guses_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        System.out.println(" hello , Welcome to the Guess the Number Game ");

        do {
            int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round " + (rounds + 1));
            System.out.println("Guess the number between " + lowerBound + " and " + upperBound);

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations You guessed the correct number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score += maxAttempts - attempts + 1; // Adjust score based on attempts
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've run out of attempts. The correct number was: " + generatedNumber);
            }

            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Your total score is: " + score);
                break;
            }

        } while (true);

        scanner.close();
    }
}
