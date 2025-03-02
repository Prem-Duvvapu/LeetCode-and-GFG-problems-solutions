class Solution {
    public int minBitFlips(int start, int goal) {
        int diff=start^goal;
        int res=0;

        while (diff>1) {
            res+=(diff&1);
            diff>>=1;
        }

        if (diff==1)
            res+=1;

        return res;
    }
}