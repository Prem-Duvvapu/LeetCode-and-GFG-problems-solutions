//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        long[][] dp=new long[coins.length+1][sum+1];
        for (long[] a: dp)
            Arrays.fill(a,-1);
        Arrays.sort(coins);
        return helper(0,sum,coins,dp);
    }
    
    private long helper(int pos,int sum,int[] coins,long[][] dp)
    {
        if (sum==0)
            return 1;
            
        if (pos==coins.length || coins[pos]>sum)
            return 0;
            
        if (dp[pos][sum]!=-1)
            return dp[pos][sum];
        
        long pick=helper(pos,sum-coins[pos],coins,dp);
        long notPick=helper(pos+1,sum,coins,dp);
        
        return dp[pos][sum]=pick+notPick;
    }
}