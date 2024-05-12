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

    public static void main(String[] args) {
        BinaryTreeConstruction tree = new BinaryTreeConstruction();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println("The postorder traversal is: ");
        tree.generateAndPrintPostOrder(preorder, inorder);
    }
}