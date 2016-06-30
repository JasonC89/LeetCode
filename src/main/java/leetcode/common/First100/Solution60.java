package leetcode.common.First100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hchang on 6/23/16.
 * Permutation Sequence
 *
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.
 */
public class Solution60 {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<n; i++){
            sum *= i;
            factorial[i] = sum;
        }

        for(int i=1; i<=n; i++){
            numbers.add(i);
        }

        k--;

        for(int i = n; i >= 1; i--) {
            int index = k/factorial[i-1];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k-=index*factorial[i-1];
        }

        return sb.toString();
    }

    static public void main(String[] args) {
        Solution60 solution60 = new Solution60();
        solution60.getPermutation(3, 2);
    }
}
