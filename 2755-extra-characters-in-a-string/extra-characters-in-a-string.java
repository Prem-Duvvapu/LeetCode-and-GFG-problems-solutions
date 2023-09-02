//Memoization
//TC:- O(n^2)+O(n)(Auxillary stack space)

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set=new HashSet<>();
        int[] dp=new int[s.length()];

        Arrays.fill(dp,-1);
        for (String str: dictionary)
            set.add(str);

        return solve(0,s,set,dp);
    }

    private int solve(int pos,String s,Set<String> set,int[] dp)
    {
        if (pos==s.length())
            return 0;

        if (dp[pos]!=-1)
            return dp[pos];

        String curr="";
        int minExtra=s.length();
        for (int i=pos;i<s.length();i++)
        {
            curr+=s.charAt(i);
            int currExtra=0;
            if (!set.contains(curr))
                currExtra=curr.length();

            int remainExtra=solve(i+1,s,set,dp);
            int totalExtra=currExtra+remainExtra;
            minExtra=Math.min(minExtra,totalExtra);
        }

        return dp[pos]=minExtra;
    }
}