package com.yahoo.jason.leetcode;

/**
 * Created by hchang on 6/2/16.
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 The update(i, val) function modifies nums by updating the element at index i to val.
 Example:
 Given nums = [1, 3, 5]

 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8
 Note:
 The array is only modifiable by the update function.
 You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class Solution307 {

    private int[] values;
    private int[] tree;

    public Solution307(int[] nums) {
        values = nums;
        tree = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            addValue(i, nums[i]);
        }
    }

    void update(int i, int val) {
        addValue(i, val - values[i]);
        values[i] = val;
    }

    public int sumRange(int i, int j) {
        return query(j) - query(i-1);
    }

    private void addValue(int index, int value) {
        index++;
        while (index <= values.length){
            tree[index] += value;
            index += (index & -index);
        }
    }

    private int query(int index) {
        int sum = 0;
        index++;
        while (index > 0){
            sum += tree[index];
            index -= (index & -index);
        }
        return sum;
    }
}
