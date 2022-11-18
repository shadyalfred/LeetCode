/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Node dummy = new Node(0);
        
        Node current = head;
        Node newCurrent = dummy;
        
        Map<Node, Node> map = new HashMap();
        
        while (current != null) {
            var node = new Node(current.val);
            newCurrent.next = node;
            
            map.put(current, node);
            
            newCurrent = newCurrent.next;
            current = current.next;
        }
        
        current = head;
        newCurrent = dummy.next;
        
        while (current != null) {
            if (current.random != null) {
                newCurrent.random = map.get(current.random);
            }
            
            current = current.next;
            newCurrent = newCurrent.next;
        }
        
        return dummy.next;
    }
}