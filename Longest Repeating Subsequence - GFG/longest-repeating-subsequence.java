//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        int n=str.length();
        int[][] dp=new int[n+1][n+1];
        
        for (int i=n-1;i>-1;i--)
        {
            for (int j=n-1;j>-1;j--)
            {
                int movea,moveb;
                movea=dp[i+1][j];
                moveb=dp[i][j+1];
                
                int take=0;
                if (i!=j && str.charAt(i)==str.charAt(j))
                    take=1+dp[i+1][j+1];
                    
                dp[i][j]=Math.max(take,Math.max(movea,moveb));
            }
        }
        
        return dp[0][0];
    }
}