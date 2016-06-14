package leetcode.stars;

/**
 * Created by Jason on 6/12/16.
 * Smallest Rectangle Enclosing Black Pixels
 *
 * An image is represented by a binary matrix with 0
 * as a white pixel and 1 as a black pixel. The black
 * pixels are connected, i.e., there is only one black
 * region. Pixels are connected horizontally and vertically.
 * Given the location (x, y) of one of the black pixels,
 * return the area of the smallest (axis-aligned) rectangle
 * that encloses all black pixels.

 For example, given the following image:

 [
 "0010",
 "0110",
 "0100"
 ]
 and x = 0, y = 2,
 Return 6.
 */
public class Solution302 {
    public int minArea(char[][] image, int x, int y) {
        int[] result = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};
        dfs(image, x, y, result);
        return (result[1] - result[0] + 1) * (result[3] - result[2] + 1);
    }

    private void dfs(char[][] image, int x, int y, int[] result) {
        if (x < 0
                || y < 0
                || x >= image.length
                || y >= image[0].length
                || image[x][y] == '0') {
            return;
        }
        image[x][y] = '0';
        result[0] = Math.min(result[0], x);
        result[1] = Math.max(result[1], x);
        result[2] = Math.min(result[2], y);
        result[3] = Math.max(result[3], y);
        dfs(image, x+1, y, result);
        dfs(image, x-1, y, result);
        dfs(image, x, y+1, result);
        dfs(image, x, y-1, result);
    }
}
