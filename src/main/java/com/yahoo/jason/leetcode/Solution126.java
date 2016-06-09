package com.yahoo.jason.leetcode;

import java.util.*;

/**
 * Created by hchang on 6/3/16.
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 */
public class Solution126 {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Map<String, Set<String>> children = bfs(beginWord, endWord, wordList);
        List<String> list = new ArrayList<String>();
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(children, beginWord, endWord, list, result);
        return result;
    }

    private void dfs(Map<String, Set<String>> children, String current, String target, List<String> list, List<List<String>> result) {
        if (current.equals(target)) {
            list.add(current);
            result.add(list);
            list.remove(list.size()-1);
            return;
        }
        list.add(current);
        for (String child : children.get(current)) {
            dfs(children, child, target, list, result);
        }
        list.remove(list.size()-1);
    }

    private Map<String, Set<String>> bfs(String begin, String end, Set<String> dict) {
        Map<String, Set<String>> children = new HashMap();
        LinkedList<String> queue = new LinkedList();
        children.put(begin, new HashSet<String>());
        queue.add(begin);
        while(!queue.isEmpty()) {
            LinkedList<String> newQueue = new LinkedList();
            boolean hasEnd = false;
            while (!queue.isEmpty()) {
                String current = queue.poll();
                Set<String> candidates = getCandidate(current, dict, children);
                if (candidates.contains(end)) {
                    hasEnd = true;
                }
                for (String candidate : candidates) {
                    children.get(current).add(candidate);
                    newQueue.offer(candidate);
                }
            }
            for (String can : newQueue) {
                if (!hasEnd) {
                    queue.offer(can);
                }
                children.put(can, new HashSet<String>());
            }
        }
        return children;
    }

    private Set<String> getCandidate(String current, Set<String> dict, Map<String, Set<String>> children) {
        char[] array = current.toCharArray();
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < array.length; i++) {
            char real = array[i];
            for (char myChar = 'a'; myChar <= 'z'; myChar++) {
                if (real != myChar) {
                    array[i] = myChar;
                    String newString = new String(array);
                    if (dict.contains(newString) && !children.containsKey(newString)) {
                        result.add(newString);
                    }
                }
            }
            array[i] = real;
        }
        return result;
    }

    static public void main(String[] args) {
        Solution126 solution126 = new Solution126();
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("cog");
        dict.add("dog");
        dict.add("tot");
        dict.add("hog");
        dict.add("hop");
        dict.add("pot");
        dict.add("dot");
        solution126.findLadders("hot", "dog", dict);
    }
}
