package leetcode.common.Fourth100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jason on 7/4/16.
 * Longest Substring with At Most K Distinct Characters
 *
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

 For example, Given s = “eceba” and k = 2,

 T is "ece" which its length is 3.
 */
public class Solution340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap();
        int left = 0;
        int right = 0;
        int result = 0;
        while(right < s.length()) {
            char current = s.charAt(right);
            if (!map.containsKey(current)) {
                map.put(current, 1);
            } else {
                map.put(current, map.get(current)+1);
            }

            while(map.size() > k) {
                if (map.get(s.charAt(left)) == 1) {
                    map.remove(s.charAt(left));
                } else {
                    map.put(s.charAt(left), map.get(s.charAt(left))-1);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
