package leetcode.common.Fourth100;

import com.yahoo.jason.leetcode.TreeNode;
import leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 7/5/16.
 * Find Leaves of Binary Tree
 *
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 Example:
 Given binary tree
 1
 / \
 2   3
 / \
 4   5
 Returns [4, 5, 3], [2], [1].

 Explanation:
 1. Removing the leaves [4, 5, 3] would result in this tree:

 1
 /
 2
 2. Now removing the leaf [2] would result in this tree:

 1
 3. Now removing the leaf [1] would result in the empty tree:

 []
 Returns [4, 5, 3], [2], [1].
 */
public class Solution336 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private int helper(TreeNode node, List<List<Integer>> result){
        if(node == null)  return -1;
        int height= 1 + Math.max(helper(node.left, result), helper(node.right, result));
        if(result.size()<height+1)  result.add(new ArrayList<Integer>());
        result.get(height).add(node.val);
        return height;
    }
}
