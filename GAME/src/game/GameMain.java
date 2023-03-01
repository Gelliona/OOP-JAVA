package game;

public class GameMain {

    public static void main(String[] args) {
        // Карта с роботами.
        // Карта имеет nxm, где n и m - положительные целые числа.
        // Должна быть возможность создания робота на какой-то точке на карте.
        // Точка на карте описывается двумя целочисленными координатами.
        // Роботы могут перемещаться по карте вперед.
        // В одной точке не может находиться несколько роботов.

        // HOMEWORK
        // 0. Разобраться с проектом. Подготовить вопросы к следующему семинару, если возникнут.
        // 1. Добавить валидацию параметров при создании карты
        // 2. Реализовать возможность задать ограничение по количеству создаваемых
        // на карте роботов (в конструкторе карты)
        // При этом если параметр не указан, то используем значение по-умолчанию: 5
        // 3*. Реализовать возможность вызова метода move с параметром - количество шагов вперед
        // Подсказка: можно несколько раз вызвать метод #move

        /*
           1 2 3 4 5
         1 * * * * *
         2 * * * * *
         3 * * * * *
         4 * * * * *
         5 * * * * *
        */

        RobotMap map = new RobotMap(5, 5, 3);

        RobotMap.Robot robot = map.createRobot(new Point(3, 4));
        System.out.println(robot); // [3, 4], [TOP]
        robot.move(2); // [3, 2], [TOP]
        robot.changeDirection(Direction.BOTTOM);
        robot.move(3);
        robot.changeDirection(Direction.LEFT);
        robot.move();
        System.out.println("robot - " + robot); // [2, 5], [LEFT]
        RobotMap.Robot robot1 = map.createRobot(new Point(4, 2));
        System.out.println("robot1 - " + robot1); // [4, 2], [TOP]
        RobotMap.Robot robot2 = map.createRobot(new Point(4, 4));
        System.out.println("robot2 - " + robot2); // [4, 4], [TOP]
        robot2.move(3);



    }

}
