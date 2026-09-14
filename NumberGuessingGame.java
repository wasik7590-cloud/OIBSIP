import java.util.Random;
import java.util.Scanner;

class Player {

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void increaseScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}


public class NumberGuessingGame {

    private int secretNumber;
    private int attempts;

    public void startGame(Player player, Scanner scanner) {

        Random random = new Random();

        secretNumber = random.nextInt(100) + 1;
        attempts = 0;

        int maxAttempts = 7;
        boolean correct = false;

        System.out.println("\nNew Round Started!");
        System.out.println("Guess a number between 1 and 100");
        System.out.println("You have " + maxAttempts + " attempts.");


        while (attempts < maxAttempts) {

            System.out.print("\nEnter your guess: ");

            int guess;

            // Input validation
            while (true) {
                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                    break;
                }
                else {
                    System.out.println("Invalid input! Please enter numbers only.");
                    scanner.next();
                    System.out.print("Enter your guess again: ");
                }
            }


            attempts++;


            if (guess < 1 || guess > 100) {
                System.out.println("Please enter number between 1 and 100.");
                continue;
            }


            if (guess > secretNumber) {

                System.out.println("Too High!");

            }
            else if (guess < secretNumber) {

                System.out.println("Too Low!");

            }
            else {

                System.out.println("Correct! 🎉");
                System.out.println("You guessed it in " + attempts + " attempts.");

                player.increaseScore();
                correct = true;
                break;
            }


            System.out.println("Attempts Left: " + (maxAttempts - attempts));
        }


        if (!correct) {

            System.out.println("\nYou Lost!");
            System.out.println("Correct Number was: " + secretNumber);

        }
    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter your name: ");
        String name = scanner.nextLine();


        Player player = new Player(name);
        NumberGuessingGame game = new NumberGuessingGame();


        String choice;


        do {

            game.startGame(player, scanner);


            System.out.print("\nPlay Again? (yes/no): ");
            choice = scanner.next();


        } while (choice.equalsIgnoreCase("yes"));



        System.out.println("\nPlayer: " + player.getName());
        System.out.println("Total Wins: " + player.getScore());

        System.out.println("Thanks for playing!");

        scanner.close();
    }
}