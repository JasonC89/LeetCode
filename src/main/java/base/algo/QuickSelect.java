package base.algo;

/**
 * Created by Jason on 6/11/16.
 */
public class QuickSelect {
    public int findKthSmall(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }
        return getKth(k, nums, 0, nums.length - 1);
    }

    public int getKth(int k, int[] nums, int start, int end) {
        int pivot = nums[end];
        int left = start;
        int right = end;

        while (true) {
            while (nums[left] < pivot && left < right) {
                left++;
            }
            while (nums[right] >= pivot && right > left) {
                right--;
            }
            if (left == right) {
                break;
            }
            swap(nums, left, right);
        }

        swap(nums, left, end);
        int m = left - start + 1;
        if (k == m) {
            return pivot;
        } else if (k < m) {
            return getKth(k, nums, start, left - 1);
        } else {
            return getKth(m, nums, left + 1, end);
        }
    }

    public void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }

    static public void main(String[] args) {
        QuickSelect quickSelect = new QuickSelect();
        int result = quickSelect.findKthSmall(new int[]{3,5,1,3,5,2}, 4);
        System.out.println(result);
    }
}
