package project9graphs;
import java.util.Iterator;

import project3queue.LinkedQueue;
import project3queue.QueueInterface;

public class matrixgraph<E> implements GraphInterface <E>
{
    private boolean [] [] edges;
    private E[] labels;
    
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
    {
        // //resetVertices();
        // QueueInterface<E> traversalOrder = new LinkedQueue<>();
        // QueueInterface<VertexInterface<E>> vertexQueue = new LinkedQueue<>();
        
        // VertexInterface<E> originVertex = vertices.getValue(origin);
        // originVertex.visit();
        // traversalOrder.enqueue(origin);    // Enqueue vertex label
        // vertexQueue.enqueue(originVertex); // Enqueue vertex
        // while (!vertexQueue.isEmpty())
        //     {
        //         VertexInterface<E> frontVertex = vertexQueue.dequeue();
        //         Iterator<VertexInterface<E>> neighbors = frontVertex.getNeighborIterator();
        //         while (neighbors.hasNext())
        //         {
        //             VertexInterface<E> nextNeighbor = neighbors.next();
        //             if (!nextNeighbor.isVisited())
        //             {
        //                 nextNeighbor.visit();
        //                 traversalOrder.enqueue(nextNeighbor.getLabel());
        //                 vertexQueue.enqueue(nextNeighbor);
        //             } // end if
        //         } // end while
        //     } // end while
        // return traversalOrder;
        
        QueueInterface<E> visited = new LinkedQueue<>();
        QueueInterface<E> queue = new LinkedQueue<>();
        E currentvertex = origin;
        int[] neighbors2;
        
        queue.enqueue(origin);

        currentvertex = queue.dequeue();
        visited.enqueue(currentvertex);
        neighbors2 = currentvertex.


        

        return visited;
    } // end getBreadthFirstTraversal
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
        GraphInterface<String> hi = new matrixgraph<>(5);

        hi.setLabel(0,"a");
        hi.setLabel(1,"b");
        hi.setLabel(2,"c");
        hi.setLabel(3,"d");
        hi.setLabel(4,"e");

        hi.addEdge(0, 1);
        hi.addEdge(0, 3);
        hi.addEdge(1, 0);
        hi.addEdge(2, 2);
        hi.addEdge(3, 0);
        hi.addEdge(3, 1);
        hi.addEdge(3, 2);
        hi.addEdge(4, 3);

        hi.neighbors(3);
        hi.printgraph();
    }
}
