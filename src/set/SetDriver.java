package set;

public class SetDriver {
    public static void main(String[] args) {
        // create a set of integers using the IntegerSet implementation
        Set<IntegerIdentifiable> IntegerSet = new Set<IntegerIdentifiable>();

        // add some elements to the set
        IntegerSet.addElement(new IntegerIdentifiable(1));
        IntegerSet.addElement(new IntegerIdentifiable(2));
        IntegerSet.addElement(new IntegerIdentifiable(3));

        // display the set
        System.out.println("IntegerSet:");
        IntegerSet.display();

        // remove an element from the set
        IntegerSet.removeElement(2);

        // display the set again
        System.out.println("IntegerSet after removing element with ID 2:");
        IntegerSet.display();

        // create a set of strings using the StringSet1 implementation
        Set<StringIdentifiable> StringSet1 = new Set<StringIdentifiable>();

        // add some elements to the set
        StringSet1.addElement(new StringIdentifiable("hello"));
        StringSet1.addElement(new StringIdentifiable("world"));
        StringSet1.addElement(new StringIdentifiable("java"));

        // display the set
        System.out.println("StringSet1:");
        StringSet1.display();

        // remove an element from the set
        StringSet1.removeElement(2);

        // display the set again
        System.out.println("StringSet1 after removing element with ID 2:");
        StringSet1.display();

        // test equality between sets
        Set<IntegerIdentifiable> IntegerSet2 = new Set<IntegerIdentifiable>();
        IntegerSet2.addElement(new IntegerIdentifiable(1));
        IntegerSet2.addElement(new IntegerIdentifiable(3));
        System.out.println("IntegerSet equals IntegerSet2? " + IntegerSet.equals(IntegerSet2));

        Set<StringIdentifiable> StringSet2 = new Set<StringIdentifiable>();
        StringSet2.addElement(new StringIdentifiable("hello"));
        StringSet2.addElement(new StringIdentifiable("java"));
        System.out.println("StringSet1 equals StringSet2? " + StringSet1.equals(StringSet2));
    }
}


