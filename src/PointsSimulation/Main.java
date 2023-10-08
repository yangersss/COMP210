package PointsSimulation;

public class Main {
    public static void main (String[] args){
        /*
        Twitch channel points gaming simulation
        store in csv file to later analyze
        what if you play into the gambler's fallacy?
            but by default, don't
        */
        double points = 200.0d; // starting points
        double bettingPercent = 0.05d; // how much of your total bank do you bet every cycle?

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
            double ratio = 1 / (Math.min(betPercent, 1 - betPercent));

            System.out.println("Poll is starting! Will streamer win or lose?");
            System.out.println(String.format("%.2f%% say win! %.2f%% say lose!", betPercent * 100, (1 - betPercent) * 100));
            System.out.println("We'll win " + String.format("%.2f", ratio) + " times the points if we win the bet.");
            System.out.println("We bet on a " + (bettingOn ? "win." : "loss."));

            points -= currentlyBetting;

            System.out.println("We are betting " + Math.round(currentlyBetting) + " points; we have " + Math.round(points) + " points.");
            System.out.println("Streamer " + (winLose ? "won!!" : "lost:("));
            System.out.println("We " + (bettingOn == winLose ? "won" : "lost") + " the bet.");

            if (bettingOn == winLose){ //if we won the bet
                points += ratio * currentlyBetting;
            }

            System.out.println("We have " + Math.round(points) + " points.");
        }

        //test code
//        for (int i = 0; i < 10; i++) {
//            System.out.println(percentage());
//        }
    }
}
