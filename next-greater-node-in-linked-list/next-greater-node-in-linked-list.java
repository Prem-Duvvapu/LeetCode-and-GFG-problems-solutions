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

 //monotonic Stack
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ll=new ArrayList<>();
        ListNode temp=head;

        while (temp!=null)
        {
            ll.add(temp.val);
            temp=temp.next;
        }

        int n=ll.size();
        int[] res=new int[n];
        Stack<Integer> mStack=new Stack<>();
        for (int i=0;i<n;i++)
        {
            while (!mStack.isEmpty() && ll.get(i)>ll.get(mStack.peek()))
            {
                int index=mStack.pop();
                res[index]=ll.get(i);
            }
            mStack.push(i);
        }

        return res;
    }
}