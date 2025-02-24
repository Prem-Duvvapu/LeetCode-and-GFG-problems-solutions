//Memoization
//Time: O(n^2)
//Space: O(n^2)

class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        Boolean[][] dp=new Boolean[n][n];

        return solve(0,0,dp,s);
    }

    public boolean solve(int index,int cnt,Boolean[][] dp,String s) {
        if (cnt<0)
            return false;

        if (index==s.length())
            return (cnt==0);

        if (dp[index][cnt]!=null)
            return dp[index][cnt];

        char ch=s.charAt(index);

        if (ch=='(')
            return dp[index][cnt]=solve(index+1,cnt+1,dp,s);

        if (ch==')')
            return dp[index][cnt]=solve(index+1,cnt-1,dp,s);

        return dp[index][cnt]=(solve(index+1,cnt+1,dp,s) || solve(index+1,cnt-1,dp,s) || solve(index+1,cnt,dp,s));
    }
}