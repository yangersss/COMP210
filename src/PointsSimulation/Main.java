package PointsSimulation;

public class Main {
    public static void main (String[] args){
        /* Channel points gaming simulation
        * store in csv file to later analyze
        * what if you play into the gambler's fallacy?
        *   but by default, don't
        *
        * */
    }
    public static boolean flip(){
        return (Math.random() < 0.5);
    }
    public static float percentage(){
        return (Math.random());
    }
    public static float ratio(float p){
        return 1/p;
    }
}
