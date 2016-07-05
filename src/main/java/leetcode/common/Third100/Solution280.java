package leetcode.common.Third100;

/**
 * Created by Jason on 7/3/16.
 * Wiggle Sort
 *
 * Given an unsorted array nums, reorder it in-place
 * such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

 For example, given nums = [3, 5, 2, 1, 6, 4],
 one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class Solution280 {
    public void wiggleSort(int[] nums) {
        boolean increase = true;
        for (int i = 0; i < nums.length-1; i++) {
            if ((increase && nums[i] > nums[i+1])
                    || (!increase && nums[i] < nums[i+1])) {
                int tmp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = tmp;
            }
            increase = !increase;
        }
    }
}
