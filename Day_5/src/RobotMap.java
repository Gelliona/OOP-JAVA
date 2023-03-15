
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class RobotMap {


    private final int n;
    private final int m;

    public final List<Robot> robots;
    private final int robotNumbers;

    public RobotMap(int n, int m) {
        this(n, m, 5);
    }

    public RobotMap(int n, int m, int robotNumbers) {
        validateMap(n, m);
        this.n = n;
        this.m = m;
        this.robotNumbers = robotNumbers;
        this.robots = new ArrayList<>();
    }

    private void validateMap(int n, int m){
        if (n < 0 || m < 0) {
            throw new IllegalStateException("Некоректное значение размера карты!");
        }
    }

      public Robot createRobot(Point point) {
        validatePoint(point);
        validateRobotNumbers(robots, robotNumbers);
        Robot robot = new Robot(point);
        robots.add(robot);
        return robot;
    }

    public void acceptRobots(Consumer<Robot> robotAcceptor){
        for (Robot robot: robots) {
            robotAcceptor.accept(robot);
        }
    }

    public Optional<Robot> getById(Long id) {
        for (Robot robot : robots) {
            if (id.equals(robot.id)) {
                return Optional.of(robot);
            }
        }
        return Optional.empty();
    }

    private void validateRobotNumbers(List<Robot> robots, int robotNumbers) {
        if (robots.size() == robotNumbers) {
            throw new IllegalStateException("Нельзя создать нового робота, допустимое количество превышено!");
        }
    }
    private void validatePoint(Point point) {
        validatePointIsCorrect(point);
        validatePointIsFree(point);
    }
    private void validatePointIsCorrect(Point point) {
        if (point.x() < 1 || point.x() > n || point.y() < 1 || point.y() > m) {
            throw new IllegalStateException("Некоректное значение точки!");
        }
    }
    private void validatePointIsFree(Point point) {
        for (Robot robot : robots) {
            Point robotPoint = robot.point;
            if (robotPoint.equals(point)) {
                throw new IllegalStateException("Точка " + point + " занята!");
            }
        }
    }
    /*
    public boolean delete(Long id) {

        Optional<RobotMap.Robot> robot = this.getById(id);
        if (robot.isPresent()) {
            Robot value = robot.get();
            robots.remove(id);
            return true;
        }
        return false;
    }
*/
    public void deleteRobot(Long id){
        for (Robot robot : robots) {
            if (id.equals(robot.id)) {
                robots.remove(robot);
            }
        }
    }
    public class Robot {

        private static Long idCounter = 1L;

        public static final Direction DEFAULT_DIRECTION = Direction.TOP;
        private final long id;
        private Direction direction;
        private Point point;

        public Robot(Point point) {
            this.direction = DEFAULT_DIRECTION;
            this.point = point;
            this.id = idCounter++;
        }

        public void changeDirection(Direction direction) {
            this.direction = direction;
        }

        public void move(int steps) {
            for (int i = 1; i <= steps; i++) {
                Point newPoint = switch (direction) {
                    case TOP -> new Point(point.x(), point.y() - 1);
                    case RIGHT -> new Point(point.x() + 1, point.y());
                    case BOTTOM -> new Point(point.x(), point.y() + 1);
                    case LEFT -> new Point(point.x() - 1, point.y());
                };
                validatePoint(newPoint);

                System.out.println("Робот[" + id + "] переместился с " + point + " на " + newPoint);
                this.point = newPoint;
            }
        }

        public void move() {
            move(1);
        }


        @Override
        public String toString() {
            return "[" + id + "] " + point.toString() + ", [" + direction.name() + "]";
        }
    }

}
