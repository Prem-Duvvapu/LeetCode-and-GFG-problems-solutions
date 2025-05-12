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
    public boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null)
            return true;

        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        if (fast!=null)
            slow=slow.next;

        ListNode revHead=reverseLL(slow);

        ListNode temp1=head;
        ListNode temp2=revHead;
        System.out.println(temp1.val+" "+temp2.val);

        while (temp2!=null) {
            if (temp1.val!=temp2.val)
                return false;

            temp1=temp1.next;
            temp2=temp2.next;
        }            

        return true;
    }

    public ListNode reverseLL(ListNode head) {
        if (head==null || head.next==null)
            return head;

        ListNode prev=null;
        ListNode curr=head;

        while (curr!=null) {
            ListNode next=curr.next;
            curr.next=prev;

            prev=curr;
            curr=next;
        }

        return prev;
    }
}