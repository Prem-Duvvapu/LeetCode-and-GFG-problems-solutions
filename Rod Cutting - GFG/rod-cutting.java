//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends

//Memoization

class Solution{
    public int cutRod(int price[], int n) {
        int[][] dp=new int[n][n+1];
        for (int i=0;i<n;i++)
            for (int j=0;j<=n;j++)
                dp[i][j]=-1;
        return solve(n-1,n,price,dp);
    }
    
    private int solve(int pos,int w,int[] price,int[][] dp)
    {
        if (pos==0)
            return price[0]*(w);
            
        if (dp[pos][w]!=-1)
            return dp[pos][w];
        
        int notPick=solve(pos-1,w,price,dp);
        int pick=-1;
        if (pos+1<=w)
            pick=price[pos]+solve(pos,w-(pos+1),price,dp);
            
        return dp[pos][w]=Math.max(pick,notPick);
    }
}