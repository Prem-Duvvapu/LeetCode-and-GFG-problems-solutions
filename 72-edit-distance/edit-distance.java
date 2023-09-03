class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n][m];

        for (int[] arr: dp)
            Arrays.fill(arr,-1);

        return solve(n-1,m-1,word1,word2,dp);
    }

    private int solve(int i,int j,String s,String t,int[][] dp)
    {
        if (i<0)
            return j+1;

        if (j<0)
            return i+1;

        if (dp[i][j]!=-1)
            return dp[i][j];

        int match=1000,insert=1000,delete=1000,replace=1000;
        if (s.charAt(i)==t.charAt(j))
            match=solve(i-1,j-1,s,t,dp);
        else
        {
            insert=1+solve(i,j-1,s,t,dp);
            delete=1+solve(i-1,j,s,t,dp);
            replace=1+solve(i-1,j-1,s,t,dp);
        }


        return dp[i][j]=Math.min(Math.min(match,insert),Math.min(delete,replace));
    }
}