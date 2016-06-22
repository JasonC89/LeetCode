package leetcode.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hchang on 6/21/16.
 * Roman to Integer
 *
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution13 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (i < s.length() - 1 && map.get(s.charAt(i+1)) > map.get(current)) {
                result -= map.get(current);
            } else {
                result += map.get(current);
            }
        }
        return result;
    }
}
