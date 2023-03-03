package PegsAndHoles;

public class SquarePegAdapter implements RoundPeg{

    private final SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius() {

        return squarePeg.getSide()/Math.sqrt(2);  //Радиус описанной возле квадрата окружности: R = a/√2
    }
}
