package set;
public class Property implements Identifiable {
    private int id;
    private String name;

    public Property(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person " + id + ": " + name;
    }
}
