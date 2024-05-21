import java.util.*;

public class Main {
    /**
     * The main game loop
     * @param args
     */
    public static void main(String[] args) {
        // Variables
        int gameScore = 0;
        int gamesAmount = 0;
        int losses = 0;
        int wins = 0;

        // Runs the main menu un till the amount of games has been chosen
        while (gamesAmount == 0) {
            gamesAmount = Menu.mainMenu();
        }

        // Runs the main game
        int[] scoreArray = Main.start(gameScore, gamesAmount, losses, wins);

        // Shows the exit Menu
        Menu.exitMenu(scoreArray[0],scoreArray[2],scoreArray[2]);
    }
    /**
     * Displays and calculates the logic for the game
     * @param gameScore
     * @param gamesAmount
     * @param losses
     * @param wins
     * @return Returns an int array of the final scores
     */
    public static int[] start(int gameScore, int gamesAmount, int losses, int wins) {
        // Loads in other functions
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Score and amount of games variables
        int gamesPlayed = 0;

        // hand options
        String[] rpsOptions = {"rock", "paper", "scissors"}; // Available hand options

        // Sets up the win hash map
        HashMap<String, String> rpsWinOptions = new HashMap<String, String>();
        rpsWinOptions.put("rock", "scissors");
        rpsWinOptions.put("paper", "rock");
        rpsWinOptions.put("scissors", "paper");

        // Runs the RPS game loop
        while(gamesPlayed < gamesAmount) {
            // Sets up the bots hand
            int randomHand = random.nextInt(rpsOptions.length - 0) + 0;
            String botHand = rpsOptions[randomHand];

            // Asks the player for input
            boolean validHand = false;
            System.out.print("\nType here your hand: ");
            String playerHand = scanner.nextLine().toLowerCase();

            // If the hand was invalid, player get in loop un till hand is valid
            while(validHand != true) {
                // Checks if the player hand is in rpsOptions
                validHand = Arrays.stream(rpsOptions).anyMatch(playerHand::equals);

                if (validHand == false) {
                    System.out.print("Invalid hand option, try again: ");
                    playerHand = scanner.nextLine();
                }
            }

            // Checks all the win conditions
            if (rpsWinOptions.containsValue(playerHand)) {
                String losingHand = rpsWinOptions.get(playerHand);
                if (botHand.equals(playerHand)) {
                    System.out.println("its a draw!");
                    gamesPlayed++;
                } else if (botHand.equals(losingHand)) {
                    System.out.println("You won!");
                    gameScore += 100;
                    wins++;
                    gamesPlayed++;
                } else {
                    System.out.println("You lost!");
                    gameScore += -50;
                    losses++;
                    gamesPlayed++;
                }
            }
            System.out.println("BotHand: " + botHand);
        }

        return new int[]{gameScore, losses, wins};
    }


    /**
     * A typewriter for strings in the console, to give the look that the text gets typed
     * @param line
     */
    public static void typeWriter(String line) {
        // Prints out the string
        for (int i = 0; i < line.length();i++) {
            System.out.print(line.charAt(i));

            // Slows the thread by 500 mili seconds
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}