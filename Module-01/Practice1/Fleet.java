package M01Prac1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Fleet {
    private final String name;
    private final List<Garage> garages = new ArrayList<>();

    public Fleet(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
        this.name = name;
    }

    public String getName() { return name; }

    public void addGarage(Garage g) {
        if (g == null) throw new IllegalArgumentException("garage is null");
        garages.add(g);
        System.out.printf("Автопарк '%s': добавлен гараж '%s'%n", name, g.getName());
    }

    public boolean removeGarage(Garage g) {
        boolean removed = garages.remove(g);
        System.out.printf("Автопарк '%s': гараж '%s' %s%n",
                name, g.getName(), removed ? "удален" : "не найден");
        return removed;
    }

    public List<Garage> listGarages() { return List.copyOf(garages); }

    public List<Vehicle> findVehicles(Predicate<Vehicle> filter) {
        List<Vehicle> result = new ArrayList<>();
        for (Garage g : garages) {
            for (Vehicle v : g.listVehicles()) {
                if (filter.test(v)) result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> findByBrand(String brand) {
        return findVehicles(v -> v.getBrand().equalsIgnoreCase(brand));
    }

    public List<Vehicle> findByYearRange(int fromInclusive, int toInclusive) {
        return findVehicles(v -> v.getYear() >= fromInclusive && v.getYear() <= toInclusive);
    }

    @Override
    public String toString() {
        return "Fleet{name='%s', garages=%d}".formatted(name, garages.size());
    }
}
