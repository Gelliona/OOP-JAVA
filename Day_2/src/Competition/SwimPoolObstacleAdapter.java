package Competition;

public class SwimPoolObstacleAdapter implements Obstacle{
    private final SwimmingPoll swimmingPoll;

    public SwimPoolObstacleAdapter(SwimmingPoll swimmingPoll) {
        this.swimmingPoll = swimmingPoll;
    }

    @Override
    public boolean pass(Participant participant) {
        return swimmingPoll.pass(participant);
    }

    @Override
    public String toString() {
        return "препятствие: " + swimmingPoll;
    }
}
