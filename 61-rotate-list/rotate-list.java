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
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null)
            return head;
        
        int len=0;
        ListNode temp=head;
        ListNode lastNode=null;

        while (temp!=null) {
            len++;
            lastNode=temp;
            temp=temp.next;
        }

        k=k%len;
        if (k==0)
            return head;

        ListNode kthNodeFromLast=kthLastNode(head,k);
        lastNode.next=head;
        return kthNodeFromLast;
    }

    public ListNode kthLastNode(ListNode head,int k) {
        ListNode first=head;

        for (int i=0;i<k;i++)
            first=first.next;

        ListNode second=head;
        ListNode prev=null;

        while (first!=null) {
            first=first.next;
            prev=second;
            second=second.next;
        }

        prev.next=null;
        return second;
    }
}