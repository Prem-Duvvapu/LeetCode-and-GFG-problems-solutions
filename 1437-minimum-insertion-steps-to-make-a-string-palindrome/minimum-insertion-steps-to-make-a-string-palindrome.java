//Find string length - longest palindromic subsequence of string
//To find longest palindromic subsequence of a string, take the string and the reverse of that string and find their longest common subsequence
//Space Optimization


class Solution {
    public int minInsertions(String s) {
        return (s.length()-longestPalindromicSubsequence(s));
    }

    private int longestPalindromicSubsequence(String s)
    {
        int n=s.length();
        StringBuilder sb=new StringBuilder(s);
        String t=sb.reverse().toString();

        int[] prev=new int[n+1];
        int[] curr=new int[n+1];

        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=n;j++)
            {
                if (s.charAt(i-1)==t.charAt(j-1))
                    curr[j]=1+prev[j-1];
                else
                    curr[j]=Math.max(prev[j],curr[j-1]);
            }

            for (int k=1;k<=n;k++)
                prev[k]=curr[k];
        }

        return prev[n];
    }
}