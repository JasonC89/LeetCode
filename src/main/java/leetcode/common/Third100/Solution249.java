package leetcode.common.Third100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 7/2/16.
 * Group Shifted Strings
 *
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

 "abc" -> "bcd" -> ... -> "xyz"
 Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

 For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 A solution is:

 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]
 */
public class Solution249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            char[] array = string.toCharArray();
            int min = array[0] - 'a';
            for (int i = 0; i < array.length; i++) {
                if (array[i] - min >= 'a') {
                    array[i] -= min;
                } else {
                    array[i] += (26 - min);
                }
            }
            String key = new String(array);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(string);
        }

        return new ArrayList<>(map.values());
    }
}
