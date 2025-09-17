package M01Prac1;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private final String name;
    private final List<Vehicle> vehicles = new ArrayList<>();

    public Garage(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
        this.name = name;
    }

    public String getName() { return name; }

    public void addVehicle(Vehicle v) {
        if (v == null) throw new IllegalArgumentException("vehicle is null");
        vehicles.add(v);
        System.out.printf("Гараж '%s': добавлено %s%n", name, v);
    }

    public boolean removeVehicle(Vehicle v) {
        boolean removed = vehicles.remove(v);
        System.out.printf("Гараж '%s': %s %s%n", name, removed ? "удалено" : "не найдено", v);
        return removed;
    }

    public List<Vehicle> listVehicles() {
        return List.copyOf(vehicles);
    }

    @Override
    public String toString() {
        return "Garage{name='%s', vehicles=%d}".formatted(name, vehicles.size());
    }
}
