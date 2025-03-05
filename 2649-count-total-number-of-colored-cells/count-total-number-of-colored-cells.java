//brute
class Solution {
    public long coloredCells(int n) {
        long res=1;
        long prev=0;

        for (int i=2;i<=n;i++) {
            prev=prev+4;
            res+=prev;
        }

        return res;
    }
}