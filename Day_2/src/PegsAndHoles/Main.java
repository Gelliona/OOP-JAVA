package PegsAndHoles;

public class Main {
    public static void main(String[] args) {

        RoundHoleMachine myMachine = new RoundHoleMachine();

        RoundPeg roundPeg = new DefaultRoundPeg(4);
        RoundHole roundHole = myMachine.makeHole(roundPeg);
        System.out.printf("Радиус отверстия = %.1f\n", roundHole.getRadius());

        SquarePeg squarePeg = new DefaultSquarePeg(6);
        RoundHole roundHole1 = myMachine.makeHole(new SquarePegAdapter(squarePeg));
        System.out.printf("Радиус отверстия = %.3f\n",roundHole1.getRadius());

    }
}
