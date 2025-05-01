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
        int k=lists.length;
        ListNode head=new ListNode(-1);
        ListNode temp=head;
        ListNode[] currNodes=new ListNode[k];
        PriorityQueue<ListNode> pq=new PriorityQueue<>((x,y)->Integer.compare(x.val,y.val));

        for (int i=0;i<k;i++)
            if (lists[i]!=null)
                pq.add(lists[i]);

        while (!pq.isEmpty()) {
            ListNode currNode=pq.poll();
            ListNode nextNode=currNode.next;

            temp.next=currNode;
            temp=temp.next;

            if (nextNode!=null)
                pq.add(nextNode);
        }

        return head.next;
    }
}