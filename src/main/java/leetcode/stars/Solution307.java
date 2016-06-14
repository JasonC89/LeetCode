package leetcode.stars;

/**
 * Created by hchang on 6/13/16.
 * Range Sum Query - Mutable
 *
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

    private int[] BIT;
    private int[] value;

    public Solution307(int[] nums) {
        BIT = new int[nums.length+1];
        value = new int[nums.length];
        for (int i = 0; i < value.length; i++) {
            update(i, nums[i]);
            value[i] = nums[i];
        }
    }

    void update(int i, int val) {
        int offset = val - value[i];
        value[i] = val;
        i++;
        while(i < BIT.length) {
            BIT[i] += offset;
            i += i & (-i);
        }

    }

    public int sumRange(int i, int j) {
        return get(j) - get(i-1);
    }

    private int get(int i) {
        int result = 0;
        i++;
        while(i > 0) {
            result += BIT[i];
            i -= i & (-i);
        }
        return result;
    }
}
