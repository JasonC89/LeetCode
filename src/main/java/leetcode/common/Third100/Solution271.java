package leetcode.common.Third100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 7/3/16.
 * Encode and Decode Strings
 *
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

 Machine 1 (sender) has the function:

 string encode(vector<string> strs) {
 // ... your code
 return encoded_string;
 }
 Machine 2 (receiver) has the function:
 vector<string> decode(string s) {
 //... your code
 return strs;
 }
 So Machine 1 does:

 string encoded_string = encode(strs);
 and Machine 2 does:

 vector<string> strs2 = decode(encoded_string);
 strs2 in Machine 2 should be the same as strs in Machine 1.

 Implement the encode and decode methods.

 Note:
 The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
 Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 */
public class Solution271 {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str.length());
            stringBuilder.append("!");
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList();
        int start = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (start < s.length()) {
            if (s.charAt(start) != '!') {
                stringBuilder.append(String.valueOf(s.charAt(start)));
            } else {
                int length = Integer.parseInt(stringBuilder.toString());
                result.add(s.substring(start+1, start+length+1));
                start += length;
                stringBuilder.setLength(0);
            }
            start++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution271 solution271 = new Solution271();
        List<String> strs = new ArrayList<>();
        strs.add("");
        String string = solution271.encode(strs);
        solution271.decode(string);
    }
}
