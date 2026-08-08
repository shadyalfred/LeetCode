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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        return previous;
    }
}