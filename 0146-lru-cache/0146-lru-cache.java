class LRUCache {
    class Node {
        public Node prev;
        public Node next;
        public int value;
        public int key;
        
        public Node() {}
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.head = new Node();
        this.tail = new Node();
        
        this.head.next = this.tail;
        this.tail.prev = this.head;
        
        this.capacity = capacity;
        
        this.map = new HashMap();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        var node = map.get(key);
        
        removeNode(node);
        insertNode(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        }
        
        var node = new Node(key, value);
        insertNode(node);
        map.put(key, node);
        
        if (map.size() > capacity) {
            var lru = this.head.next;
            removeNode(lru);
            map.remove(lru.key);
        }
    }
    
    private void removeNode(Node node) {
        var prevNode = node.prev;
        var nextNode = node.next;
        
        node.prev.next = nextNode;
        node.next.prev = prevNode;
        
        node.next = null;
        node.prev = null;
    }
    
    private void insertNode(Node node) {
        var temp = this.tail.prev;
        this.tail.prev = node;
        node.next = this.tail;
        
        node.prev = temp;
        temp.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */