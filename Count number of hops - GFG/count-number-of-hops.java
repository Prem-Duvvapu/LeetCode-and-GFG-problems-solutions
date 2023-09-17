//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    
    static int mod=(int)1e9+7;
    
    static long countWays(int n)
    {
        long[] dp=new long[n+1];
        for (int i=0;i<=n;i++)
            dp[i]=-1;
        return solve(n,dp);
    }
    
    static long solve(int n,long[] dp)
    {
        if (n<=2)
            return n;
            
        if (n==3)
            return 4;
            
        if (dp[n]!=-1)
            return dp[n];
            
        long step1=solve(n-1,dp);
        long step2=solve(n-2,dp);
        long step3=solve(n-3,dp);
        
        return dp[n]=(step1+step2+step3)%mod;
    }
    
}

