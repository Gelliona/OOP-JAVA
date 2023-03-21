public class MedicalRobot extends SimpleRobot implements Robot{


    public MedicalRobot(RobotMap map, Long id, Point point) {
        super(map, id, point);
    }

    @Override
    public String toString() {
        return " MedicalRobot[" + this.id + "] " + super.point.toString() + ", [" + this.direction.name() + "]";
    }
}
