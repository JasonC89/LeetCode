package leetcode.stars;

/**
 * Created by hchang on 6/10/16.
 * Maximum Gap
 *
 * Given an unsorted array, find the maximum difference
 * between the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Return 0 if the array contains less than 2 elements.

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

 Credits:
 Special thanks to @porker2008 for adding this problem and creating all test cases.
 */
public class Solution164 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int bucketsCount = nums.length-1;
        int[][] buckets = new int[bucketsCount][2];
        for (int[] bucket : buckets) {
            bucket[0] = Integer.MAX_VALUE;
            bucket[1] = Integer.MIN_VALUE;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min == max) {
            return 0;
        }
        double gap = ((double)max - min) / bucketsCount;
        for (int num : nums) {
            if (num == min || num == max)
                continue;
            int index = (int) (((double)num - min) / gap);
            buckets[index][0] = Math.min(num, buckets[index][0]);
            buckets[index][1] = Math.max(num, buckets[index][1]);
        }

        int last = min;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < bucketsCount; i++) {
            if (buckets[i][0] < Integer.MAX_VALUE) {
                result = Math.max(result, buckets[i][0] - last);
                last = buckets[i][1];
            }
        }
        result = Math.max(result, max - last);
        return result;
    }

    public static void main(String[] args) {
        Solution164 solution164 = new Solution164();
        solution164.maximumGap(new int[] {1, 100000});
    }
}
