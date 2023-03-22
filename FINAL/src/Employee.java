import java.util.Objects;

public class Employee {
    String firstName;
    String lastName;
    String department;
    Double salary;

    public Employee(String firstName, String lastName, String department, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }



    public boolean equals(Employee employee) {
        return this.firstName.equals(employee.firstName) && this.lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.firstName, this.lastName);
    }

    @Override
    public String toString() {
        return "Cотрудник " + lastName + " " + firstName + ", отдел " + department + ", зарплата " + salary;
    }

}
