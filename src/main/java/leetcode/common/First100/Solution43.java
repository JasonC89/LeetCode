package leetcode.common.First100;

/**
 * Created by hchang on 6/23/16.
 * Multiply Strings
 *
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note:
 The numbers can be arbitrarily large and are non-negative.
 Converting the input string to integer is NOT allowed.
 You should NOT use internal library such as BigInteger.
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        int[] array = new int[num1.length() + num2.length() - 1];
        for (int i = num1.length()-1; i >= 0; i--) {
            for (int j = num2.length()-1; j >= 0; j--) {
                int current = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                current += array[i+j+1];
                array[i+j+1] = current % 10;
                array[i+j] += current / 10;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        boolean start = false;
        for (int digit : array) {
            if (digit != 0) {
                start = true;
                stringBuilder.append(String.valueOf(digit));
            } else {
                if (start) {
                    stringBuilder.append(String.valueOf(digit));
                }
            }
        }
        if (stringBuilder.length() == 0) {
            return "0";
        }
        return stringBuilder.toString();
    }
}
