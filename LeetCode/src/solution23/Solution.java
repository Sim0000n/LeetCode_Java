package solution23;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(ListNode n : lists) {
            while(n!=null) {
                queue.add(n.val);
                n = n.next;
            }
        }
        ListNode root = new ListNode(0);
        ListNode node = root;
        while(!queue.isEmpty()) {
            ListNode newNode = new ListNode(queue.poll());
            node.next = newNode;
            node = newNode;
        }
        return root.next;
    }

//    public ListNode mergeKLists(ListNode[] lists) {
//        ArrayList<Integer> list = new ArrayList<>();
//        for(ListNode n : lists) {
//            while(n!=null) {
//                list.add(n.val);
//                n = n.next;
//            }
//        }
//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        ListNode root = new ListNode(0);
//        ListNode node = root;
//        for(Integer i:list) {
//            ListNode newNode = new ListNode(i);
//            node.next = newNode;
//            node = node.next;
//        }
//        return root.next;
//    }

//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode root = new ListNode(0);
//        ListNode node = root;
//        boolean hasVal = false;
//        while(true){
//            int m = 0;
//            int minimalValue = Integer.MAX_VALUE;
//            hasVal = false;
//            for(int i = 0; i < lists.length; i++) {
//                if(lists[i] == null)
//                    continue;
//                if(lists[i].val < minimalValue) {
//                    m = i;
//                    minimalValue = lists[i].val;
//                    hasVal = true;
//                }
//            }
//            if(!hasVal)
//                break;
//            ListNode newNode = new ListNode(lists[m].val);
//            node.next = newNode;
//            node = newNode;
//            lists[m] = lists[m].next;
//        }
//
//        return root.next;
//    }
}
