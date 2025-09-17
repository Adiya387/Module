package hr;

public abstract class Employee {
    private final String name;
    private final String employeeId;
    private final String position;

    protected Employee(String name, String employeeId, String position) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
        if (employeeId == null || employeeId.isBlank()) throw new IllegalArgumentException("employeeId is required");
        if (position == null || position.isBlank()) throw new IllegalArgumentException("position is required");
        this.name = name;
        this.employeeId = employeeId;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getPosition() {
        return position;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "%s{id=%s, name=%s, position=%s}".formatted(
                this.getClass().getSimpleName(), employeeId, name, position
        );
    }
}
