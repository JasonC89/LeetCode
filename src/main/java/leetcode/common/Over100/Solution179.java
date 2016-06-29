package leetcode.common.Over100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Jason on 6/28/16.
 * Largest Number
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class Solution179 {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1+o2;
                String str2 = o2+o1;
                return str2.compareTo(str1);
            }
        });
        if(list.get(0).charAt(0)=='0')
            return "0";
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : list) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
