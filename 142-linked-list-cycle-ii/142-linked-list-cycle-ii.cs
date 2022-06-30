/**
 * Definition for singly-linked list.
 * public class ListNode
 * {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x)
 *     {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution
{
    public ListNode DetectCycle(ListNode head)
    {
        int? cycleLength = null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast)
            {
                cycleLength = CalculateCycleLength(slow);
                break;
            }
        }
        
        if (cycleLength.HasValue)
        {
            return FindCycleBeginning(head, cycleLength.Value);
        }
        
        return null;
    }
    
    private int CalculateCycleLength(ListNode pointer1)
    {
        int length = 0;
        
        ListNode pointer2 = pointer1;
        
        do
        {
            pointer2 = pointer2.next;
            length++;
        }
        while (pointer2 != pointer1);
        
        return length;
    }
    
    private ListNode FindCycleBeginning(ListNode head, int cycleLength)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        while (cycleLength > 0)
        {
            fast = fast.next;
            cycleLength--;
        }
        
        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}