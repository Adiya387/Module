package M01Homework1;

public class Reader {
    private final String name;
    private final String readerId;

    public Reader(String name, String readerId) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
        if (readerId == null || readerId.isBlank()) throw new IllegalArgumentException("readerId is required");
        this.name = name;
        this.readerId = readerId;
    }

    public String getName() { return name; }
    public String getReaderId() { return readerId; }

    @Override
    public String toString() {
        return "Reader{id='%s', name='%s'}".formatted(readerId, name);
    }
}
