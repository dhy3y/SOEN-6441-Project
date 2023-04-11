package set;

// Identifiable implementations for testing
class IntegerIdentifiable implements Identifiable {
    private int id;

    public IntegerIdentifiable(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
}
