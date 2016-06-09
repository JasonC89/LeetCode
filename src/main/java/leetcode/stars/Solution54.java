package leetcode.stars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hchang on 6/7/16.
 * Spiral Matrix
 *
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList();
        if(matrix == null || matrix.length == 0) return spiralList;

        // declare indices
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(true){
            // 1. print top row
            for(int j=left; j <=right;j++){
                spiralList.add(matrix[top][j]);
            }
            top++;
            if(boundriesCrossed(left,right,bottom,top))
                break;

            // 2. print rightmost column
            for(int i=top; i <= bottom; i++){
                spiralList.add(matrix[i][right]);
            }
            right--;
            if(boundriesCrossed(left,right,bottom,top))
                break;

            // 3. print bottom row
            for(int j=right; j >=left; j--){
                spiralList.add(matrix[bottom][j]);
            }
            bottom--;
            if(boundriesCrossed(left,right,bottom,top))
                break;

            // 4. print leftmost column
            for(int i=bottom; i >= top; i--){
                spiralList.add(matrix[i][left]);
            }
            left++;
            if(boundriesCrossed(left,right,bottom,top))
                break;
        }// end while true

        return spiralList;
    }

    private boolean boundriesCrossed(int left,int right,int bottom,int top){
        if(left>right || bottom<top)
            return true;
        else
            return false;
    }
}
