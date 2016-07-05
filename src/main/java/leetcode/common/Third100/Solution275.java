package leetcode.common.Third100;

/**
 * Created by Jason on 7/3/16.
 * H-Index II
 *
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

 Hint:

 Expected runtime complexity is in O(log n) and the input is sorted.
 */
public class Solution275 {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int l = 0, r = citations.length;
        int n = citations.length;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(citations[mid] == n - mid) return n - mid;
            if(citations[mid] < citations.length - mid) l = mid + 1;
            else r = mid;
        }
        return n - l;
    }
}
