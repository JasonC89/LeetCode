package com.yahoo.jason.leetcode;

/**
 * Created by hchang on 5/31/16.
 * The API: int read4(char *buf) reads 4 characters at a time from a file.

 The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

 Note:
 The read function may be called multiple times.
 */
public class Solution158 {
    private int read4(char[] buf) {
        return 0;
    }

    private char[] buffer = new char[4];
    private int bufferStart;
    private int bufferSize;

    public int read(char[] buf, int n) {
        int start = 0;
        while(start < n) {
            if(bufferStart < bufferSize) {
                buf[start] = buffer[bufferStart];
                bufferStart++;
                start++;
            } else {
                bufferStart = 0;
                bufferSize = read4(buffer);
                if (bufferSize == 0) {
                    return start;
                }
            }
        }
        return start;
    }
}
