package leetcode.common.Over100;

import com.yahoo.jason.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jason on 6/26/16.
 * Binary Tree Zigzag Level Order Traversal
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        boolean order = true;
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> nodes = new LinkedList();
            List<Integer> list = new ArrayList();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (order) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }
            order = !order;
            result.add(list);
            queue.addAll(nodes);
        }
        return result;
    }
}
