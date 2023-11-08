class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int xdiff=Math.abs(sx-fx);
        int ydiff=Math.abs(sy-fy);
        int minDistance=Math.max(xdiff,ydiff);

        if (xdiff==0 && ydiff==0 && t==1)
            return false;

        if (t<minDistance)
            return false;

        return true;
    }
}