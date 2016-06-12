package leetcode.stars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 6/11/16.
 * Add and Search Word - Data structure design
 *
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 */
public class Solution211 {

    private Node root = new Node();

    // Adds a word into the data structure.
    public void addWord(String word) {
        Node current = root;
        for (char myChar : word.toCharArray()) {
            if (!current.children.containsKey(myChar)) {
                current.children.put(myChar, new Node());
            }
            current = current.children.get(myChar);
        }
        current.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return helper(root, word, 0);
    }

    private boolean helper(Node node, String word, int index) {
        if (index >= word.length()) {
            return node.isWord;
        }
        if (word.charAt(index) == '.') {
            for (Node next : node.children.values()) {
                if (helper(next, word, index+1)) {
                    return true;
                }
            }
            return false;
        }

        Node next = node.children.get(word.charAt(index));
        if (next == null) {
            return false;
        }
        return helper(next, word, index+1);
    }

    private class Node {
        public Map<Character, Node> children;
        public boolean isWord;
        public Node() {
            this.children = new HashMap();
        }
    }
}
