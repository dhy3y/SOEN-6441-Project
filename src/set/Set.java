package set;

import java.util.ArrayList;

public class Set<T extends Identifiable> {
    private ArrayList<T> elements;

    public Set() {
        elements = new ArrayList<T>();
    }

    public void addElement(T element) {
        if (!peek(element.getID())) {
            elements.add(element);
        }
    }

    public T removeElement(int id) {
        for (int i = 0; i < elements.size(); i++) {
            T element = elements.get(i);
            if (element.getID() == id) {
                elements.remove(i);
                return element;
            }
        }
        return null;
    }

    public boolean peek(int id) {
        for (T element : elements) {
            if (element.getID() == id) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return elements.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Set)) {
            return false;
        }
        Set<?> other = (Set<?>) obj;
        if (this.size() != other.size()) {
            return false;
        }
        for (T element : elements) {
            if (!other.peek(element.getID())) {
                return false;
            }
        }
        return true;
    }

    public void display() {
        for (T element : elements) {
            System.out.println(element.getID());
        }
    }
}
