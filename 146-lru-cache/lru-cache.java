class LRUCache {

    class Node
    {
        Node prev,next;
        int key,val;
        Node(int key,int val)
        {
            this.key=key;
            this.val=val;
        }
    }

    private void insert(Node node)
    {
        map.put(node.key,node);
        node.next=head.next;
        head.next=node;
        node.next.prev=node;
        node.prev=head;
    }

    private void remove(Node node)
    {
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    
    Map<Integer,Node> map=new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if (map.containsKey(key))
        {
            Node node=map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key))
        {
            remove(map.get(key));
        }

        if (map.size()==capacity)
        {
            remove(tail.prev);
        }

        Node newNode=new Node(key,value);
        insert(newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */