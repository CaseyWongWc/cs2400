public class DirectedGraph {
    private int numVertices; // Number of vertices in the graph
    private int[][] adjacencyMatrix; // Adjacency matrix to store edges

    // Constructor
    public DirectedGraph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    // Add edge from source vertex to destination vertex
    public void addEdge(int source, int destination) {
        // Place a 1 in the adjacency matrix to indicate an edge from source to destination
        adjacencyMatrix[source][destination] = 1;
    }

    // Remove edge from source vertex to destination vertex
    public void removeEdge(int source, int destination) {
        // Place a 0 in the adjacency matrix to indicate no edge from source to destination
        adjacencyMatrix[source][destination] = 0;
    }

    // Print the adjacency matrix
    public void printGraph() {
        System.out.println("Graph adjacency matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method to demonstrate graph operations
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(4); // Create a graph with 4 vertices

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        // Print the adjacency matrix
        graph.printGraph();
    }
}
