package leetcode.stars;

/**
 * Created by hchang on 6/30/16.
 * Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int p = quickSelect(nums, 0, n - 1, n - k + 1);
        return nums[p];
    }

    // return the index of the kth smallest number
    int quickSelect(int[] a, int lo, int hi, int k) {
        int i = lo, j = hi, pivot = a[hi];
        while (i < j) {
            if (a[i++] > pivot) swap(a, --i, --j);
        }
        swap(a, i, hi);
        int m = i - lo + 1;
        if (m == k)     return i;
        else if (m > k) return quickSelect(a, lo, i - 1, k);
        else            return quickSelect(a, i + 1, hi, k - m);
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
