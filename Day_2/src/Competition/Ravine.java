package Competition;

public class Ravine {
    private final int width;

    public Ravine(int width) {
        this.width = width;
    }

    public boolean pass(CanLongJump canLongJump) {
        return canLongJump.getLongJump() >= width;
    }

    @Override
    public String toString() {
        return "овраг " + width + 'м';
    }
}
