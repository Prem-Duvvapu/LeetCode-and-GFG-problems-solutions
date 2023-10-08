//Memoization
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][][] dp=new int[500][500][2];
        for (int i=0;i<500;i++)
            for (int j=0;j<500;j++)
                for (int k=0;k<2;k++)
                    dp[i][j][k]=-1;

        return solve(0,0,0,nums1,nums2,dp);
    }

    private int solve(int i,int j,int picked,int[] nums1,int[] nums2,int[][][] dp)
    {
        if (i==nums1.length || j==nums2.length)
        {
            if (picked==1)
                return 0;
            else
                return -10000000;
        }

        if (dp[i][j][picked]!=-1)
            return dp[i][j][picked];

        //skip i
        int val1=0+solve(i+1,j,picked,nums1,nums2,dp);

        //skip j
        int val2=0+solve(i,j+1,picked,nums1,nums2,dp);

        //pick
        int val3=nums1[i]*nums2[j]+solve(i+1,j+1,1,nums1,nums2,dp);

        int maxVal=Math.max(val1,Math.max(val2,val3));
        
        return dp[i][j][picked]=maxVal;
    }
}