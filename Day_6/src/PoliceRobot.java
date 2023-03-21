public class PoliceRobot extends SimpleRobot implements Robot{


    public PoliceRobot(RobotMap map, Long id, Point point) {
        super(map, id, point);
    }

    @Override
    public String toString() {
        return " PoliceRobot[" + this.id + "] " + super.point.toString() + ", [" + this.direction.name() + "]";
    }
}
