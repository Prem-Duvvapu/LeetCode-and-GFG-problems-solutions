//Space Optimization

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int[] prev=new int[n];

        for (int i=0;i<n;i++)
            prev[i]=grid[0][i];

        for (int i=1;i<n;i++)
        {
            int[] curr=new int[n];
            for (int j=0;j<n;j++)
            {
                int minVal=Integer.MAX_VALUE;
                for (int k=0;k<n;k++)
                {
                    if (k!=j)
                        minVal=Math.min(minVal,prev[k]);
                }
                curr[j]=grid[i][j]+minVal;
            }
            System.arraycopy(curr,0,prev,0,n);
        }

        int minVal=Integer.MAX_VALUE;
        for (int i=0;i<n;i++)
            minVal=Math.min(prev[i],minVal);

        return minVal;
    }
}