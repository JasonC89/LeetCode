package leetcode.common.First100;

/**
 * Created by Jason on 6/26/16.
 * Unique Binary Search Trees
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
public class Solution96 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int left = 0; left < i; left++) {
                sum += dp[left] * dp[i-left-1];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}
