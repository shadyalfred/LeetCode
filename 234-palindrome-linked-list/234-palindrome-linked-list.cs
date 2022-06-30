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
    public bool IsPalindrome(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode headReversedSecondHalf = Reverse(slow);
        ListNode headFirstHalf = head;
        
        while (headFirstHalf != null && headReversedSecondHalf != null)
        {
            if (headFirstHalf.val != headReversedSecondHalf.val)
            {
                return false;
            }
            headFirstHalf = headFirstHalf.next;
            headReversedSecondHalf = headReversedSecondHalf.next;
        }
        
        return true;
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