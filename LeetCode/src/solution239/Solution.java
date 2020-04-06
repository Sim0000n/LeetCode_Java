package solution239;

import java.util.*;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        deque.add(0);
        if(nums.length == 1) {
            result[0] = nums[0];
            return result;
        }
        for(int i = 1; i < k; i++) {
            moveAndClean(nums, deque, i, k);
        }
        result[0] = nums[deque.getFirst()];
        for(int i = k; i < nums.length; i++) {
            moveAndClean(nums, deque, i, k);
            result[i - k + 1] = nums[deque.getFirst()];
        }
        return result;
    }

    private void moveAndClean(int nums[], ArrayDeque<Integer> deque,int i, int k) {
        if(!deque.isEmpty()) {
            if(deque.getFirst() == i - k)
                deque.removeFirst();
            while(!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
        }
        deque.addLast(i);
    }

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
//        int[] result = new int[1 + nums.length - k];
//        for(int i = 0; i < k; i++) {
//            queue.add(nums[i]);
//        }
//        result[0] = queue.peek();
//        for(int i = 0; i < result.length - 1; i++) {
//            queue.remove(nums[i]);
//            queue.add(nums[i + k]);
//            result[i + 1] = queue.peek();
//        }
//        return result;
//    }
}
