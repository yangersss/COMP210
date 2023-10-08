package PointsSimulation;

public class gptTest {
    // ANSI escape codes for text colors and formatting
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String RED = "\u001B[91m"; // Red for important messages
    private static final String GREEN = "\u001B[92m"; // Green for positive outcomes
    private static final String YELLOW = "\u001B[93m"; // Yellow for warnings
    private static final String BLUE = "\u001B[94m"; // Blue for informational messages
    private static final String MAGENTA = "\u001B[95m"; // Magenta for bet details
    private static final String CYAN = "\u001B[96m"; // Cyan for header

    public static void main(String[] args) {
        /*
        Twitch channel points gaming simulation
        store in csv file to later analyze
        what if you play into the gambler's fallacy?
            but by default, don't
        */
        double points = 200.0d; // starting points
        double bettingPercent = 0.1d; // how much of your total bank do you bet every cycle?

        /*
        Streamer starts poll
        Viewers bet
            generate random win/loss, percentage, and ratio
        dish out the points (or not)
        */
        for (int i = 0; i < 20; i++) {
            points += 20; //we earn points every 10 min and collecting the gift thingy

            double currentlyBetting = points * bettingPercent; //how much we betting?
            double betPercent = 0.25 + (Math.random() * 0.5); //percent who say win
            boolean bettingOn = betPercent < 0.5; //true if we are betting on true, i.e. the side with lower percent
            boolean winLose = Math.random() < 0.5; //did streamer win?
            double ratio = 1 / (bettingOn ? betPercent : 1 - betPercent);

            // Print in color and format
            System.out.println(CYAN + BOLD + "Poll is starting! Will streamer win or lose?" + RESET);
            System.out.println(YELLOW + String.format("%.2f%% say win! %.2f%% say lose!", betPercent * 100, (1 - betPercent) * 100) + RESET);
            System.out.println(BLUE + "We'll win " + GREEN + String.format("%.2f", ratio) + RESET + BLUE + " times the points if we win the bet." + RESET);
            System.out.println(MAGENTA + "We bet on a " + (bettingOn ? GREEN + "win." : RED + "loss.") + RESET);

            points -= currentlyBetting;

            // Color-coded println statements
            System.out.println(GREEN + "We are betting " + Math.round(currentlyBetting) + " points; we have " + Math.round(points) + " points." + RESET);
            System.out.println(RED + "Streamer " + (winLose ? "won!!" : "lost:(") + RESET);
            System.out.println(GREEN + "We " + (bettingOn == winLose ? "won" : "lost") + " the bet." + RESET);

            if (bettingOn == winLose) { //if we won the bet
                points += ratio * currentlyBetting;
            }

            // Color-coded println statement
            System.out.println(MAGENTA + "We have " + Math.round(points) + " points." + RESET);
            System.out.println(); // Add an empty line for better separation
        }

        // test code
        //        for (int i = 0; i < 10; i++) {
        //            System.out.println(percentage());
        //        }
    }
}
