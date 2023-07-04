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

class Solution
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode result=new ListNode(0);
        ListNode curr=result;
        int a,b,c,d,e=0;
        while (l1!=null && l2!=null)
        {
            a=l1.val;
            b=l2.val;
            c=a+b+e;
            d=c%10;
            ListNode n=new ListNode(d);
            curr.next=n;
            curr=curr.next;
            l1=l1.next;
            l2=l2.next;
            e=c/10;
        }

        while (l1!=null)
        {
            a=l1.val;
            c=a+e;
            d=c%10;
            ListNode n1=new ListNode(d);
            curr.next=n1;
            curr=curr.next;
            l1=l1.next;
            e=c/10;
        }

        while (l2!=null)
        {
            b=l2.val;
            c=b+e;
            d=c%10;
            ListNode n2=new ListNode(d);
            curr.next=n2;
            curr=curr.next;
            l2=l2.next;
            e=c/10;
        }

        if (e==1)
            curr.next=new ListNode(1);

        return result.next;
    }
}