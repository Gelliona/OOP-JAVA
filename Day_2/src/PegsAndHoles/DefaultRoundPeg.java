package PegsAndHoles;

public class DefaultRoundPeg implements RoundPeg {

    private final double radius;

    public DefaultRoundPeg(double radius) {
        this.radius = radius;
    }

    @Override
    public double getRadius(){
        return radius;
    }

}
