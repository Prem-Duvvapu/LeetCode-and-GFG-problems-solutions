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
    static int solve(int pos,int w,int[] wt,int[] val,int n,int[][] dp)
    {
        if (w==0 || pos==n)
            return 0;
        
        if (dp[pos][w]!=-1)
            return dp[pos][w];
            
        if (wt[pos]>w)
            return dp[pos][w]=solve(pos+1,w,wt,val,n,dp);
        
        int select=val[pos]+solve(pos+1,w-wt[pos],wt,val,n,dp);
        int notSelect=solve(pos+1,w,wt,val,n,dp);
        
        return dp[pos][w]=Math.max(select,notSelect);
    }
    
    static int knapSack(int w, int wt[], int val[], int n) 
    {
        int[][] dp=new int[n][w+1];
        for (int[] a: dp)
            Arrays.fill(a,-1);
        return solve(0,w,wt,val,n,dp);
    } 
}


