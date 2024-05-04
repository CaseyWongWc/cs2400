package project9graphs;
import java.util.Iterator;

public class Graph<data> implements GraphInterface <data>
{
    private boolean [] [] edges;
    private data[] labels;
    
    public Graph(int n)
    {
        edges = new boolean[n][n];
        labels = (data[]) new Object[n];
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
    public data getLabel(int vertex) 
    {
        return labels[vertex];
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
        
        for (i=0; i < labels.length;i++)
        {
            if (edges[vertex][i])
            {
                answer[count++] =i;
            }
        }
        return answer;
    }

    @Override
    public void removeEdge(int source, int target) 
    {
        edges[source][target]=false;
    }

    @Override
    public void setLabel(int vertex, data newLabel) 
    {
        labels[vertex] = newLabel;
    }

    @Override
    public int size() 
    {   
        return labels.length;
    }
    
public static void main(String[] args) 
{
    GraphInterface<String> hi = new Graph<>(5);
    
}
}


