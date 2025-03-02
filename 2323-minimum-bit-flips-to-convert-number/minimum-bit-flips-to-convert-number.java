class Solution {
    public int minBitFlips(int start, int goal) {
        int diff=start^goal;
        int res=0;

        for (int i=0;i<31;i++)
            res+=(diff>>i)&1;

        return res;
    }
}