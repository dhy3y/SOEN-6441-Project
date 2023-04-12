package set;

import java.util.ArrayList;
import java.util.ArrayList;

public class Set<T extends Identifiable> {
    private ArrayList<T> items;

    public Set() {
        items = new ArrayList<>();
    }

    public void add(T item) {
        if (!peek(item.getID())) {
            items.add(item);
        }
        else {
            System.out.println("item already exist in set !");
        }
    }

    public T remove(int id) {
        for (int i = 0; i < items.size(); i++) {
            T item = items.get(i);
            if (item.getID() == id) {
                items.remove(i);
                return item;
            }
        }

        return null;
    }

    public boolean peek(int id) {
        for (T item : items) {
            if (item.getID() == id) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return items.size();
    }

    public boolean equals(Set<T> otherSet) {
        if (this.size() != otherSet.size()) {
            return false;
        }
        for (T item : items) {
            if (!otherSet.peek(item.getID())) {
                return false;
            }
        }
        return true;
    }

    public void display() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}
