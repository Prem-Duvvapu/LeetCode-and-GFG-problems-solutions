//Memoization
class Solution {
    Boolean[][] dpPalindrome;
    public int minCut(String s) {
        int n=s.length();
        Integer[][] dp=new Integer[n][n];
        dpPalindrome=new Boolean[n][n];
        return solve(0,n-1,s,dp);
    }

    private int solve(int left,int right,String s,Integer[][] dp)
    {
        if (left==right || isPalindrome(s,left,right))
            return 0;

        if (dp[left][right]!=null)
            return dp[left][right];

        int minVal=s.length()-1;

        for (int i=left;i<right;i++)
            if (isPalindrome(s,left,i))
                minVal=Math.min(minVal,1+solve(i+1,right,s,dp));

        return dp[left][right]=minVal;
    }

    private boolean isPalindrome(String s,int left,int right)
    {
        if (left>=right)
            return true;

        if (dpPalindrome[left][right]!=null)
            return dpPalindrome[left][right];
        
        boolean currCharCheck=s.charAt(left)==s.charAt(right);
        boolean remCharsCheck=isPalindrome(s,left+1,right-1);
        
        return dpPalindrome[left][right]=(currCharCheck && remCharsCheck);
    }
}