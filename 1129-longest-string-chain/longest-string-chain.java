class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words,(a,b)->(a.length()-b.length()));
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int maxVal=0;

        for (int i=0;i<n;i++)
        {
            for (int j=0;j<i;j++)
            {
                if (isPredecessor(words[j],words[i]) && dp[j]+1>dp[i])
                    dp[i]=dp[j]+1;
            }
            maxVal=Math.max(maxVal,dp[i]);
        }

        return maxVal;
    }

    private boolean isPredecessor(String t,String s)
    {
        if (s.length()!=t.length()+1)
            return false;

        int i=0;//for s
        int j=0;//for t

        while (i<s.length())
        {
            if (s.charAt(i)==t.charAt(j))
            {
                i++;
                j++;
            }
            else
                i++;

            if (j==t.length())
                return true;
        }

        return false;
    }
}