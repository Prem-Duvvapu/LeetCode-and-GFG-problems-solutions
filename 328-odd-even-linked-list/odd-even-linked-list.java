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
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null)
            return head;

        ListNode evenHead=head.next;

        ListNode oddCurr=head;
        ListNode evenCurr=head.next;

        ListNode oddNext=head;
        ListNode evenNext=head.next;

        while (evenCurr!=null && evenCurr.next!=null) {
            if (oddCurr.next!=null)
                oddNext=oddCurr.next.next;

            if (evenCurr.next!=null)
                evenNext=evenCurr.next.next;

            oddCurr.next=oddNext;
            evenCurr.next=evenNext;

            oddCurr=oddNext;
            evenCurr=evenNext;
        }

        oddNext.next=evenHead;
        return head;
    }
}