//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    static int mod=1000000007;
    
    public static int findCatalan(int n) {
        int[][] dp=new int[n+1][n+1];
        for (int[] arr: dp)
            Arrays.fill(arr,-1);
        return solve(0,0,n,dp);
    }
    
    private static int solve(int open,int close,int n,int[][] dp)
    {
        if (open+close==2*n)
            return 1;
            
        if (dp[open][close]!=-1)
            return dp[open][close];
        
        int l=0,r=0;
        
        if (open<n)
            l=solve(open+1,close,n,dp);
        
        if (close<open)
            r=solve(open,close+1,n,dp);
            
        return dp[open][close]=(l+r)%mod;
    }
}
        
