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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int x=1;
        ListNode curr=list1;

        while (x++<a) {
            curr=curr.next;
        }

        ListNode temp=curr.next;
        curr.next=list2;
        curr=curr.next;

        while (curr.next!=null)
            curr=curr.next;

        while (x++<=b)
            temp=temp.next;

        curr.next=temp.next;

        return list1;
    }
}