//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) 
    {
        int[][] dp=new int[n][w+1];
        for (int i=0;i<n;i++)
            for (int j=0;j<=w;j++)
                dp[i][j]=-1;
        return solve(n-1,w,wt,val,dp);
    } 
    
    static int solve(int pos,int w,int[] wt,int[] val,int[][] dp)
    {
        if (pos==0)
        {
            if (wt[0]<=w)
                return val[0];
            else
                return 0;
        }
        
        if (dp[pos][w]!=-1)
            return dp[pos][w];
        
        int notTake=solve(pos-1,w,wt,val,dp);
        int take=Integer.MIN_VALUE;
        if (wt[pos]<=w)
            take=val[pos]+solve(pos-1,w-wt[pos],wt,val,dp);
            
        return dp[pos][w]=Math.max(take,notTake);
    }
}


