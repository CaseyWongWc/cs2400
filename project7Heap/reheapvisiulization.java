package project7Heap;

public class reheapvisiulization {
    private int[] heap;
    private int size;

    // Constructor for MaxHeap
    public reheapvisiulization(int[] array) {
        this.heap = array;
        this.size = array.length;
        buildMaxHeap();
    }

    // Build a max heap from an array
    private void buildMaxHeap() {
        // Start from the last non-leaf node and heapify each node
        System.out.print("indexes\t");

        for (int i = 0; i < size; i++) 
        {System.out.print( i+1 + "\t");}System.out.println();  //CHANGE

        for (int i = (size / 2) - 1; i >= 0; i--) {
            
            reheap(i);
            
        }
    }

    // Iterative version of reheap to maintain max-heap property
    private void reheap(int index) {
        int reheapcounter = index;

        int largest = index; // Initialize largest as root
        int leftChildIdx, rightChildIdx;

        while (true) {
            leftChildIdx = 2 * index + 1; // left = 2*i + 1
            rightChildIdx = 2 * index + 2; // right = 2*i + 2
            
            // If left child is larger than root
            if (leftChildIdx < size && heap[leftChildIdx] > heap[largest]) {
                largest = leftChildIdx;
            }

            // If right child is larger than largest so far
            if (rightChildIdx < size && heap[rightChildIdx] > heap[largest]) {
                largest = rightChildIdx;
            }

            // If largest is not root
            if (largest != index) {
                swap(heap, index, largest);
                index = largest; // Move index to largest and continue heapifying
            } else {
                break; // If root is largest, break the loop
            }
            System.out.print(reheapcounter+1 + ":\t");  //CHANGE
            printHeap();
        }
    }

    // Helper method to swap two elements in the heap
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Display the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + "\t");
        }
        System.out.println();
    }

    // Main method to test the code
    public static void main(String args[])
    {
        
        int[] arr = {27,7,23,22,4,45,21,2,43,17};

        
        reheapvisiulization maxHeap = new reheapvisiulization(arr);
        System.out.println("sortedmaxheap ");System.out.print("\t");
        maxHeap.printHeap(); // Output should be a max-heap
    }
}
