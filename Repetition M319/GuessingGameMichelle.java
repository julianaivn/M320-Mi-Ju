import java.util.Scanner;

public class GuessingGame {


    private int targetNumber;
    private int maxAttempts;


    public GuessingGame(int maxNumber, int maxAttempts) {
        this.targetNumber = (int) (Math.random() * maxNumber) + 1;
        this.maxAttempts = maxAttempts;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100. Can you guess it?");

        int attempts = 0;
        boolean guessedCorrectly = false;

        while (attempts < maxAttempts && !guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            guessedCorrectly = checkGuess(guess);

            if (!guessedCorrectly) {
                System.out.println("Try again! Attempts remaining: " + (maxAttempts - attempts));
            }
        }

        if (guessedCorrectly) {
            System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
        } else {
            System.out.println("Game over! The number was: " + targetNumber);
        }
    }

    private boolean checkGuess(int guess) {
        if (guess < targetNumber) {
            System.out.println("Too low!");
            return false;
        } else if (guess > targetNumber) {
            System.out.println("Too high!");
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame(100, 5);
        game.playGame();
    }
}

