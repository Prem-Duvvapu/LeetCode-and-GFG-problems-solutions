class Solution {
    public int totalMoney(int n) {
        int prev=1;
        int mon=1;
        int res=0;
        for (int i=1;i<=n;i++)
        {
            res+=prev;
            prev++;
            if (i%7==0)
                prev=++mon;
        }
        return res;
    }
}