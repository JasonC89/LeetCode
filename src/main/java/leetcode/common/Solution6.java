package leetcode.common;

/**
 * Created by hchang on 6/21/16.
 * ZigZag Conversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        int charIndex = 0;
        while (charIndex < s.length()) {
            for(int i = 0; i < numRows && charIndex < s.length(); i++) {
                builders[i].append(s.charAt(charIndex));
                charIndex++;
            }

            for(int i = numRows - 2; i > 0 && charIndex < s.length(); i--) {
                builders[i].append(s.charAt(charIndex));
                charIndex++;
            }
        }
        for (int i = 1; i < numRows; i++) {
            builders[0].append(builders[i].toString());
        }
        return builders[0].toString();
    }
}
