package project9graphs;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
    // public QueueInterface<E> getBreadthFirstTraversal(E origin)
    // {
    //     // resetVertices();
    //     // QueueInterface<E> traversalOrder = new LinkedQueue<>();
    //     // QueueInterface<VertexInterface<E>> vertexQueue = new LinkedQueue<>();
        
    //     // VertexInterface<E> originVertex = vertices.getValue(origin);
    //     // originVertex.visit();
    //     // traversalOrder.enqueue(origin);    // Enqueue vertex label
    //     // vertexQueue.enqueue(originVertex); // Enqueue vertex
    //     // while (!vertexQueue.isEmpty())
    //     //     {
    //     //         VertexInterface<E> frontVertex = vertexQueue.dequeue();
    //     //         Iterator<VertexInterface<E>> neighbors = frontVertex.getNeighborIterator();
    //     //         while (neighbors.hasNext())
    //     //         {
    //     //             VertexInterface<E> nextNeighbor = neighbors.next();
    //     //             if (!nextNeighbor.isVisited())
    //     //             {
    //     //                 nextNeighbor.visit();
    //     //                 traversalOrder.enqueue(nextNeighbor.getLabel());
    //     //                 vertexQueue.enqueue(nextNeighbor);
    //     //             } // end if
    //     //         } // end while
    //     //     } // end while
    //     // return traversalOrder;
    //     //============================================================
    //     // QueueInterface<E> visited = new LinkedQueue<>();
    //     // QueueInterface<E> queue = new LinkedQueue<>();
    //     // E currentvertex = origin;
    //     // int[] neighbors2;
        
    //     // queue.enqueue(currentvertex);


    //     // while (!queue.isEmpty())
    //     // {

    //     //     currentvertex = queue.dequeue();

    //     //     visited.enqueue(currentvertex);

    //     //     neighbors2 = neighbors(getindex(currentvertex));
    
    //     //     for (int i=0; i < neighbors2.length;i++)
    //     //     {
    //     //         QueueInterface<E> tempvisited = visited;

    //     //         while (!tempvisited.isEmpty())
    //     //         {
    //     //             if (neighbors2[i] != getindex(tempvisited.dequeue()))
    //     //             {
    //     //                 queue.enqueue(getLabel(neighbors2[i]));
    //     //             }
    //     //         }
    //     //     } 
    //     // }
    //     // return visited;
    // } // end getBreadthFirstTraversal

    public QueueInterface<E> getBreadthFirstTraversal(E origin) 
    {
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
        GraphInterface<String> hi = new matrixgraph<>(5);

        hi.setLabel(0,"0");
        hi.setLabel(1,"1");
        hi.setLabel(2,"2");
        hi.setLabel(3,"3");
        hi.setLabel(4,"4");

        hi.addEdge(0, 1);
        hi.addEdge(0, 2);
        hi.addEdge(1, 0);
        hi.addEdge(1, 2);
        hi.addEdge(1, 3);
        hi.addEdge(2, 0);
        hi.addEdge(2, 1);
        hi.addEdge(2, 4);
        hi.addEdge(3, 1);
        hi.addEdge(3, 4);
        hi.addEdge(4, 2);
        hi.addEdge(4, 3);

        hi.neighbors(3);
        hi.printgraph();
        hi.getBreadthFirstTraversal("0");
    }
}
