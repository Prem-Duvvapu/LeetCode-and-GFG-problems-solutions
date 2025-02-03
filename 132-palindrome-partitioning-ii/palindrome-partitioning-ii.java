class Solution {
    Boolean[][] dpPalindrome;
    public int minCut(String s) {
        int n=s.length();
        dpPalindrome=new Boolean[n][n];
        int[][] dp=new int[n][n];

        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                dp[i][j]=-1;

        return solve(0,n-1,s,dp);
    }

    private int solve(int left,int right,String s,int[][] dp) {
        if (isPalindrome(left,right,s))
            return 0;

        if (dp[left][right]!=-1)
            return dp[left][right];

        int minCuts=2000;

        for (int i=left+1;i<=right;i++) {
            if (isPalindrome(left,i-1,s)) {
                int currCuts=1+solve(i,right,s,dp);
                minCuts=Math.min(minCuts,currCuts);
            }
        }

        return dp[left][right]=minCuts;
    }

    private boolean isPalindrome(int left,int right,String s) {
        if (left>=right)
            return true;

        if (dpPalindrome[left][right]!=null)
            return dpPalindrome[left][right];

        boolean currCharsCheck=(s.charAt(left)==s.charAt(right));
        boolean remainingCharsCheck=isPalindrome(left+1,right-1,s);

        return dpPalindrome[left][right]=(currCharsCheck && remainingCharsCheck);
    }
}