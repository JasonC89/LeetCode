package com.yahoo.jason.leetcode;

import java.util.Stack;

/**
 * Created by hchang on 5/31/16.
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

 For example,
 Given the following words in dictionary,

 [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]
 The correct order is: "wertf".

 Note:
 You may assume all letters are in lowercase.
 If the order is invalid, return an empty string.
 There may be multiple valid order of letters, return any one of them is fine.
 */
public class Solution269 {
    public String alienOrder(String[] words) {
        boolean[][] adjs = new boolean[26][26];
        int[] visited = new int[26];
        for (int i = 0; i < words.length-1; i++) {
            int[] prefix = getFirstDiffChar(words[i], words[i+1]);
            if (prefix[0] < 0) {
                continue;
            }
            adjs[prefix[0]][prefix[1]] = true;
            for (char myChar : words[i].toCharArray()) {
                visited[myChar-'a'] = 1;
            }
        }

        for (char myChar : words[words.length-1].toCharArray()) {
            visited[myChar-'a'] = 1;
        }

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < 26; i++) {
            if (visited[i] == 1) {
                if (!dfs(visited, adjs, i, stack)) {
                    return "";
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    private boolean dfs(int[] visited, boolean[][] adjs, int current, Stack<Character> stack) {
        visited[current] = 2;
        adjs[current][current] = false;
        for (int i = 0; i < 26; i++) {
            if (adjs[current][i]) {
                if (visited[i] == 2) {
                    return false;
                }
                if(visited[i] == 1 && !dfs(visited, adjs, i, stack)) {
                    return false;
                }
            }
        }
        visited[current] = 3;
        stack.push((char)('a'+current));
        return true;
    }

    private int[] getFirstDiffChar(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return new int[]{s.charAt(i)-'a', t.charAt(i)-'a'};
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        Solution269 solution269 = new Solution269();
        solution269.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"});
    }
}
