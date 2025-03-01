class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int n=original.length;
        int res=(bounds[n-1][1]-bounds[n-1][0]+1);

        if (res<=0)
            return 0;


        for (int i=n-2;i>=0;i--) {
            int diff=original[i+1]-original[i];

            int currHigh=bounds[i+1][1]-diff;
            int currLow=bounds[i+1][0]-diff;
            int currRes=Math.min(bounds[i][1],currHigh)-Math.max(bounds[i][0],currLow)+1;

            bounds[i][1]=Math.min(bounds[i][1],currHigh);
            bounds[i][0]=Math.max(bounds[i][0],currLow);
            
            if (currRes<=0)
                    return 0;

            res=Math.min(res,currRes);
        }

        return res;
    }
}