class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key,int value) {
        this.key=key;
        this.value=value;
        prev=null;
        next=null;
    }
}

class DLL {
    Node head;
    Node tail;

    DLL() {
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }

    void insertAfterHead(Node node) {
        Node afterHeadNode=head.next;

        head.next=node;
        node.prev=head;

        node.next=afterHeadNode;
        afterHeadNode.prev=node;
    }

    void removeNode(Node node) {
        Node beforeNode=node.prev;
        Node afterNode=node.next;

        beforeNode.next=afterNode;
        afterNode.prev=beforeNode;
    }
}

class LRUCache {
    Map<Integer,Node> cache;
    int capacity;
    DLL dll;
    int currSize;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<>();
        dll=new DLL();
        currSize=0;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node=cache.get(key);
            dll.removeNode(node);
            dll.insertAfterHead(node);

            return node.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        //updating existing key with new value
        if (cache.containsKey(key)) {
            Node node=cache.get(key);
            node.value=value;
            dll.removeNode(node);
            dll.insertAfterHead(node);
            return;
        }

        if (currSize==capacity) {
            Node node=dll.tail.prev;
            cache.remove(node.key);
            dll.removeNode(node);
            currSize--;
        }

        Node newNode=new Node(key,value);
        cache.put(key,newNode);
        dll.insertAfterHead(newNode);
        currSize++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */