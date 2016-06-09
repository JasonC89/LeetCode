package leetcode.stars;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hchang on 6/7/16.
 * Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        int count = 0;
        for (char myChar : t.toCharArray()) {
            map.put(myChar, map.containsKey(myChar)? map.get(myChar)+1: 1);
            count++;
        }
        String result = "";
        int start = 0;
        int end = 0;
        while(start < s.length()) {
            if (count > 0) {
                if (end >= s.length()) {
                    break;
                }
                char current = s.charAt(end);
                if (map.containsKey(current)) {
                    map.put(current, map.get(current) - 1);
                    if (map.get(current) >= 0) {
                        count--;
                    }
                }
                end++;
            } else {
                char current = s.charAt(start);
                if (map.containsKey(current)) {
                    if (map.get(current) < 0) {
                        map.put(current, map.get(current)+1);
                    } else {
                        if (result.isEmpty()) {
                            result = s.substring(start,end);
                        } else {
                            result = s.substring(start,end).length() < result.length()? s.substring(start,end) : result;
                        }
                        map.put(current, 1);
                        count++;
                    }
                }
                start++;
            }
        }
        return result;
    }
}
