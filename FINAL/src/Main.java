import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        Employee emp1 = new Employee("Иван", "Иванов", "архитектурный", 55130.00);
        empList.add(emp1);
        Employee emp2 = new Employee("Пётр", "Петров", "строительный", 48580.00);
        empList.add(emp2);
        Employee emp3 = new Employee("Семён", "Семёнов", "экономический", 46340.00);
        empList.add(emp3);
        Employee emp4 = new Employee("Иван", "Иванов", "экономический", 43920.00);
        empList.add(emp4);
        Employee emp5 = new Employee("Семён", "Семёнов", "производственный", 47430.00);
        empList.add(emp5);



        findEmployee(emp1, empList);
        findEmployee(emp2, empList);
        findEmployee(emp5, empList);


    }
    public static void findEmployee(Employee employee, List<Employee> employeeList){
        System.out.println("Система ведёт сравнение сотрудника: \n" + employee);

        boolean flag = false;
        for (Employee emp : employeeList) {

            if (emp != employee && emp.equals(employee) && emp.hashCode() == employee.hashCode()) {
                System.out.println("Нашелся сотрудник с таким же именем: \n" + emp);

                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Других совпадений имени не найдено");

        }
        System.out.println("-------------------------------------------------------");
    }
}
