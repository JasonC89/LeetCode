package leetcode.stars;

import java.util.*;

/**
 * Created by Jason on 6/11/16.
 * Word Search II
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].
 Note:
 You may assume that all inputs are consist of lowercase letters a-z.


 */
public class Solution212 {
    public List<String> findWords(char[][] board, String[] words) {
        Node root = buildTree(words);
        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(root, board, i, j, result);
            }
        }
        List<String> list = new ArrayList();
        list.addAll(result);
        return list;
    }

    private void dfs(Node root, char[][] board, int i, int j, Set<String> result) {

        if (!root.children.containsKey(board[i][j])) {
            return;
        }
        char current = board[i][j];
        board[i][j] = '!';
        Node next = root.children.get(current);
        if (next.word != null) {
            result.add(next.word);
        }

        if (i > 0) {
            dfs(next, board, i-1, j, result);
        }
        if (j > 0) {
            dfs(next, board, i, j-1, result);
        }
        if (i < board.length-1) {
            dfs(next, board, i+1, j, result);
        }
        if (j < board[0].length-1) {
            dfs(next, board, i, j+1, result);
        }
        board[i][j] = current;
    }

    private Node buildTree(String[] words) {
        Node root = new Node();
        for (String word : words) {
            Node current = root;
            for (char myChar : word.toCharArray()) {
                if (!current.children.containsKey(myChar)) {
                    current.children.put(myChar, new Node());
                }
                current = current.children.get(myChar);
            }
            current.word = word;
        }
        return root;
    }

    private class Node{
        public Map<Character, Node> children = new HashMap();
        public String word = null;
    }
}
