import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

        do {
            int number = random.nextInt(100) + 1;
            int attempts = 5;
            boolean guessed = false;

            System.out.println("\nGuess the number between 1 and 100");
            System.out.println("You have " + attempts + " attempts.");

            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("Correct! You guessed it.");
                    guessed = true;
                    score++;
                    break;
                } else if (guess > number) {
                    System.out.println("Too High.");
                } else {
                    System.out.println("Too Low.");
                }

                attempts--;
                System.out.println("Attempts left: " + attempts);
            }

            if (!guessed) {
                System.out.println("You Lost! Number was: " + number);
            }

            System.out.println("Current Score: " + score);

            System.out.print("Play Again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("Final Score: " + score);
        sc.close();
    }
}
