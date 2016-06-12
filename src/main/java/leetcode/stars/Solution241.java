package leetcode.stars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 6/11/16.
 * Different Ways to Add Parentheses
 *
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


 Example 1
 Input: "2-1-1".

 ((2-1)-1) = 0
 (2-(1-1)) = 2
 Output: [0, 2]


 Example 2
 Input: "2*3-4*5"

 (2*(3-(4*5))) = -34
 ((2*3)-(4*5)) = -14
 ((2*(3-4))*5) = -10
 (2*((3-4)*5)) = -10
 (((2*3)-4)*5) = 10
 Output: [-34, -14, -10, -10, 10]
 */
public class Solution241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '+' || current == '-' || current == '*') {
                List<Integer> firsts = diffWaysToCompute(input.substring(0, i));
                List<Integer> seconds = diffWaysToCompute(input.substring(i+1, input.length()));
                for (int first : firsts) {
                    for (int second : seconds) {
                        if (current == '+') {
                            result.add(first + second);
                        } else if (current == '-') {
                            result.add(first - second);
                        } else if (current == '*') {
                            result.add(first * second);
                        }
                    }
                }
            }

        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}
