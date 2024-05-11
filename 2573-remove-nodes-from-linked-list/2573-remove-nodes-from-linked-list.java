/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        List<Integer> stack = new ArrayList<>();

        while (head != null) {
            while (!stack.isEmpty() && head.val > stack.getLast()) {
                stack.removeLast();
            }

            stack.add(head.val);

            head = head.next;
        }

        ListNode newHead = new ListNode();
        ListNode current = newHead;

        for (int val : stack) {
            current.next = new ListNode(val);
            current = current.next;
        }
        
        return newHead.next;
    }
}