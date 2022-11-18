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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        
        if (list2 == null) {
            return list1;
        }
        
        ListNode head1 = list1;
        ListNode head2 = list2;
        
        ListNode newHead;
        if (head1.val <= head2.val) {
            newHead = head1;
            head1 = head1.next;
        } else {
            newHead = head2;
            head2 = head2.next;
        }
        
        ListNode newHeadToReturn = newHead;
        
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                newHead.next = head1;
                
                head1 = head1.next;
            } else {
                newHead.next = head2;
                
                head2 = head2.next;
            }
            
            newHead = newHead.next;
        }
        
        while (head1 != null) {
            newHead.next = head1;
            head1 = head1.next;
            
            
            newHead = newHead.next;
        }
        
        while (head2 != null) {
            newHead.next = head2;
            head2 = head2.next;
            
            
            newHead = newHead.next;
        }
        
        newHead.next = null;
        
        
        return newHeadToReturn;
    }
}