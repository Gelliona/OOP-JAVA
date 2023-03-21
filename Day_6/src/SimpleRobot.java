public abstract class SimpleRobot implements Robot{
    RobotMap map;
    public static final Direction DEFAULT_DIRECTION = Direction.TOP;
    public final Long id;
    public Direction direction;
    public Point point;


    public SimpleRobot(RobotMap map, Long id, Point point) {
        this.map = map;
        this.id = id;
        this.direction = DEFAULT_DIRECTION;
        this.point = point;
    }

    @Override
    public void move(int steps) {
        for (int i = 1; i <= steps; i++) {
            Point newPoint = switch (direction) {
                case TOP -> new Point(point.x(), point.y() - 1);
                case RIGHT -> new Point(point.x() + 1, point.y());
                case BOTTOM -> new Point(point.x(), point.y() + 1);
                case LEFT -> new Point(point.x() - 1, point.y());
            };
            map.validatePoint(newPoint);

            System.out.println("Робот[" + id + "] переместился с " + point + " на " + newPoint);
            this.point = newPoint;
        }
    }

    @Override
    public void changeDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public Point getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return " SimpleRobot[" + id + "] " + point.toString() + ", [" + direction.name() + "]";
    }
}
