package leetcode.common.Third100;

import com.yahoo.jason.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 7/3/16.
 * Binary Tree Paths
 *
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<String>();
        if(root==null)  return res;
        String s=root.val+"";
        getPaths(res,root,s);
        return res;
    }
    private void getPaths(List<String> res,TreeNode root,String s){
        if(root.left==null&&root.right==null){
            res.add(s);
            return;
        }
        if(root.left!=null)
            getPaths(res,root.left,s+"->"+root.left.val);
        if(root.right!=null)
            getPaths(res,root.right,s+"->"+root.right.val);
    }
}
