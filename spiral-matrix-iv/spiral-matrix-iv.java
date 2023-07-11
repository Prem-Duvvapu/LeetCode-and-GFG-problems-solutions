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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res=new int[m][n];
        int rowStart=0;
        int rowEnd=m-1;
        int colStart=0;
        int colEnd=n-1;

        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                res[i][j]=-1;

        ListNode temp=head;
        while (rowStart<=rowEnd && colStart<=colEnd && temp!=null)
        {
            for (int i=colStart;i<=colEnd && temp!=null;i++)
            {
                res[rowStart][i]=temp.val;
                temp=temp.next;
            }
            rowStart++;

            for (int i=rowStart;i<=rowEnd && temp!=null;i++)
            {
                res[i][colEnd]=temp.val;
                temp=temp.next;
            }
            colEnd--;

            if (rowStart<=rowEnd)
            {
                for (int i=colEnd;i>=colStart && temp!=null;i--)
                {
                    res[rowEnd][i]=temp.val;
                    temp=temp.next;
                }
                rowEnd--;
            }

            if (colStart<=colEnd)
            {
                for (int i=rowEnd;i>=rowStart && temp!=null;i--)
                {
                    res[i][colStart]=temp.val;
                    temp=temp.next;
                }
                colStart++;
            }
        }

        return res;
    }
}