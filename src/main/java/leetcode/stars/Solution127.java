package leetcode.stars;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by hchang on 6/8/16.
 * Word Ladder
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();
        int count = 1;
        queue.add(beginWord);
        visited.add(beginWord);
        while(!queue.isEmpty()) {
            Set<String> buffer = new HashSet();
            while(!queue.isEmpty()) {
                String current = queue.poll();
                Set<String> candidates = getCandidates(current, wordList, visited);
                if (candidates.contains(endWord)) {
                    return count+1;
                }
                buffer.addAll(candidates);
                visited.addAll(candidates);
            }
            count++;
            queue.addAll(buffer);
        }
        return 0;
    }

    private Set<String> getCandidates(String current, Set<String> dict, Set<String> visited) {
        Set<String> result = new HashSet();
        char[] chars = current.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (old != j) {
                    chars[i] = j;
                    String newString = new String(chars);
                    if (dict.contains(newString) && !visited.contains(newString)) {
                        result.add(newString);
                    }
                }
            }
            chars[i] = old;
        }
        return result;
    }

}
