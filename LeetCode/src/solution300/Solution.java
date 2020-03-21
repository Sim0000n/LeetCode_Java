package solution300;

import java.util.ArrayList;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if(length == 0)
            return 0;
        if(length == 1)
            return 1;
        int[] dp = new int[length];
        dp[0] = 1;
        int maxans = 1;
        int maxval = 1;
        for(int i = 1; i < length; i++) {
            for(int j = 0; j < i; j++) {
                maxval = 1;
                if(nums[j] < nums[i]) {
                    maxval = Math.max(maxval, dp[j] + 1);
                }
            }
            dp[i] = maxval;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
