package project9graphs;

public interface GraphInterface<E> extends GraphAlgorithmsInterface<E> //extends BasicGraphInterface<E>, GraphAlgorithmsInterface<E>
{
    boolean isEdge(int source, int target);
    public boolean addEdge (int source, int target);
    public E getLabel(int vertex);
    public int [] neighbors(int vertex);
    public void removeEdge(int source, int target);
    public void setLabel(int vertex, E newLabel); 
    public int size();
    
    void printgraph();

} 
