package M01Prac1;

public class Car extends Vehicle {
    private final int doors;
    private final String transmission;

    public Car(String brand, String model, int year, int doors, String transmission) {
        super(brand, model, year);
        if (doors <= 0) throw new IllegalArgumentException("doors must be > 0");
        if (transmission == null || transmission.isBlank()) throw new IllegalArgumentException("transmission is required");
        this.doors = doors;
        this.transmission = transmission;
    }

    public int getDoors() { return doors; }
    public String getTransmission() { return transmission; }

    @Override
    public String toString() {
        return super.toString().replace("}", ", doors=%d, transmission=%s}".formatted(doors, transmission));
    }
}
