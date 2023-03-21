import java.util.*;
import java.util.function.Consumer;

public class RobotGameMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Добро пожаловать! Перед началом игры создайте карту.");
        System.out.println("Введите размеры карты: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        final RobotMap map = new RobotMap(n, m);
        System.out.printf("Успешно создана карта %s x %s\n", n, m);

        final CommandManager manager = new CommandManager(map);
        while (true) {
            System.out.println("""
                    -----------------------------------------------------------------------------
                    Доступные действия:
                    1. Для создания робота введите create type x y, где type - одно из значений {S, P, C}, x и y - координаты размещения
                    2. Для вывода списка всех созданных роботов введите list
                    3. Для перемещения робота введите move id step, где id - идентификатор робота, step - количество шагов
                    4. Для изменения направления введите changedir id DIRECTION, где id - идентификатор робота, DIRECTION  - одно из значений {TOP, RIGHT, BOTTOM, LEFT}
                    5. Для удаления робота введите delete id, где id - идентификатор робота
                    6. Для выхода введите exit
                                     
                    ...список будет пополняться
                    -----------------------------------------------------------------------------
                    """);

            String command = sc.nextLine();
            manager.acceptCommand(command);


        }
    }

    private static class CommandManager{
        private final RobotMap map;
        private final List<CommandHandler> handlers;
        public CommandManager(RobotMap map) {
            this.map = map;
            handlers = new ArrayList<>();
            initHandlers();
        }

        private void initHandlers(){
            initCreateCommandHandler();
            initListCommandHandler();
            initMoveCommandHandler();
            initChangeDirCommandHandler();
            initDeleteCommandHandler();
            initExitCommandHandler();

        }

        private void initCreateCommandHandler(){
            handlers.add(new CommandHandler(){

                @Override
                public String name() {
                    return "create";
                }
                @Override
                public void runCommand(String[] args) {
                    int x = Integer.parseInt(args[1]);
                    int y = Integer.parseInt(args[2]);
                    String robotType = args[0];
                    Robot robot = map.createRobot(robotType, new Point(x, y));
                    System.out.println("Робот" + robot + " успешно создан");
                }

            });
        }
        private void initListCommandHandler(){
            handlers.add(new CommandHandler() {

                @Override
                public String name() {
                    return "list";
                }

                @Override
                public void runCommand(String[] args) {
                /*
                map.acceptRobots(new Consumer<RobotMap.Robot>() {
                    @Override
                    public void accept(RobotMap.Robot robot) {
                        System.out.println(robot);
                    }
                });             написанное выше можно свернуть в более лаконичный код, как на следующей строчке
                */
                    map.acceptRobots(System.out::println);   // ссылка на метод
                }
            });
        }
        private void initMoveCommandHandler(){
            handlers.add(new CommandHandler(){

                @Override
                public String name() {
                    return "move";
                }
                @Override
                public void runCommand(String[] args) {
                    Long robotId = Long.parseLong(args[0]);
                    Optional<Robot> robot = map.getById(robotId);
                    int step = Integer.parseInt(args[1]);
                   // robot.ifPresentOrElse(Robot::move, () -> System.out.println("Робот" + robotId + " не найден"));

                    robot.ifPresentOrElse(robot1 -> robot1.move(step), () -> System.out.println("Робот[" + robotId + "] не найден"));
/*
                    robot.ifPresentOrElse(new Consumer<Robot>() {
                        @Override
                        public void accept(Robot robot) {
                            robot.move(step);
                        }
                    }, new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Робот" + robotId + " не найден");
                        }
                    });
*/
                }
            });
        }
        private void initChangeDirCommandHandler(){
            handlers.add(new CommandHandler(){

                @Override
                public String name() {
                    return "changedir";
                }
                @Override
                public void runCommand(String[] args) {
                    Long robotId = Long.parseLong(args[0]);
                    Direction robotDirection = Direction.fromString(args[1].toUpperCase());
                    Optional<Robot> robot = map.getById(robotId);
                    robot.ifPresentOrElse(new Consumer<Robot>() {
                        @Override
                        public void accept(Robot robot) {
                           robot.changeDirection(robotDirection);
                           System.out.println("Робот" + robotId + " изменил направление на " + robotDirection);
                        }
                    }, new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Робот" + robotId + " не найден");
                        }
                    });

                }

            });
        }
        private void initDeleteCommandHandler(){
            handlers.add(new CommandHandler(){

                @Override
                public String name() {
                    return "delete";
                }
                @Override
                public void runCommand(String[] args) {
                    Long robotId = Long.parseLong(args[0]);
                    Optional<Robot> robot = map.getById(robotId);
                    robot.ifPresentOrElse(new Consumer<Robot>() {
                        @Override
                        public void accept(Robot robot) {
                            map.deleteRobot(robotId);
                            System.out.println("Робот[" + robotId + "] успешно удалён");
                        }
                    }, new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Робот[" + robotId + "] не найден");
                        }
                    });
                //    System.out.println("Робот[" + robotId + "] успешно удалён");
                }

            });
        }
        private void initExitCommandHandler(){
            handlers.add(new CommandHandler(){

                @Override
                public String name() {
                    return "exit";
                }
                @Override
                public void runCommand(String[] args) {
                    System.out.println("Всего хорошего!");
                    System.exit(0);
                }

            });
        }

        public void acceptCommand(String command) {
            String[] split = command.split(" ");
            String commandName = split[0];
            String[] commandArgs = Arrays.copyOfRange(split, 1, split.length);

            boolean found = false;
            for (CommandHandler handler : handlers) {
                if (commandName.equals(handler.name())) {
                    found = true;
                    try {
                        handler.runCommand(commandArgs);
                    } catch (Exception e) {
                        System.err.println("Во время обработки команды " + commandName + " произошла ошибка: " + e.getMessage());
                    }
                }
            }
            if (!found){
                System.out.println("Команда не найдена");
            }
        }

        private interface CommandHandler{
            String name();
            void runCommand(String[] args);
        }
    }

}


