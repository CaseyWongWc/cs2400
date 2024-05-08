package project9graphs;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Vertex<T> implements VertexInterface<T>
{
   private T label;
   private ListWithIteratorInterface<Edge> edgeList; // Edges to neighbors
   private boolean visited;                          // True if visited
   private VertexInterface<T> previousVertex;        // On path to this vertex
   private double cost;                              // Of path to this vertex
   
   public Vertex(T vertexLabel)
   {
      label = vertexLabel;
      edgeList = new LinkedListWithIterator<>();
      visited = false;
      previousVertex = null;
      cost = 0;
   } // end constructor

/* Implementations of the vertex operations go here.
   . . . */

   protected class Edge
   {
      private VertexInterface<T> vertex; // Vertex at end of edge
      private double weight;
      
      protected Edge(VertexInterface<T> endVertex, double edgeWeight)
      {
         vertex = endVertex;
         weight = edgeWeight;
      } // end constructor
      
      protected Edge(VertexInterface<T> endVertex)
      {
         vertex = endVertex;
         weight = 0;
      } // end constructor

      protected VertexInterface<T> getEndVertex()
      {
         return vertex;
      } // end getEndVertex
      
      protected double getWeight()
      {
         return weight; 
      } // end getWeight
   } // end Edge

   
   @Override
   public T getLabel() 
   {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getLabel'");
   }

   @Override
   public void visit() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'visit'");
   }

   @Override
   public void unvisit() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'unvisit'");
   }

   @Override
   public boolean isVisited() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isVisited'");
   }

   @Override
   public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'connect'");
   }

   @Override
   public boolean connect(VertexInterface<T> endVertex) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'connect'");
   }

public Iterator<VertexInterface<T>> getNeighborIterator()
{
   return new NeighborIterator();
} // end getNeighborIterator

private class NeighborIterator implements Iterator<VertexInterface<T>>
{
   private Iterator<Edge> edges;
   
   private NeighborIterator()
   {
      edges = edgeList.getIterator();
   } // end default constructor
   
   public boolean hasNext()
   {
      return edges.hasNext();
   } // end hasNext
   
   public VertexInterface<T> next()
   {
      VertexInterface<T> nextNeighbor = null;
      
      if (edges.hasNext())
      {
         Edge edgeToNextNeighbor = edges.next();
         nextNeighbor = edgeToNextNeighbor.getEndVertex();
      }
      else
         throw new NoSuchElementException();
      
      return nextNeighbor;
   } // end next
   
   public void remove()
   {
      throw new UnsupportedOperationException();
   } // end remove
} // end NeighborIterator

   @Override
   public Iterator<Double> getWeightIterator() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getWeightIterator'");
   }

   @Override
   public boolean hasNeighbor()
   {
      return !edgeList.isEmpty();
   } // end hasNeighbor
   
   public VertexInterface<T> getUnvisitedNeighbor()
   {
      VertexInterface<T> result = null;
   
      Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
      while ( neighbors.hasNext() && (result == null) )
      {
         VertexInterface<T> nextNeighbor = neighbors.next();
         if (!nextNeighbor.isVisited())
            result = nextNeighbor;
      } // end while
   
      return result;
   } // end getUnvisitedNeighbor
   


   @Override
   public void setPredecessor(VertexInterface<T> predecessor) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setPredecessor'");
   }

   @Override
   public VertexInterface<T> getPredecessor() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getPredecessor'");
   }

   @Override
   public boolean hasPredecessor() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'hasPredecessor'");
   }

   @Override
   public void setCost(double newCost) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'setCost'");
   }

   @Override
   public double getCost() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getCost'");
   }

   public boolean equals(Object other)
   {
   boolean result;

   if ((other == null) || (getClass() != other.getClass()))
      result = false;
   else
   {
      // The cast is safe within this else clause
      @SuppressWarnings("unchecked")
      Vertex<T> otherVertex = (Vertex<T>)other;
      result = label.equals(otherVertex.label);
   } // end if

   return result;
   } // end equals

} // end Vertex

