class Solution {
    public int getLastMoment(int n, int[] left, int[] right)
    {
        int ans=0;
        for (int val: left)
            ans=Math.max(ans,val);
        for (int val: right)
            ans=Math.max(ans,n-val);

        return ans;
    }
}