package M01Prac1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Fleet fleet = new Fleet("City Fleet");
        Garage g1 = new Garage("Center Garage");
        Garage g2 = new Garage("East Garage");

        fleet.addGarage(g1);
        fleet.addGarage(g2);

        Vehicle c1 = new Car("Toyota", "Camry", 2020, 4, "AT");
        Vehicle c2 = new Car("BMW", "3 Series", 2018, 4, "AT");
        Vehicle m1 = new Motorcycle("Honda", "CB650R", 2022, "naked", false);
        Vehicle m2 = new Motorcycle("BMW", "R1250GS", 2023, "adventure", true);

        g1.addVehicle(c1);
        g1.addVehicle(m1);
        g2.addVehicle(c2);
        g2.addVehicle(m2);

        c1.startEngine();
        m1.startEngine();
        c1.stopEngine();
        m1.stopEngine();

        System.out.println("\n=== Поиск по бренду 'BMW' ===");
        List<Vehicle> bmws = fleet.findByBrand("BMW");
        bmws.forEach(System.out::println);

        System.out.println("\n=== Поиск по диапазону годов 2020..2025 ===");
        List<Vehicle> byYear = fleet.findByYearRange(2020, 2025);
        byYear.forEach(System.out::println);

        System.out.println("\n=== Удаление ТС и гаража ===");
        g1.removeVehicle(m1);  // из первого гаража
        fleet.removeGarage(g2); // из автопарка

        System.out.println("\nСостав автопарка:");
        for (Garage g : fleet.listGarages()) {
            System.out.printf("- %s: %d ТС%n", g.getName(), g.listVehicles().size());
        }
    }
}
