package leetcode.common.First100;

import java.util.Stack;

/**
 * Created by Jason on 6/25/16.
 * Simplify Path
 *
 * Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 */
public class Solution71 {
    public String simplifyPath(String path) {
        String[] array = path.split("/");
        Stack<String> stack = new Stack();
        for (String folder : array) {
            if (folder.equals("..")) {
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else if (folder.equals(".") || folder.equals("")) {
                continue;
            } else {
                stack.push(folder);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()) {
            stringBuilder.insert(0, stack.pop());
            stringBuilder.insert(0,"/");
        }
        if (stringBuilder.length() == 0) {
            return "/";
        }
        return stringBuilder.toString();
    }
}
