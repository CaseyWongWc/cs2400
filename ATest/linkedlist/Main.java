package ATest.linkedlist;

import java.util.LinkedList;

public class Main { 
  public static void main(String[] args) { 
    LinkedList<String> cars = new LinkedList<String>();
    /*cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");*/

    cars.add("horse");System.out.println(cars);
    cars.add("goat");System.out.println(cars);
    cars.add(1,"Fish");System.out.println(cars);
    cars.add("cat");System.out.println(cars);
    cars.remove(1);System.out.println(cars);
    cars.add(2,"dog");System.out.println(cars);

    //cars.addFirst("Mazda");
    //cars.removeFirst();
    //cars.addLast("Mazda");
    //cars.removeLast();
    //System.out.println(cars.getFirst());
    //System.out.println(cars.getLast());
    System.out.println(cars);
  } 
}

