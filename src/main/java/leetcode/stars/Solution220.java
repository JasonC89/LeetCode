package leetcode.stars;

import java.util.TreeSet;

/**
 * Created by Jason on 6/11/16.
 * Contains Duplicate III
 *
 * Given an array of integers,
 * find out whether there are two distinct
 * indices i and j in the array such that the
 * difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is
 * at most k.
 */
public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k == 0) {
            return false;
        }

        TreeSet<Integer> set = new TreeSet();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer floor = set.floor(num + t);
            Integer ceiling = set.ceiling(num - t);
            if ((floor != null && floor > num) || (ceiling != null && ceiling < num)) {
                return true;
            }
            set.add(num);
            if (set.size() >= k) {
                set.remove(nums[i - k - 1]);
            }
        }
        return false;
    }
}
