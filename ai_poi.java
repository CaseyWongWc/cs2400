import java.util.*;

public class BinaryTree<T> {
    private Node<T> root;

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
        }
    }

    public BinaryTree(T rootData) {
        root = new Node<>(rootData);
    }

    // Add nodes to the tree for simplicity, this example uses direct access
    public void addLeftChild(Node<T> parent, T data) {
        parent.left = new Node<>(data);
    }

    public void addRightChild(Node<T> parent, T data) {
        parent.right = new Node<>(data);
    }

    public Iterator<T> getPostOrderIterator() {
        return new PostOrderIterator<>(root);
    }

    private static class PostOrderIterator<T> implements Iterator<T> {
        private final Stack<Node<T>> stack = new Stack<>();
        private Node<T> current;
        private Node<T> lastVisited;

        public PostOrderIterator(Node<T> root) {
            if (root != null) {
                stack.push(root);
                current = root;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            while (hasNext()) {
                current = stack.peek();

                // Traverse to the leftmost leaf
                if (lastVisited == null || lastVisited.left == current || lastVisited.right == current) {
                    if (current.left != null) {
                        stack.push(current.left);
                    } else if (current.right != null) {
                        stack.push(current.right);
                    } else {
                        stack.pop();
                        lastVisited = current;
                        return current.data;
                    }
                }
                // Traverse up the tree from the left
                else if (current.left == lastVisited) {
                    if (current.right != null) {
                        stack.push(current.right);
                    }
                }
                // Traverse up the tree from the right
                else if (current.right == lastVisited) {
                    stack.pop();
                    lastVisited = current;
                    return current.data;
                }
            }
            throw new NoSuchElementException();
        }
    }

    // Example usage
    public static void main(String[] args) {
        BinaryTree<String> tree = new BinaryTree<>("root");
        Node<String> rootNode = tree.root;
        tree.addLeftChild(rootNode, "left");
        tree.addRightChild(rootNode, "right");

        Iterator<String> postOrderIterator = tree.getPostOrderIterator();
        while (postOrderIterator.hasNext()) {
            System.out.println(postOrderIterator.next());
        }
    }
}
