package project12end;
import java.util.HashSet;
//import java.util.Iterator;
import java.util.Set;
//import java.util.Vector;
import java.util.Scanner;

import project2stack.LinkedStack;
import project2stack.StackInterface;
import project3queue.LinkedQueue;
import project3queue.QueueInterface;
import project9graphs.GraphInterface;

public class matrixgraph<E> implements GraphInterface <E>
{
    private boolean [] [] edges;
    private E[] labels;
    
    @SuppressWarnings("unchecked")
    public matrixgraph(int n)
    {
        //labels.length = n;
        edges = new boolean[n][n];
        labels = (E[]) new Object[n];
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
        int i=0;
        int count =0;
        int[] answer;

        for (i=0; i < labels.length;i++)
        {
            if (edges[vertex][i])
            {
                count++;
            }
        }


        answer = new int[count];
        count =0;

        System.out.print("neighbors of " + getLabel(vertex) + ": " );        
        for (i=0; i < labels.length;i++)
        {
            if (edges[vertex][i])
            {
                answer[count++] =i;
                System.out.print(getLabel(i) + ",");
            }
        }
        System.out.println();
        return answer;
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
        int index=0;
        for (int i= 0; i < labels.length;i++)
        {
            if (labels[i] == label)
            {
                index = i;
            }
        }
        
        return index;
    }
    @Override
   

    public QueueInterface<E> getBreadthFirstTraversal(E origin) 
    {System.out.println("BFS:");
        Set<E> visited = new HashSet<>(); // Tracks visited vertices
        
        QueueInterface<E> traversalOrder = new LinkedQueue<>();
        QueueInterface<E> vertexQueue = new LinkedQueue<>();

        vertexQueue.enqueue(origin);

        while (!vertexQueue.isEmpty()) 
        {
            E currentvertex = vertexQueue.dequeue();
            if (!visited.contains(currentvertex)) 
            {
                visited.add(currentvertex); // Mark the vertex as visited

                traversalOrder.enqueue(currentvertex); // Store the visited vertex

                // Assuming getNeighbors(E vertex) returns an array of neighbors for the given vertex
                int[] neighbors2 = neighbors(getindex(currentvertex)); 

                for (int i : neighbors2) 
                {
                    if (!visited.contains(i)) 
                    {
                        vertexQueue.enqueue(getLabel(i));
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
            for (int i = neighbors.length - 1; i >= 0; i--) 
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
        for (int i = 0; i < labels.length; i++) 
        {
            System.out.print(getLabel(i)+"\t");
        }
        System.out.println();
        for (int i = 0; i < labels.length; i++) 
        {
            System.out.print(getLabel(i)+"\t");
        for (int j = 0; j < labels.length; j++) 
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
        
        GraphInterface<String> graph = new matrixgraph<>(n);
        
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
