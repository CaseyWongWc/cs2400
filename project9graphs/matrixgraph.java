package project9graphs;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import project2stack.LinkedStack;
import project2stack.StackInterface;
import project3queue.LinkedQueue;
import project3queue.QueueInterface;

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
    public static void main(String[] args) 
    {
        //https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
        // GraphInterface<String> hi = new matrixgraph<>(5);

        // hi.setLabel(0,"0");
        // hi.setLabel(1,"1");
        // hi.setLabel(2,"2");
        // hi.setLabel(3,"3");
        // hi.setLabel(4,"4");

        // hi.addEdge(0, 1);
        // hi.addEdge(0, 2);
        // hi.addEdge(1, 0);
        // hi.addEdge(1, 2);
        // hi.addEdge(1, 3);
        // hi.addEdge(2, 0);
        // hi.addEdge(2, 1);
        // hi.addEdge(2, 4);
        // hi.addEdge(3, 1);
        // hi.addEdge(3, 4);
        // hi.addEdge(4, 2);
        // hi.addEdge(4, 3);

        // hi.neighbors(3);
        // hi.printgraph();
        // hi.getBreadthFirstTraversal("0");

        GraphInterface<String> sample = new matrixgraph<>(9);

        sample.setLabel(0, "A");
        sample.setLabel(1, "B");
        sample.setLabel(2, "C");
        sample.setLabel(3, "D");
        sample.setLabel(4, "E");
        sample.setLabel(5, "F");
        sample.setLabel(6, "G");
        sample.setLabel(7, "H");
        sample.setLabel(8, "I");

        sample.addEdge(0, 1);sample.addEdge(0, 3);sample.addEdge(0, 4);
        sample.addEdge(1, 4);
        sample.addEdge(2, 1);
        sample.addEdge(3, 6);
        sample.addEdge(4, 5);sample.addEdge(4, 7);
        sample.addEdge(5, 2);sample.addEdge(5, 7);
        sample.addEdge(6, 7);
        sample.addEdge(7, 8);
        sample.addEdge(8, 5);
        sample.printgraph();
        sample.getBreadthFirstTraversal("A");
        sample.getDepthFirstTraversal("A");

    
    }
}
