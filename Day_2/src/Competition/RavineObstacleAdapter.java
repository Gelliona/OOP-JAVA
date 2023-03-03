package Competition;

public class RavineObstacleAdapter implements Obstacle{

    private final Ravine ravine;

    public RavineObstacleAdapter(Ravine ravine) {
        this.ravine = ravine;
    }

    @Override
    public boolean pass(Participant participant) {
        return ravine.pass(participant);
    }

    @Override
    public String toString() {
        return "препятствие: " + ravine;
    }

}
