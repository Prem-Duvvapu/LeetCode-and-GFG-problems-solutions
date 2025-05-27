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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null)
            return head;

        ListNode curr=head;
        ListNode temp=new ListNode(-1);
        ListNode prev=temp;
        ListNode first=head;
        ListNode last=null;
        ListNode newFirst=null;
        ListNode newLast=null;
        int cnt=0;
        
        while (first!=null) {
            while (cnt<k && curr!=null) {
                last=curr;
                cnt++;
                curr=curr.next;
            }

            if (cnt<k)
                break;

            last.next=null;
            newFirst=reverseLL(first);
            newLast=first;

            prev.next=newFirst;
            prev=newLast;

            first=curr;
            cnt=0;
        }

        if (cnt>0)
            prev.next=first;

        return temp.next;
    }

    public ListNode reverseLL(ListNode head) {
        if (head==null || head.next==null)
            return head;

        ListNode prev=null;
        ListNode curr=head;

        while (curr!=null) {
            ListNode nextNode=curr.next;

            curr.next=prev;

            prev=curr;
            curr=nextNode;
        }

        return prev;
    }
}