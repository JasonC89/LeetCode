package leetcode.common.Second100;

import com.yahoo.jason.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 6/26/16.
 * Path Sum II
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList();
        valid(root, 0, sum, new ArrayList(), result);
        return result;
    }

    private void valid(TreeNode root, int current, int target, List<Integer> list, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (current+root.val == target) {
                List<Integer> tmp = new ArrayList();
                tmp.addAll(list);
                tmp.add(root.val);
                result.add(tmp);
            }
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            valid(root.left, current+root.val, target, list, result);
        }
        if (root.right != null) {
            valid(root.right, current+root.val, target, list, result);
        }
        list.remove(list.size()-1);
    }
}
