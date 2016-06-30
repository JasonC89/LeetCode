package leetcode.common.Second100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 6/28/16.
 * Missing Ranges
 *
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

 For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class Solution163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int left = lower;
        List<String> result = new ArrayList();
        for (int num : nums) {
            if (num < left) {
                continue;
            } else if (num == left) {
                left++;
            } else {
                if (num == left+1) {
                    result.add(String.valueOf(left));
                } else {
                    result.add(String.valueOf(left) + "->" + String.valueOf(num-1));
                }
                left = num + 1;
            }
        }
        if (left == upper) {
            result.add(String.valueOf(left));
        } else if (left < upper) {
            result.add(String.valueOf(left) + "->" + String.valueOf(upper));
        }
        return result;
    }
}
