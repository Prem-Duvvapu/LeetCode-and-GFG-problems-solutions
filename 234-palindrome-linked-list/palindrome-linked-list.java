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

        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null && fast.next!=null) {
            fast=fast.next.next;
            ListNode nextNode=slow.next;
            slow.next=prev;

            prev=slow;
            slow=nextNode;
        }

        if (fast!=null)
            slow=slow.next;

        ListNode revFirstHalf=prev;
        ListNode secondHalf=slow;

        while (secondHalf!=null) {
            if (revFirstHalf.val!=secondHalf.val)
                return false;

            revFirstHalf=revFirstHalf.next;
            secondHalf=secondHalf.next;
        }

        return true;
    }
}