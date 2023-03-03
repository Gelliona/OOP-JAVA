package PegsAndHoles;

public class DefaultSquarePeg implements SquarePeg{
    private final double side;

    public DefaultSquarePeg(double side) {
        this.side = side;
    }

    @Override
    public double getSide(){
        return side;
    }
}
