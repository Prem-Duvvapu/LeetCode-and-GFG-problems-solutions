class Solution {
    private int helper(int[] t,int[] b,int val)
    {
        int topVal=0;
        int bottomVal=0;

        for (int i=0;i<t.length;i++)
        {
            if (t[i]!=val && b[i]!=val)
                return -1;

            if (t[i]!=val)
                topVal++;

            if (b[i]!=val)
                bottomVal++;
        }

        return Math.min(topVal,bottomVal);
    }

    public int minDominoRotations(int[] tops, int[] bottoms)
    {
        int res=-1;

        for (int i=1;i<=6;i++)
        {
            int curr=helper(tops,bottoms,i);

            if (curr!=-1 && (res==-1 || curr<res))
                res=curr;
            System.out.println(i+" "+curr+" "+res);
        }

        return res;
    }
}