class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l=0,r=0,u=0;

        for (char ch: moves.toCharArray())
        {
            if (ch=='L')
                l++;
            else if (ch=='R')
                r++;
            else
                u++;
        }

        int res=Math.abs(l-r)+u;
        return res;
    }
}