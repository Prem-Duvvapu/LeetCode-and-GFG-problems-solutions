//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minOperation(int n)
    {
        int[] dp=new int[n+1];
        
        for (int curr=n-1;curr>0;curr--)
        {
            int dbNum=1000000;
            if (curr<=n/2)
                dbNum=dp[2*curr];
            int addOne=dp[curr+1];
            
            dp[curr]=1+Math.min(dbNum,addOne);
        }
            
        return 1+dp[1];
    }
    
    private int solve(int curr,int n,int[] dp)
    {
        if (curr==n)
            return 0;
            
        if (dp[curr]!=-1)
            return dp[curr];
            
        int dbNum=1000000;
        if (curr<=n/2)
            dbNum=solve(2*curr,n,dp);
        int addOne=solve(curr+1,n,dp);
        
        return dp[curr]=1+Math.min(dbNum,addOne);
    }
}