package M01Prac1;


public class Motorcycle extends Vehicle {
    private final String bodyType;
    private final boolean hasTopBox;

    public Motorcycle(String brand, String model, int year, String bodyType, boolean hasTopBox) {
        super(brand, model, year);
        if (bodyType == null || bodyType.isBlank()) throw new IllegalArgumentException("bodyType is required");
        this.bodyType = bodyType;
        this.hasTopBox = hasTopBox;
    }

    public String getBodyType() { return bodyType; }
    public boolean hasTopBox() { return hasTopBox; }

    @Override
    public String toString() {
        return super.toString().replace("}", ", bodyType=%s, hasTopBox=%s}".formatted(bodyType, hasTopBox));
    }
}
