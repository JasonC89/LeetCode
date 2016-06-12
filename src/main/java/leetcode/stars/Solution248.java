package leetcode.stars;

/**
 * Created by Jason on 6/11/16.
 * Strobogrammatic Number III
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

 For example,
 Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

 Note:
 Because the range might be a large number, the low and high numbers are represented as string.
 */
public class Solution248 {
    char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    int count = 0;

    public int strobogrammaticInRange(String low, String high) {
        for (int i = low.length(); i < high.length() + 1; i++) {
            dfs(new char[i], 0, i-1, low, high);
        }
        return count;
    }

    private void dfs(char[] array, int left, int right, String low, String high) {
        if (left <= right) {
            for (char[] pair : pairs) {
                array[left] = pair[0];
                array[right] = pair[1];
                if ((array.length > 1 && array[0] == '0')
                        || (left == right && pair[0] != pair[1]) ){
                    continue;
                }
                dfs(array, left+1, right-1, low, high);
            }
        } else {
            String string = new String(array);
            if ((string.length() == low.length() && string.compareTo(low) < 0)
                || (string.length() == high.length() && string.compareTo(high) > 0)) {
                return;
            }
            count++;
        }
    }
}
