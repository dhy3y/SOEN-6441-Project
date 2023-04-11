package set;

class StringIdentifiable implements Identifiable {
    private String id;

    public StringIdentifiable(String id) {
        this.id = id;
    }

    public int getID() {
        return id.hashCode();
    }
}