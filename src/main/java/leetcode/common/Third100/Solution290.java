package leetcode.common.Third100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jason on 7/3/16.
 * Word Pattern
 *
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class Solution290 {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] array = str.split(" ");
        if (pattern.length() != array.length) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            char cur = pattern.charAt(i);
            if (map.containsKey(cur) && !map.get(cur).equals(array[i])) {
                return false;
            }
            if (!map.containsKey(cur) && set.contains(array[i])) {
                return false;
            }
            map.put(cur, array[i]);
            set.add(array[i]);
        }
        return true;
    }
}
