package project8binarysearchtree;

import java.util.Iterator;
import project6tree.BinaryTree;
import project6tree.BinaryTreeInterface;
import project6tree.TreeIteratorInterface;
import project6tree.*;

public class BinarySearchTreedemo 
{
    public static void main(String[] args) 
    {

        int array [] = {13,5,20,32,7,14,12};


        SearchTreeInterface<Integer> aTree = new BinarySearchTree<>();

        for (int i=0; i< array.length; i++)
        {
            aTree.add(array[i]);
            printBST(aTree);
        }
        //===========================
        System.out.println("=======================");
        printBST(aTree);
        aTree.add(16);
        aTree.remove(14);
        printBST(aTree);
        aTree.clear();
        
        
    }

        //helper
        private static void printBST(SearchTreeInterface<Integer> tree) 
        {
            Iterator<Integer> inorder = tree.getInorderIterator();
            
            System.out.println("===========");
            System.out.print("InorderIteration: " );
            while (inorder.hasNext())
            {
                System.out.print(inorder.next()+ " ");
            }
            System.out.println();



            Iterator<Integer> level = tree.getLevelOrderIterator();
            System.out.print("levelorderIteration: " );
            while (level.hasNext())
            {
                System.out.print(level.next()+ " ");
            }
            System.out.println();

            
            /*Iterator<Integer> preorder = tree.getPreorderIterator();
            System.out.print("PreorderIteration: " );
            while (preorder.hasNext())
            {
                System.out.print(preorder.next()+ " ");
            }
            System.out.println();*/
             //bugs

            Iterator<Integer> post = tree.getPostorderIterator();
            System.out.print("postorderIteration: " );
            while (post.hasNext())
            {
                System.out.print(post.next()+ " ");
            }
            System.out.println();
            
            
        }
}

