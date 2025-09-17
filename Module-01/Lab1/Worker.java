package hr;

public class Worker extends Employee {
    private final double hourlyRate;
    private final double hoursWorked;

    public Worker(String name, String employeeId, String position, double hourlyRate, double hoursWorked) {
        super(name, employeeId, position);
        if (hourlyRate < 0) throw new IllegalArgumentException("hourlyRate must be >= 0");
        if (hoursWorked < 0) throw new IllegalArgumentException("hoursWorked must be >= 0");
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}
