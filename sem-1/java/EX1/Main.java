package EX1;
import EX1.employee.Employee;

public class Main {
public static void main(String[] args) {
        Employee emp1 = new Employee(101);
        emp1.setBasicPay(25000);
        emp1.displayInfo();
        System.out.println();
        Employee emp2 = new Employee(102);
        emp2.setBasicPay(30000, 5000); // base + bonus
        emp2.displayInfo();
    }
}