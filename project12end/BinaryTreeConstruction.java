package project12end;
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeConstruction {

    private int preIndex = 0;
    private int postIndex;

    // Construct binary tree from given inorder and preorder traversals
    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preIndex++]);

        if (start == end) {
            return node;
        }

        int inIndex = search(inorder, start, end, node.value);
        node.left = buildTree(preorder, inorder, start, inIndex - 1);
        node.right = buildTree(preorder, inorder, inIndex + 1, end);

        return node;
    }

    // Construct binary tree from given inorder and postorder traversals
    private TreeNode buildTreeFromPostIn(int[] postorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[postIndex--]);

        if (start == end) {
            return node;
        }

        int inIndex = search(inorder, start, end, node.value);
        node.right = buildTreeFromPostIn(postorder, inorder, inIndex + 1, end);
        node.left = buildTreeFromPostIn(postorder, inorder, inIndex - 1, start);

        return node;
    }

    // Helper method to find the index of given value in inorder traversal
    private int search(int[] inorder, int start, int end, int value) {
        int i;
        for (i = start; i <= end; i++) {
            if (inorder[i] == value) {
                break;
            }
        }
        return i;
    }

    // Postorder traversal
    private void printPostOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.value + " ");
    }

    public void generateAndPrintPostOrder(int[] preorder, int[] inorder) {
        TreeNode root = buildTree(preorder, inorder, 0, inorder.length - 1);
        printPostOrder(root);
    }

    public void generateAndPrintPreOrder(int[] postorder, int[] inorder) {
        postIndex = postorder.length - 1;
        TreeNode root = buildTreeFromPostIn(postorder, inorder, 0, inorder.length - 1);
        printPreOrder(root);
    }

    // Preorder traversal
    private void printPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void main(String[] args) 
    {
        BinaryTreeConstruction tree = new BinaryTreeConstruction();
        
        int[] inorder = {9, 3, 15, 20, 7};

        // int[] preorder = {3, 9, 20, 15, 7};
        // System.out.println("The postorder traversal is: ");
        // tree.generateAndPrintPostOrder(preorder, inorder);

        int[] postorder = {9, 15, 7, 20, 3};
        System.out.println("\nThe pre order traversal is: ");
        tree.generateAndPrintPreOrder(postorder, inorder);
    }
}