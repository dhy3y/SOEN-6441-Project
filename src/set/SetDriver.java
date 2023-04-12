package set;

public class SetDriver {
    public static void main(String[] args) {
        Set<Identifiable> mySet = new Set<>();

        // Add some elements to the set
        mySet.add(new Person(1, "Alice"));
        mySet.add(new Person(2, "Bob"));
        mySet.add(new Person(3, "Charlie"));
        mySet.add(new Number(4, 42));
        mySet.add(new Number(5, 13));

        // Display the elements in the set
        System.out.println("My set contains:");
        mySet.display();

        // Remove an element from the set
        System.out.println("Removing element with ID 2");
        mySet.remove(2);

        // Display the updated set
        System.out.println("My set now contains:");
        mySet.display();

        // Test if an element is in the set
        System.out.println("Is there an element with ID 3 in the set? " + mySet.peek(3));
        System.out.println("Is there an element with ID 2 in the set? " + mySet.peek(2));

        // Create a second set with the same elements as the first
        Set<Identifiable> otherSet = new Set<>();
        otherSet.add(new Person(1, "Alice"));
        otherSet.add(new Person(3, "Charlie"));
        otherSet.add(new Number(4, 42));
        otherSet.add(new Number(5, 13));
        otherSet.add(new Person(2, "Bob")); // This element is added in a different order

        // Test if the two sets are equal
        System.out.println("Are the two sets equal? " + mySet.equals(otherSet));
    }
}



