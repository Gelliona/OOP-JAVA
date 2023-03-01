package game;

import java.util.ArrayList;
import java.util.List;

public class RobotMap {

    private final int n;
    private final int m;

    public final List<Robot> robots;
    private final int robotNumbers;

    public RobotMap(int n, int m) {
        validateMap(n, m);
        this.n = n;
        this.m = m;
        this.robotNumbers = 5;
        this.robots = new ArrayList<>();
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

    public class Robot {

        public static final Direction DEFAULT_DIRECTION = Direction.TOP;

        private Direction direction;
        private Point point;

        public Robot(Point point) {
            this.direction = DEFAULT_DIRECTION;
            this.point = point;
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

                System.out.println("Робот переместился с " + point + " на " + newPoint);
                this.point = newPoint;
            }
        }

        public void move() {
            move(1);
        }


        @Override
        public String toString() {
            return point.toString() + ", [" + direction.name() + "]";
        }
    }

}
