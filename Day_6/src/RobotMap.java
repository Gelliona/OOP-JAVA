
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class RobotMap {


    private final int n;
    private final int m;

    public final List<Robot> robots;
    private final int robotNumbers;
    private static Long idCounter = 1L;

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

      public Robot createRobot(String robotType, Point point) {
        validatePoint(point);
        validateRobotNumbers(robots, robotNumbers);

        if (robotType.toUpperCase().equals("M")){
            Robot robot = new MedicalRobot(this, idCounter++, point);
            robots.add(robot);
            return robot;
        } else if (robotType.toUpperCase().equals("P")) {
            Robot robot = new PoliceRobot(this, idCounter++, point);
            robots.add(robot);
            return robot;
        } else if (robotType.toUpperCase().equals("C")) {
            Robot robot = new CleanerRobot(this, idCounter++, point);
            robots.add(robot);
            return robot;
        }  else {
            throw new IllegalStateException("Неверный тип робота!");
        }

    }

    public void acceptRobots(Consumer<Robot> robotAcceptor){
        for (Robot robot: robots) {
            robotAcceptor.accept(robot);
        }
    }

    public Optional<Robot> getById(Long id) {
        for (Robot robot : robots) {
            if (id.equals(robot.getId())) {
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
    public void validatePoint(Point point) {
        validatePointIsCorrect(point);
        validatePointIsFree(point);
    }
    public void validatePointIsCorrect(Point point) {
        if (point.x() < 1 || point.x() > n || point.y() < 1 || point.y() > m) {
            throw new IllegalStateException("Некоректное значение точки!");
        }
    }
    public void validatePointIsFree(Point point) {
        for (Robot robot : robots) {
            Point robotPoint = robot.getPoint();
            if (robotPoint.equals(point)) {
                throw new IllegalStateException("Точка " + point + " занята!");
            }
        }
    }

    public void deleteRobot(Long id) {

        Optional<Robot> robot = this.getById(id);
        if (robot.isPresent()) {
            Robot deletedRobot = robot.get();
            robots.remove(deletedRobot);

        }

    }


}
