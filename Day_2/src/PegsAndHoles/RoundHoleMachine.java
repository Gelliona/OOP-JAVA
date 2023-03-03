package PegsAndHoles;

public class RoundHoleMachine {

    public RoundHole makeHole(RoundPeg roundPeg) {
        double radius = roundPeg.getRadius();
        return new DefaultRoundHole(radius);
    }
}
