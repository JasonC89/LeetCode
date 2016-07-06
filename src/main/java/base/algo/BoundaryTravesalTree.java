package base.algo;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by Jason on 7/5/16.
 * Boundary Traversal of binary tree
 *
 */
public class BoundaryTravesalTree {
    static TreeNode root;

    // A simple function to print leaf nodes of a binary tree
    void printLeaves(TreeNode node) {
        if (node != null) {
            printLeaves(node.left);

            // Print it if it is a leaf node
            if (node.left == null && node.right == null) {
                System.out.print(node.val + " ");
            }

            printLeaves(node.right);
        }
    }

    // A function to print all left boundry nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(TreeNode node) {
        if (node != null) {
            if (node.left != null) {

                // to ensure top down order, print the node
                // before calling itself for left subtree
                System.out.print(node.val + " ");
                printBoundaryLeft(node.left);
            } else if (node.right != null) {
                System.out.print(node.val + " ");
                printBoundaryLeft(node.right);
            }

            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to print all right boundry nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(TreeNode node) {
        if (node != null) {
            if (node.right != null) {

                // to ensure bottom up order, first call for right
                //  subtree, then print this node
                printBoundaryRight(node.right);
                System.out.print(node.val + " ");
            } else if (node.left != null) {
                printBoundaryRight(node.left);
                System.out.print(node.val + " ");
            }

            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");

            // Print the left boundary in top-down manner.
            printBoundaryLeft(node.left);

            // Print all leaf nodes
            printLeaves(node.left);
            printLeaves(node.right);

            // Print the right boundary in bottom-up manner
            printBoundaryRight(node.right);
        }
    }
}
