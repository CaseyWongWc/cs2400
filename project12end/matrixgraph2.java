package project12end;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//import java.util.Iterator;
import java.util.Set;
//import java.util.Vector;
import java.util.Scanner;

import project2stack.LinkedStack;
import project2stack.StackInterface;
import project3queue.LinkedQueue;
import project3queue.QueueInterface;
import project9graphs.GraphInterface;

public class matrixgraph2<E> implements GraphInterface <E>
{
    private boolean [] [] edges;
    private E[] labels;

    
    @SuppressWarnings("unchecked")
    public matrixgraph2(int n)
    {
        //labels.length = n;
        edges = new boolean[n+1][n+1];
        labels = (E[]) new Object[n+1];
    }

    @Override
    public boolean isEdge(int source, int target) 
    {
        return edges[source][target];
    }

    @Override
    public boolean addEdge(int source, int target) 
    {
        return edges[source][target] = true;
    }


    @Override
    public E getLabel(int vertex) 
    {
        if (labels[vertex] == null)
        {
            getLabel2(vertex);
        }
        return labels[vertex];
    }
    private int getLabel2(int vertex) 
    {
        return vertex;
    }

    @Override
    public int[] neighbors(int vertex) 
    {
    List<Integer> neighborList = new ArrayList<>();
    // Assuming the first vertex starts at 1 and labels array includes an element at index 0 which might not be used.
    for (int i = 1; i < labels.length; i++) 
    {
        if (edges[vertex][i]) 
        {
            neighborList.add(i);
        }
    }

    int[] neighbors = new int[neighborList.size()];
    int count = 0;
    System.out.print(neighborList.size() + " neighbors of " + getLabel(vertex) + ": ");
    for (Integer neighbor : neighborList) 
    {
        neighbors[count++] = neighbor;
        System.out.print(getLabel(neighbor) + ",");
    }
    System.out.println();
    return neighbors;
}


    @Override
    public void removeEdge(int source, int target) 
    {
        edges[source][target]=false;
    }

    @Override
    public void setLabel(int vertex, E newLabel) 
    {
        labels[vertex] = newLabel;
    }

    @Override
    public int size() 
    {   
        return labels.length;
    }
    
    private int getindex(E label)
    {
        int  theothervertices = labels.length-1;
        int index=1;
        for (int i= 1; i < theothervertices;i++)
        {
            if (labels[i] == label)
            {
                index = i;
            }
        }
        
        return index;
    }
    @Override
public QueueInterface<E> getBreadthFirstTraversal(E origin) {
    System.out.println("BFS:");
    Set<E> visited = new HashSet<>(); // Tracks visited vertices

    QueueInterface<E> traversalOrder = new LinkedQueue<>();
    QueueInterface<E> vertexQueue = new LinkedQueue<>();

    vertexQueue.enqueue(origin);

    while (!vertexQueue.isEmpty()) 
    {
        E currentVertex = vertexQueue.dequeue();
        if (!visited.contains(currentVertex))
         {
            visited.add(currentVertex); // Mark the vertex as visited
            traversalOrder.enqueue(currentVertex); // Store the visited vertex

            int[] neighbors = neighbors(getindex(currentVertex));
            for (int neighborIndex : neighbors) 
            {
                E neighborLabel = getLabel(neighborIndex);
                if (!visited.contains(neighborLabel)) 
                {
                    vertexQueue.enqueue(neighborLabel);
                }
            }
        }
    }

    System.out.print("BreadthFirstTraversal: ");
    traversalOrder.printQueue();

    return traversalOrder;
}

    
    @Override
    public QueueInterface<E> getDepthFirstTraversal(E origin) 
    {
    System.out.println("DFS:");
    Set<E> visited = new HashSet<>();

    QueueInterface<E> traversalOrder = new LinkedQueue<>();
    StackInterface<E> vertexStack = new LinkedStack<>();

    vertexStack.push(origin);
    while (!vertexStack.isEmpty()) 
    {
        E topVertex = vertexStack.pop();

        if (!visited.contains(topVertex)) 
        {
            visited.add(topVertex); // Mark the vertex as visited here
            traversalOrder.enqueue(topVertex); // Store the visited vertex
            
            // Fetch the neighbors of the current vertex
            int[] neighbors = neighbors(getindex(topVertex)); 
            for (int i = neighbors.length-1; i >= 0; i--) 
            { 
                // Iterate in reverse to maintain correct DFS order
                E neighborLabel = getLabel(neighbors[i]);
                if (!visited.contains(neighborLabel)) 
                {
                    vertexStack.push(neighborLabel); // Push unvisited neighbors
                }
            }
        }
    }
    System.out.print("DepthFirstTraversal: ");
    traversalOrder.printQueue();
    return traversalOrder;
}


    public void printgraph() 
    {
        System.out.print("\t");
        for (int i = 1; i < labels.length; i++) 
        {
            System.out.print(getLabel(i)+"\t");
        }
        System.out.println();
        for (int i = 1; i < labels.length; i++) 
        {
            System.out.print(getLabel(i)+"\t");
        for (int j = 1; j < labels.length; j++) 
        {

            System.out.print(edges[i][j] + "\t");
        }
        System.out.println();
        }
    }


    
}

class adjGraph
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices in the graph:");
        int n = scanner.nextInt();
        
        GraphInterface<String> graph = new matrixgraph2<>(n);
        
        scanner.nextLine(); // Consume the newline
        
        // Read vertex labels
        System.out.println("Enter the labels for the " + n + " vertices:");
        for (int i = 1; i < graph.size(); i++) {
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


// GraphInterface<String> sample = new matrixgraph2<>(9);

// sample.setLabel(1, "A");
// sample.setLabel(2, "B");
// sample.setLabel(3, "C");
// sample.setLabel(4, "D");
// sample.setLabel(5, "E");
// sample.setLabel(6, "F");
// sample.setLabel(7, "G");
// sample.setLabel(8, "H");
// sample.setLabel(9, "I");

// sample.addEdge(1, 2);sample.addEdge(3, 4);sample.addEdge(1, 5);
// sample.addEdge(2, 5);
// sample.addEdge(3, 2);
// sample.addEdge(4, 7);
// sample.addEdge(5, 6);sample.addEdge(5, 8);
// sample.addEdge(6, 3);sample.addEdge(6, 8);
// sample.addEdge(7, 8);
// sample.addEdge(8, 9);
// sample.addEdge(9, 1);
// sample.printgraph();
// sample.getBreadthFirstTraversal("A");
// sample.getDepthFirstTraversal("A");