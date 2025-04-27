class Solution {
    public boolean isMatch(String s, String p) {
        int n1=s.length();
        int n2=p.length();
        Boolean[][] dp=new Boolean[n1+1][n2+1];

        return solve(n1-1,n2-1,dp,s,p); //(0 to n1-1) in s is matching (0 to n2-1) in p
    }

    // (0 to i) in s is matching with (0 to j) in p
    public boolean solve(int i,int j,Boolean[][] dp,String s,String p) {
        //base case
        //i<0 && j<0
        if (i<0 && j<0)
            return true;

        //only i<0
        if (i<0) {
            while (j>=0) {
                if (p.charAt(j)!='*')
                    return false;
                j--;
            }

            return true;
        }

        //only j<0
        if (j<0)
            return false;

        if (dp[i][j]!=null)
            return dp[i][j];

        //matching ch, ?
        if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
            return dp[i][j]=solve(i-1,j-1,dp,s,p);

        //*
        if (p.charAt(j)=='*') {
            boolean stop=solve(i,j-1,dp,s,p);
            boolean stay=solve(i-1,j,dp,s,p);

            return dp[i][j]=(stop || stay);
        }

        //not matching ch
        return dp[i][j]=false;
    }
}
