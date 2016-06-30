package leetcode.common.Second100;

import com.yahoo.jason.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hchang on 6/29/16.
 * Binary Tree Right Side View
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].
 */
public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList();
        List<Integer> result = new ArrayList();
        if (root != null) {
            queue.offer(root);
        }
        while(!queue.isEmpty()) {
            List<TreeNode> next = new LinkedList();
            result.add(queue.get(queue.size()-1).val);
            while(!queue.isEmpty()) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    next.add(current.left);
                }
                if (current.right != null) {
                    next.add(current.right);
                }
            }
            queue.addAll(next);
        }
        return result;
    }
}
