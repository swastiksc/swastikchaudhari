import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame 
{
    public static void main(String[] args)
     {
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 100;
        final int MAX_ATTEMPTS = 7;
        int roundsPlayed = 0;
        int roundsWon = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println(" Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");

        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println("\n Round " + (roundsPlayed + 1) + " - You have " + MAX_ATTEMPTS + " attempts to guess the number.");

            while (attemptsLeft > 0) 
            {
                System.out.print("Enter your guess (" + MIN_NUMBER + "-" + MAX_NUMBER + "): ");

                if (!scanner.hasNextInt())
                 {
                    System.out.println(" Invalid input. Please enter an integer.");
                    scanner.next(); 
                    continue;
                }

                int guess = scanner.nextInt();

                if (guess < MIN_NUMBER || guess > MAX_NUMBER) 
                {
                    System.out.println(" Please guess a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
                    continue;
                }

                if (guess < secretNumber) 
                {
                    System.out.println("⬆ Too low.");
                } else if (guess > secretNumber) 
                {
                    System.out.println(" Too high.");
                } else {
                    System.out.println(" Correct! You guessed the number.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                }

                attemptsLeft--;
                System.out.println(" Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) 
            {
                System.out.println(" Out of attempts! The correct number was " + secretNumber + ".");
            }

            roundsPlayed++;
            System.out.println(" Score: " + roundsWon + " wins out of " + roundsPlayed + " rounds.");

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println(" Thanks for playing! Goodbye!");
        scanner.close();
    }
}
