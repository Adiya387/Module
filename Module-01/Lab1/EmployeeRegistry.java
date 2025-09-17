package hr;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRegistry {
    private final List<Employee> employees = new ArrayList<>();

    public void add(Employee employee) {
        if (employee == null) throw new IllegalArgumentException("employee is null");
        employees.add(employee);
    }

    public List<Employee> list() {
        return List.copyOf(employees);
    }

    public void printPayroll() {
        System.out.println("=== Payroll ===");
        for (Employee e : employees) {
            System.out.printf("%-25s | %-8s | %-14s | salary: %.2f%n",
                    e.getName(), e.getEmployeeId(), e.getPosition(), e.calculateSalary());
        }
    }
}
