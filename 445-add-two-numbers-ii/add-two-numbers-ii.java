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
    private ListNode reverse(ListNode head)
    {
        if (head==null || head.next==null)
            return head;

        ListNode newNode=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverse(l1);
        l2=reverse(l2);

        ListNode res=new ListNode(0);
        ListNode curr=res;
        int val1,val2,sum,digit,carry=0;

        while (l1!=null && l2!=null)
        {
            val1=l1.val;
            val2=l2.val;
            sum=val1+val2+carry;
            digit=sum%10;
            carry=sum/10;
            ListNode temp=new ListNode(digit);
            curr.next=temp;
            curr=temp;
            l1=l1.next;
            l2=l2.next;
        }

        while (l1!=null)
        {
            val1=l1.val;
            sum=val1+carry;
            digit=sum%10;
            carry=sum/10;
            ListNode temp=new ListNode(digit);
            curr.next=temp;
            curr=temp;
            l1=l1.next;
        }

        while (l2!=null)
        {
            val2=l2.val;
            sum=val2+carry;
            digit=sum%10;
            carry=sum/10;
            ListNode temp=new ListNode(digit);
            curr.next=temp;
            curr=temp;
            l2=l2.next;
        }

        if (carry==1)
            curr.next=new ListNode(1);

        res=reverse(res.next);
        return res;
    }
}