package leetcode.common.Third100;

/**
 * Created by Jason on 7/3/16.
 * Find the Celebrity
 *
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

 Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

 You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.

 Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
 */
public class Solution277 {
    public int findCelebrity(int n) {
        int celebry = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celebry, i)) {
                celebry = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != celebry && (!knows(i, celebry) || knows(celebry, i))) {
                return -1;
            }
        }
        return celebry;
    }

    private boolean knows(int a, int b) {
        return false;
    }
}
