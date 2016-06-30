package leetcode.common.Second100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jason on 6/28/16.
 * Fraction to Recurring Decimal
 *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        stringBuilder.append(num / den);
        num %= den;
        if (num == 0) {
            return stringBuilder.toString();
        }

        // fractional part
        stringBuilder.append(".");
        Map<Long, Integer> map = new HashMap();
        map.put(num, stringBuilder.length());
        while (num != 0) {
            num *= 10;
            stringBuilder.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                stringBuilder.insert(index, "(");
                stringBuilder.append(")");
                break;
            }
            else {
                map.put(num, stringBuilder.length());
            }
        }
        return stringBuilder.toString();
    }
}
