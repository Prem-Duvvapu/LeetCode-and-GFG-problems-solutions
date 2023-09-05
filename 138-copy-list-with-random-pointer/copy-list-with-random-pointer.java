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
        Node temp=head;

        Node dummy=new Node(0);
        Node curr=dummy;

        Map<Node,Node> map=new HashMap<>();

        while (temp!=null)
        {
            Node newNode=new Node(temp.val);
            map.put(temp,newNode);
            curr.next=newNode;
            curr=newNode;
            temp=temp.next;
        }

        temp=head;
        curr=dummy.next;
        while (curr!=null)
        {
            curr.random=map.get(temp.random);
            curr=curr.next;
            temp=temp.next;
        }

        return dummy.next;
    }
}