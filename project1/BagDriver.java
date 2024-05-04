package project1;

import java.util.Arrays;

// BagDriver.java
public class BagDriver {
    public static void main(String[] args) {
        BagInterface<String> bag1 = new ResizableArrayBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();

        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");

        BagInterface<String> unionBag = bag1.union(bag2);
        BagInterface<String> intersectionBag = bag1.intersection(bag2);
        BagInterface<String> differenceBag1 = bag1.difference(bag2);
        BagInterface<String> differenceBag2 = bag2.difference(bag1);

        // Demonstrate the usage of union, intersection, and difference
        // This is just an example, output will vary depending on the method implementation
        System.out.println("Union: " + Arrays.toString(unionBag.toArray()));
        System.out.println("Intersection: " + Arrays.toString(intersectionBag.toArray()));
        System.out.println("Difference (bag1 - bag2): " + Arrays.toString(differenceBag1.toArray()));
        System.out.println("Difference (bag2 - bag1): " + Arrays.toString(differenceBag2.toArray()));
    }
}

// ResizableArrayBagTest.java and LinkedBagTest.java
// Left for the user to implement. Test the ResizableArrayBag and LinkedBag functionalities.

