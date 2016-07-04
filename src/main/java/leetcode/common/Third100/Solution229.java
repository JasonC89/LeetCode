package leetcode.common.Third100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 7/2/16.
 * Majority Element II
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */
public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList();
        if (nums == null || nums.length == 0){
            return result;
        }
        int candidate1 = 0;
        int candidate2 = 0;
        int counter1 = 0;
        int counter2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                counter1++;
            } else if (num == candidate2) {
                counter2++;
            } else if (counter1 == 0) {
                candidate1 = num;
                counter1 = 1;
            } else if (counter2 == 0) {
                candidate2 = num;
                counter2 = 1;
            } else {
                counter1--;
                counter2--;
            }
        }

        counter1 = 0;
        counter2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                counter1++;
            }
            if (candidate2 == num) {
                counter2++;
            }
        }
        if (counter1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (candidate1 != candidate2 && counter2 > nums.length / 3) {
            result.add(candidate2);
        }
        return result;
    }
}
