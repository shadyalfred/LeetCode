/**
 * Definition for singly-linked list.
 * public class ListNode
 * {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null)
 *     {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution
{
    public void ReorderList(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode firstHead = head;
        ListNode secondHead = Reverse(slow);
        
        while (firstHead != null && secondHead != null)
        {
            ListNode temp = firstHead.next;
            firstHead.next = secondHead;
            firstHead = temp;
            
            temp = secondHead.next;
            secondHead.next = firstHead;
            secondHead = temp;
        }
        
        if (firstHead != null)
        {
            firstHead.next = null;
        }
    }
    private ListNode Reverse(ListNode head)
    {
        ListNode prev = null;
        
        while (head != null)
        {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
}