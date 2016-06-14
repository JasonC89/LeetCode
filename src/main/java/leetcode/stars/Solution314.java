package leetcode.stars;

import com.yahoo.jason.leetcode.TreeNode;

import java.util.*;

/**
 * Created by hchang on 6/13/16.
 * Binary Tree Vertical Order Traversal
 *
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

 If two nodes are in the same row and column, the order should be from left to right.

 Examples:

 Given binary tree [3,9,20,null,null,15,7],
      3
     /\
    /  \
   9  20
      /\
     /  \
    15   7
 return its vertical order traversal as:
 [
 [9],
 [3,15],
 [20],
 [7]
 ]
 Given binary tree [3,9,8,4,0,1,7],
 3
 /\
 /  \
 9   8
 /\  /\
 /  \/  \
 4  01   7
 return its vertical order traversal as:
 [
 [4],
 [9],
 [3,0,1],
 [8],
 [7]
 ]
 Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
 3
 /\
 /  \
 9   8
 /\  /\
 /  \/  \
 4  01   7
 /\
 /  \
 5   2
 return its vertical order traversal as:
 [
 [4],
 [9,5],
 [3,0,1],
 [8,2],
 [7]
 ]
 */
public class Solution314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        Queue<Integer> index = new LinkedList();
        List<List<Integer>> result = new ArrayList();
        Map<Integer, List<Integer>> map = new HashMap();
        if (root == null) {
            return result;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        queue.offer(root);
        index.offer(0);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int currentIndex = index.poll();
            min = Math.min(currentIndex, min);
            max = Math.max(currentIndex, max);
            if (!map.containsKey(currentIndex)) {
                map.put(currentIndex, new ArrayList());
            }
            map.get(currentIndex).add(current.val);
            if (current.left != null) {
                queue.offer(current.left);
                index.offer(currentIndex-1);
            }
            if (current.right != null) {
                queue.offer(current.right);
                index.offer(currentIndex+1);
            }
        }

        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
