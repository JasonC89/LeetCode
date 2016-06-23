package leetcode.common;

/**
 * Created by Jason on 6/22/16.
 * Count and Say
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.


 */
public class Solution38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String last = countAndSay(n-1);
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        char currentChar = last.charAt(0);

        for (int i = 1; i < last.length(); i++) {
            if (currentChar == last.charAt(i)) {
                count++;
            } else {
                stringBuilder.append(String.valueOf(count));
                stringBuilder.append(String.valueOf(currentChar));
                count = 1;
                currentChar = last.charAt(i);
            }
        }
        stringBuilder.append(String.valueOf(count));
        stringBuilder.append(String.valueOf(currentChar));
        return stringBuilder.toString();
    }
}
