package solution215;

public class Solution {
    private int result = 1;

    public int findKthLargest(int[] nums, int k) {
        int l = nums.length;
        quickFindKthLargest(nums, 0, l - 1, k - 1);
        return result;
    }

    private void quickFindKthLargest(int[] nums, int low, int high, int k) {
        if(low >= high)
            return;
        int j = partition(nums, low, high);
        if(j == k) {
            result = nums[j];
            return;
        } else {
            quickFindKthLargest(nums, low, j - 1, k);
            if(j < k)
                quickFindKthLargest(nums, j + 1, high, k);
        }
        result = nums[k];
    }

    private int partition(int[] nums, int low, int high) {
        int num = nums[low];
        int i = low, j = high + 1;
        while(true) {
            while(num < nums[++i]) {
                if(i == high)
                    break;
            }
            while(num > nums[--j]) {
                if(j == low)
                    break;
            }
            if(i >= j)
                break;
            swap(nums, i, j);
        }
        if(j != low)
            swap(nums, low, j);
        return j;
    }

    private void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] + nums[b];
        nums[b] = nums[a] - nums[b];
        nums[a] = nums[a] - nums[b];
    }

}
