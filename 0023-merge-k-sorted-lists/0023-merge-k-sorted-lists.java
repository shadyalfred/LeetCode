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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> minHeap = new PriorityQueue();
        
        for (var node : lists) {
            var current = node;
            while (current != null) {
                minHeap.add(current.val);
                current = current.next;
            }
        }
        
        var dummy = new ListNode();
        var current = dummy;
        
        while (!minHeap.isEmpty()) {
            current.next = new ListNode(minHeap.poll());
            current = current.next;
        }
        
        return dummy.next;
    }
}