package leetcode.common.Second100;

/**
 * Created by Jason on 6/28/16.
 * One Edit Distance
 *
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class Solution161 {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length())
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else if (s.length() < t.length())
                    return s.substring(i).equals(t.substring(i + 1));
                else
                    return t.substring(i).equals(s.substring(i + 1));
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}