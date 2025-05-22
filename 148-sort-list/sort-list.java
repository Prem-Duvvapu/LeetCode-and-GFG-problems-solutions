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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head==null || head.next==null)
            return head;

        ListNode leftHead=head;
        ListNode middleNode=findMiddleNode(head);
        ListNode rightHead=middleNode.next;
        middleNode.next=null;

        leftHead=mergeSort(leftHead);
        rightHead=mergeSort(rightHead);

        return merge(leftHead,rightHead);
    }

    private ListNode merge(ListNode leftHead,ListNode rightHead) {
        ListNode tempHead=new ListNode(-1);
        ListNode temp=tempHead;

        while (leftHead!=null && rightHead!=null) {
            if (leftHead.val<=rightHead.val) {
                temp.next=leftHead;
                leftHead=leftHead.next;
                temp=temp.next;
            } else {
                temp.next=rightHead;
                rightHead=rightHead.next;
                temp=temp.next;
            }
        }

        if (leftHead!=null)
            temp.next=leftHead;

        if (rightHead!=null)
            temp.next=rightHead;

        return tempHead.next;
    }

    private ListNode findMiddleNode(ListNode head) {
        if (head==null || head.next==null)
            return head;

        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null && fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }
}