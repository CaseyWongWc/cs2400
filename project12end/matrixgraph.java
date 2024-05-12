package project12end;

import java.util.Scanner;

import project2stack.LinkedStack; // Correct these imports based on your project structure
import project2stack.StackInterface;
import project3queue.LinkedQueue;
import project3queue.QueueInterface;
import project9graphs.GraphInterface;

class adjGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices in the graph:");
        int n = scanner.nextInt();
        
        GraphInterface<String> graph = new project9graphs.matrixgraph<>(n);
        
        scanner.nextLine(); // Consume the newline
        
        // Read vertex labels
        System.out.println("Enter the labels for the " + n + " vertices:");
        for (int i = 0; i < n; i++) {
            System.out.print("Label for vertex " + i + ": ");
            String label = scanner.nextLine();
            graph.setLabel(i, label);
        }
        
        // Read edges
        System.out.println("Enter the edges in the format 'sourceIndex targetIndex', one per line:");
        System.out.println("Enter 'done' when finished with edges.");
        while (true) {
            String line = scanner.nextLine();
            if ("done".equalsIgnoreCase(line)) {
                break;
            }
            
            String[] parts = line.split(" ");
            if (parts.length == 2) {
                int source = Integer.parseInt(parts[0]);
                int target = Integer.parseInt(parts[1]);
                graph.addEdge(source, target);
            } else {
                System.out.println("Invalid input format. Please re-enter the edge.");
            }
        }
        
        // Perform operations
        System.out.println("Printing graph:");
        graph.printgraph();
        
        System.out.println("Enter the label of the vertex to perform BFS from:");
        String bfsStart = scanner.nextLine();
        graph.getBreadthFirstTraversal(bfsStart);
        
        System.out.println("Enter the label of the vertex to perform DFS from:");
        String dfsStart = scanner.nextLine();
        graph.getDepthFirstTraversal(dfsStart);
        
        scanner.close(); // Close the scanner
    }
}