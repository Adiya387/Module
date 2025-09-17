package M01Prac1;

public abstract class Vehicle {
    private final String brand;
    private final String model;
    private final int year;
    private boolean engineOn = false;

    protected Vehicle(String brand, String model, int year) {
        if (brand == null || brand.isBlank()) throw new IllegalArgumentException("brand is required");
        if (model == null || model.isBlank()) throw new IllegalArgumentException("model is required");
        if (year < 1886) throw new IllegalArgumentException("year must be >= 1886");
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public boolean isEngineOn() { return engineOn; }

    public void startEngine() {
        if (!engineOn) {
            engineOn = true;
            System.out.printf("%s: Двигатель запущен.%n", label());
        } else {
            System.out.printf("%s: Двигатель уже работает.%n", label());
        }
    }

    public void stopEngine() {
        if (engineOn) {
            engineOn = false;
            System.out.printf("%s: Двигатель остановлен.%n", label());
        } else {
            System.out.printf("%s: Двигатель уже остановлен.%n", label());
        }
    }

    protected String label() {
        return "%s %s (%d)".formatted(brand, model, year);
    }

    @Override
    public String toString() {
        return "%s{brand=%s, model=%s, year=%d, engineOn=%s}"
                .formatted(getClass().getSimpleName(), brand, model, year, engineOn);
    }
}
