//optimial

/*
1st term: 1
2nd term: 1+4 = (1+4*1)
3rd term: 1+4+8 = (1+4*1+4*2)
.
.
.
.
nth term: 1+4*1+4*2+.....+4*(n-1) = 1+4*(1+2+3+...+n-1)
*/


class Solution {
    public long coloredCells(int n) {
        long res=1+2*((long)n*(n-1));
        return res;
    }
}