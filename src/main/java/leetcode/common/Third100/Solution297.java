package leetcode.common.Third100;

import com.yahoo.jason.leetcode.TreeNode;

import java.util.Scanner;

/**
 * Created by hchang on 6/30/16.
 * Serialize and Deserialize Binary Tree
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 For example, you may serialize the following tree

 1
 / \
 2   3
 / \
 4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class Solution297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        return "" + root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return build(new Scanner(data));
    }

    private TreeNode build(Scanner scanner) {
        if (!scanner.hasNext()) {
            return null;
        }
        String node = scanner.next();
        if (node.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = build(scanner);
        root.right = build(scanner);
        return root;
    }

}
