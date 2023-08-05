class Solution {
    private boolean solve(int pos,String s,List<String> d,int[] dp)
    {
        if (pos==s.length())
            return true;

        if (dp[pos]==1)
            return true;
        
        if (dp[pos]==0)
            return false;

        for (int i=pos;i<s.length();i++)
        {
            String sub=s.substring(pos,i+1);
            if (d.contains(sub))
            {
                if (solve(pos+sub.length(),s,d,dp))
                {
                    dp[pos]=1;
                    return true;
                }
            }
        }

        dp[pos]=0;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,s,wordDict,dp);
    }
}