package PegsAndHoles;

public class DefaultRoundHole implements RoundHole{
    private final double radius;

    public DefaultRoundHole(double radius) {
        this.radius = radius;
    }

    @Override
    public double getRadius() {
        return radius;
    }
}
