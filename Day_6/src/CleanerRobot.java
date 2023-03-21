public class CleanerRobot extends SimpleRobot implements Robot{


    public CleanerRobot(RobotMap map, Long id, Point point) {
        super(map, id, point);
    }

    @Override
    public String toString() {
        return " CleanerRobot[" + this.id + "] " + super.point.toString() + ", [" + this.direction.name() + "]";
    }
}
