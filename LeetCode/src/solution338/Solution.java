package solution338;

public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int flag = 2;
        result[0] = 0;
        if(num == 0)
            return result;
        result[1] = 1;
        int j = 0;
        for(int i = 2; i <= num; i++) {
            if(j == flag) {
                j = 0;
                flag *= 2;
            }
            result[i] = result[i - flag] + 1;
            j++;
        }
        return result;
    }
}
