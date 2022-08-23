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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head, previous = null;
        
        for (int i = 0; current != null & i < left - 1; i++) {
            previous = current;
            current = current.next;
        }
        
        ListNode lastNodeOfFirstPart = previous;
        ListNode lastNodeOfSublist = current;
        
        ListNode next = null;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        if (lastNodeOfFirstPart != null)
            lastNodeOfFirstPart.next = previous;
        else
            head = previous;
        
        lastNodeOfSublist.next = current;
        
        return head;
        
    }
}