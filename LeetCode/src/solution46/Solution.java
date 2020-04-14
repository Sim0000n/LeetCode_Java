package solution46;

import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> nums1 = new ArrayList<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            nums1.add(nums[i]);
        }
        backTrack(nums1, result, 0);
        return result;
    }

    private void backTrack(ArrayList nums, List<List<Integer>> result, int first) {
        if(first == nums.size()) {
            result.add(new ArrayList<>(nums));
        }
        for(int i = first; i < nums.size(); i++) {
            Collections.swap(nums, i, first);
            backTrack(nums, result, first + 1);
            Collections.swap(nums, i, first);
        }
    }


}