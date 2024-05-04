package project2stack;

import java.util.ArrayList;
import java.util.Collections;

//import java.util.Arrays;
//import java.util.Stack;

public class demostack 
{
public static void main(String[] args) 
    {
       


        /*StackInterface<String> stack1 = new LinkedStack<>();
        
        //stack1.push("cabbage");
        String[] array1 = { "cabbage", "carrot", "apple"};
        stack1 = toStack(array1);

        System.out.println(stack1.peek());
        
        stack1.push("pear");
        System.out.println(stack1.peek());

        stack1.push("bannana");
        System.out.println(stack1.peek());

        stack1.pop();
        System.out.println(stack1.peek());

        
        printStack(stack1);*/
        //////////////////////// reverse chronological order
        StackInterface<String> stack2 = new ArrayStack<>();
        stack2.push("a");System.out.println("push: "+stack2.peek());
        stack2.push("b");System.out.println("push: "+stack2.peek());
        System.out.println("pop: "+stack2.peek()); stack2.pop();
        stack2.push("d");System.out.println("push: "+stack2.peek());
        stack2.push("e");System.out.println("push: "+stack2.peek());

        printStack(stack2);

        

    }
    
    private static  StackInterface<String> toStack(String[] content)
    {
        StackInterface<String> aStack = new LinkedStack<>();
        for (int i=0; i < content.length;i++)
        {   
            aStack.push(content[i]);
            System.out.print(aStack.peek() + " ");
        }
        System.out.println();
        return aStack;
    }


    //helper
private static void printStack(StackInterface<String> stack) {
    StackInterface<String> tempStack = new LinkedStack<>();
    System.out.println("============");
    System.out.println("Stack contents from top to bottom: (reverse chronological order)");

    // Move elements to the temporary stack
    while (!stack.isEmpty()) {
        tempStack.push(stack.pop());
    }

    // Restore the original stack's state and prepare for printing
    ArrayList<String> printOrder = new ArrayList<>();
    while (!tempStack.isEmpty()) {
        String item = tempStack.pop();
        printOrder.add(item);  // Add to print order
        stack.push(item);  // Restore original stack
    }

    // Print in correct order
    Collections.reverse(printOrder);  // Reverse to maintain the push order
    printOrder.forEach(item -> System.out.print(item + ","));
    System.out.println();
}

}
