package solution169;
/* 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

        你可以假设数组是非空的，并且给定的数组总是存在多数元素。

        示例 1:

        输入: [3,2,3]
        输出: 3
        示例 2:

        输入: [2,2,1,1,1,2,2]
        输出: 2

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/majority-element
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class Solution {

    private Node root;
    private int targetKey;
    private boolean check = false;

    private class Node {
        int key;
        int nums;
        Node left;
        Node right;
        Node(int key) {
            this.key = key;
            this.nums = 1;
        }
    }

    public int majorityElement(int[] nums) {
        int length = nums.length;
        if(length == 1 || length == 2)
            return nums[0];
        for(int i = 0; i < length && !check; i++) {
            add(nums[i], length / 2);
        }
        return targetKey;
    }

    private void add(int key, int target) {
        root = add(root, key, target);
    }

    private Node add(Node node, int key, int target) {
        if(node == null)
            return new Node(key);
        if(key < node.key) {
            node.left = add(node.left, key, target);
        } else if(key > node.key) {
            node.right = add(node.right, key, target);
        } else {
            if(++node.nums > target) {
                targetKey = node.key;
                check = true;
                return node;
            }
        }
        return node;
    }
}
