package hr;

public class Main {
    public static void main(String[] args) {
        EmployeeRegistry registry = new EmployeeRegistry();

        Employee w1 = new Worker("Иван Петров", "W001", "Слесарь", 2500.0, 160);
        Employee w2 = new Worker("Марина Орлова", "W002", "Оператор", 2200.0, 120);

        Employee m1 = new Manager("Алина Ш.", "M001", "Менеджер отдела", 600000.0, 80000.0);
        Employee m2 = new Manager("Руслан Б.", "M002", "Руководитель проекта", 900000.0, 150000.0);

        registry.add(w1);
        registry.add(w2);
        registry.add(m1);
        registry.add(m2);

        registry.printPayroll();
    }
}
