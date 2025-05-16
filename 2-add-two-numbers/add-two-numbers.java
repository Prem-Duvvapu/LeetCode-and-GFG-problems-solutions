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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //edge cases
        if (l1==null)
            return l2;
        
        if (l2==null)
            return l1;
            
        ListNode sumHead=new ListNode(-1);
        int carry=0;

        ListNode p1=l1;
        ListNode p2=l2;
        ListNode temp=sumHead;

        while (p1!=null && p2!=null) {
            int currVal=p1.val+p2.val+carry;

            carry=currVal/10;
            currVal=currVal%10;

            ListNode newNode=new ListNode(currVal);
            temp.next=newNode;
            temp=newNode;

            p1=p1.next;
            p2=p2.next;
        }

        while (p1!=null) {
            int currVal=p1.val+carry;

            carry=currVal/10;
            currVal=currVal%10;

            ListNode newNode=new ListNode(currVal);
            temp.next=newNode;
            temp=newNode;

            p1=p1.next;
        }

        while (p2!=null) {
            int currVal=p2.val+carry;

            carry=currVal/10;
            currVal=currVal%10;

            ListNode newNode=new ListNode(currVal);
            temp.next=newNode;
            temp=newNode;

            p2=p2.next;
        }

        if (carry>0) {
            ListNode newNode=new ListNode(carry);
            temp.next=newNode;
            temp=newNode;
        }
    
        return sumHead.next;
    }
}