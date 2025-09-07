class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key,int val) {
        this.key = key;
        this.val = val;
    }
}

class DLL {
    Node head;
    Node tail;

    DLL() {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    void addToLast(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        
        node.prev.next = node;
        node.next.prev = node;
    }

    void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;

        node.next = null;
        node.prev = null;
    }

    void addToFront(Node node) {
        node.prev = head;
        node.next = head.next;

        node.next.prev = node;
        node.prev.next = node;
    }

    Node removeLastNode() {
        Node removedNode = tail.prev;

        removedNode.prev.next = tail;
        tail.prev = removedNode.prev;
        
        removedNode.next = null;
        removedNode.prev = null;

        return removedNode;
    }
}

class LRUCache {
    Map<Integer,Node> map;
    int capacity;
    DLL dll;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        dll = new DLL();
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node resNode = map.get(key);

        dll.removeNode(resNode);
        dll.addToFront(resNode);

        return resNode.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            dll.removeNode(node);
            dll.addToFront(node);
        } else {
            if (map.size() >= capacity) {
                Node removedNode = dll.removeLastNode();
                map.remove(removedNode.key);
            }

            Node node = new Node(key,value);
            dll.addToFront(node);
            map.put(key,node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */