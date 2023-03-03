package Competition;

public class SwimmingPoll implements Obstacle {

    private final int distance;

    public SwimmingPoll(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean pass(Participant participant) {
        return participant.getSwim() >= distance;
    }

    @Override
    public String toString() {
        return "бассейн " + distance + 'м';
    }
}
