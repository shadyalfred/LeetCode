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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        var curr = dummy;
        
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 != null? l1.val : 0;
            int v2 = l2 != null? l2.val : 0;
            
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            sum %= 10;
            
            curr.next = new ListNode(sum);
            
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            
            curr = curr.next;
        }
        
        return dummy.next;
    }
}