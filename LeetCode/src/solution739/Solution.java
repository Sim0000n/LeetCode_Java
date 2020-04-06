package solution739;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        stack.push(0);
        for(int i = 1; i < T.length; i++) {
            while(true) {
                if(stack.empty())
                    break;
                if(T[i] > T[stack.peek()]) {
                    int current = stack.pop();
                    result[current] = i - current;
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        return result;
    }
}
