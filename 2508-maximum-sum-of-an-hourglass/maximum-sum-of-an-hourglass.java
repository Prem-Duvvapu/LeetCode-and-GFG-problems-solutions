class Solution {
    public int maxSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int maxVal=0;

        for (int i=2;i<m;i++)
        {
            for (int j=2;j<n;j++)
            {
                int currVal=grid[i][j]+grid[i][j-1]+grid[i][j-2]+grid[i-1][j-1]+grid[i-2][j]+grid[i-2][j-1]+grid[i-2][j-2];
                maxVal=Math.max(maxVal,currVal);
            }
        }

        return maxVal;
    }
}