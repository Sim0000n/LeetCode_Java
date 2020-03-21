package solution409;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        int length = s.length();
        int result = 0;
        if(length == 0)
            return result;
        if(length == 1)
            return ++result;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if(hashMap.containsKey(currentChar)) {
                int currentInt = hashMap.get(currentChar);
                hashMap.put(currentChar, ++currentInt);
            } else {
                hashMap.put(currentChar, 1);
            }
        }
        boolean check = false;
        for(Map.Entry<Character, Integer> e : hashMap.entrySet()) {
            int i = e.getValue();
            if( i % 2 == 1) {
                if(!check) {
                    result += i;
                    check = true;
                } else {
                    result += i - 1;
                }
            } else {
                result += i;
            }
        }
        return result;
    }
}
