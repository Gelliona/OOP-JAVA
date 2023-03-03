package Competition;

public class Wall {

    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    public boolean pass(CanJump canJump) {
        return canJump.getJump() >= height;
    }

    @Override
    public String toString() {
        return "стена " + height + 'м';
    }
}
