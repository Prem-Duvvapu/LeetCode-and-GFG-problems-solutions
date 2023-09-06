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
        if (head==null)
            return head;

        int n=0;
        ListNode temp=head;
        while (temp!=null)
        {
            n++;
            temp=temp.next;
        }

        k=k%n;
        if (k==0)
            return head;

        ListNode curr=head;

        for (int i=1;i<n-k;i++)        
            curr=curr.next;
        
        ListNode newHead=curr.next;
        curr.next=null;
        curr=newHead;
        while (curr.next!=null)
            curr=curr.next;

        curr.next=head;
        return newHead;
    }
}