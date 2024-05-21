import java.util.Scanner;
/**
* Returns the main menu of the game
*/
public class Menu {
    /**
    * Displays title of the game and askes for the amount of games to play
    */
    public static Integer mainMenu() {
        Scanner scanner = new Scanner(System.in);

        // Variables
        String title = "8o====Rock, Papers, Scissors====o8";
        int amountGames = 0;

        // Prints out the title
        Main.typeWriter(title);

        // Asks for input
        Main.typeWriter("\n Please select how many games you want to play: ");
        try {
            amountGames = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("invalid input!!\n");
        }

        return amountGames;
    }

    /**
    * Displays the exit meny with amount of games played and the score of the player
    */
    public static void exitMenu(int points, int losses, int wins) {
        // Displays exitMenu title
        Main.typeWriter("\n8o=====Game has ended=====o8");

        // "Calculates" the score, and waits for 2 seconds
        Main.typeWriter("\n\nCalculation Score:");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        // Displays the game result
        if (wins > losses) {
            Main.typeWriter("\n8o=====You won the game!!=====o8\n");
        } else if (wins == losses) {
            Main.typeWriter("\n8o=====It's a draw!!=====o8\n");
        } else {
            Main.typeWriter("\n8o=====You lost=====o8\n");
        }

        // Final results
        Main.typeWriter("\nTotal score: " + points);
        Main.typeWriter("\nAmounts of wins: " + wins);
        Main.typeWriter("\nAmounts of losses: " + losses);
    }
}
