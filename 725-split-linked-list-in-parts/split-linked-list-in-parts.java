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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res=new ListNode[k];

        int n=0;
        ListNode temp=head;
        while (temp!=null)
        {
            n++;
            temp=temp.next;
        }

        int q=n/k;
        int r=n%k;
        ListNode subHead=head;

        for (int i=0;i<k;i++)
        {
            ListNode curr=subHead;
            for (int j=0;j<q-1;j++)
                curr=curr.next;

            if (r>0)
            {
                if (q>0)
                    curr=curr.next;
                r--;
            }

            res[i]=subHead;
            subHead=null;
            if (curr!=null && curr.next!=null)
            {
                subHead=curr.next;
                curr.next=null;
            }
        }

        return res;
    }
}