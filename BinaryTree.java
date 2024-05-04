import java.util.*;
//hi
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

    public Iterator<T> getPostOrderIteratorR() {
        return new PostOrderIteratorR<>(root);
    }

    private static class PostOrderIteratorR<T> implements Iterator<T> {
        //private final Stack<Node<T>> stack = new Stack<>();
        private Node<T> current;
        private Node<T> lastVisited;

        public PostOrderIteratorR(Node<T> root) {
            current = root;            
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            assert hasNext();
            return nextNode(current).data;
        }

        private Node<T> nextNode(Node<T> root) {
            Node<T> tmpCurrent = root;
            if (root == null) {
                return null;
            }

            current = root.left;
            Node<T> left = nextNode(current);
            current = root.right;
            Node<T> right = nextNode(current);
            current = tmpCurrent;
            if (left == null && right == null) {
                return current;
            }
            if (left == null) {
                return current.right;
            }
            if (right == null) {
                return current.left;
            }
            return root;
        }

        private Node<T> nextNodeI() {
            while (current != null) {
                // When stack only has root at the top and nothing else, 
                // or when top of stack is the right child, whose parent is right underneath on the of stack.
                // Traverse to the leftmost leaf, 
                if (lastVisited == null) {
                    if (current.left != null) {
                        current = current.left;
                    } else if (current.right != null) {
                        current = current.right;
                    } else {
                        Node<T> temp = current;
                        current = null;
                        lastVisited = temp;
                        return temp;
                    }
                }
                // Traverse up the tree from the left
                else if (current.left == lastVisited) {
                    if (current.right != null) {
                        current = current.right;
                        lastVisited = null; // when top of stack is the right child, whose parent is right underneath on the of stack.
                    }
                    else {
                        Node<T> temp = current;
                        current = null;
                        lastVisited = temp;
                        return temp;
                    }
                }
                // Traverse up the tree from the right
                else if (current.right == lastVisited) {
                    Node<T> temp = current;
                    current = null;
                    lastVisited = temp;
                    return temp;
                }
            }
            throw new NoSuchElementException();
        }
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

                // When stack only has root at the top and nothing else, 
                // or when top of stack is the right child, whose parent is right underneath on the of stack.
                // Traverse to the leftmost leaf, 
                if (lastVisited == null) {
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
                        lastVisited = null; // when top of stack is the right child, whose parent is right underneath on the of stack.
                    }
                    else {
                        stack.pop();
                        lastVisited = current;
                        return current.data;
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
        tree.addRightChild(rootNode.left, "left-right");
        tree.addLeftChild(rootNode.left.right, "left-right-left");
        tree.addLeftChild(rootNode.right, "right-left");
        tree.addRightChild(rootNode.right, "right-right");
        tree.addLeftChild(rootNode.right.right, "right-right-left");

        Iterator<String> postOrderIterator = tree.getPostOrderIterator();
        while (postOrderIterator.hasNext()) {
            System.out.println(postOrderIterator.next());
        }
        System.out.println("==========================");
        /*Iterator<String> postOrderIteratorR = tree.getPostOrderIteratorR();
        while (postOrderIteratorR.hasNext()) {
            System.out.println(postOrderIteratorR.next());
        }*/
    }
}
