package set;

import set.Identifiable;

public class Number implements Identifiable {
    private int id;
    private int value;

    public Number(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getID() {
        return id;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Number " + id + ": " + value;
    }

}