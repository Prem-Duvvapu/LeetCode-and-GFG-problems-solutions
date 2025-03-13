class Node {
    Node prev;
    int key;
    int value;
    Node next;

    Node() {
    }
    
    Node(int key,int value) {
        prev=null;
        next=null;
        this.key=key;
        this.value=value;
    }
}

class LRUCache {
    Node head;
    Node tail;
    Map<Integer,Node> map;
    int capacity;

    public LRUCache(int capacity) {
        head=new Node();
        tail=new Node();
        map=new HashMap<>();
        this.capacity=capacity;

        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node currNode=map.get(key);
        currNode.prev.next=currNode.next;
        currNode.next.prev=currNode.prev;

        currNode.next=head.next;
        head.next.prev=currNode;
        head.next=currNode;
        currNode.prev=head;

        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value=value;

            Node currNode=map.get(key);
            currNode.prev.next=currNode.next;
            currNode.next.prev=currNode.prev;

            currNode.next=head.next;
            head.next.prev=currNode;
            head.next=currNode;
            currNode.prev=head;

        } else {
            Node newNode=new Node(key,value);
            if (map.size()<capacity) {
                map.put(key,newNode);
                
                newNode.next=head.next;
                head.next.prev=newNode;
                head.next=newNode;
                newNode.prev=head;
            } else {
                Node lastNode=tail.prev;

                map.remove(lastNode.key);
                lastNode.prev.next=tail;
                tail.prev=lastNode.prev;

                map.put(key,newNode);
                newNode.next=head.next;
                head.next.prev=newNode;
                head.next=newNode;
                newNode.prev=head;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */