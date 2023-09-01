//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int n, int w, int val[], int wt[])
    {
        int[][] dp=new int[n][w+1];
        for (int i=0;i<n;i++)
            for (int j=0;j<=w;j++)
                dp[i][j]=-1;
                
        int ans=solve(n-1,w,val,wt,dp);
        
        if (ans<0)
            return 0;
            
        return ans;
    }
    
    static int solve(int pos,int w,int[] val,int[] wt,int[][] dp)
    {
        if (pos==0)
            return val[0]*(w/wt[0]);
        
        if (dp[pos][w]!=-1)
            return dp[pos][w];
        
        int notPick=solve(pos-1,w,val,wt,dp);
        int pick=-(int)(1e5);
        if (wt[pos]<=w)
            pick=val[pos]+solve(pos,w-wt[pos],val,wt,dp);
            
        return dp[pos][w]=Math.max(pick,notPick);
    }
}