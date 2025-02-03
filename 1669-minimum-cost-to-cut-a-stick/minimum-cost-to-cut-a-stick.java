class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] arr=new int[cuts.length+2];
        int m=arr.length;
        int[][] dp=new int[m][m];

        for (int i=0;i<m;i++)
            for (int j=0;j<m;j++)
                dp[i][j]=-1;

        arr[0]=0;
        arr[m-1]=n;

        for (int i=0;i<cuts.length;i++)
            arr[i+1]=cuts[i];

        return solve(1,m-2,arr,dp);
    }

    private int solve(int i,int j,int[] arr,int[][] dp) {
        if (i>j)
            return 0;

        if (dp[i][j]!=-1)
            return dp[i][j];

        int minCost=Integer.MAX_VALUE;

        for (int k=i;k<=j;k++) {
            int currCost=arr[j+1]-arr[i-1]+solve(i,k-1,arr,dp)+solve(k+1,j,arr,dp);
            minCost=Math.min(minCost,currCost);
        }

        return dp[i][j]=minCost;
    }
}