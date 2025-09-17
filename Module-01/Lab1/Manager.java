package hr;

public class Manager extends Employee {
    private final double baseSalary;
    private final double bonus;

    public Manager(String name, String employeeId, String position, double baseSalary, double bonus) {
        super(name, employeeId, position);
        if (baseSalary < 0) throw new IllegalArgumentException("baseSalary must be >= 0");
        if (bonus < 0) throw new IllegalArgumentException("bonus must be >= 0");
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}
