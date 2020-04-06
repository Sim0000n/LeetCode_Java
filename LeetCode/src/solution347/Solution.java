package solution347;

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i : nums) {
            if(hashMap.containsKey(i)) {
                int tmp = hashMap.get(i);
                hashMap.put(i, ++tmp);
            } else {
                hashMap.put(i, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        List<Integer> result = new ArrayList<>(k);
        for(int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }
}
