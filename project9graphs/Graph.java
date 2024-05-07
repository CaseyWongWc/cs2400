package project9graphs;
import java.util.Iterator;

public class Graph<E> implements GraphInterface <E>
{
    private boolean [] [] edges;
    private E[] labels;
    
    public Graph(int n)
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
    
    public static void main(String[] args) 
    {
        GraphInterface<String> hi = new Graph<>(5);

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


