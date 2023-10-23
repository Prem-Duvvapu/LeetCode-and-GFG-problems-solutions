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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

//Memoization
class Solution
{
	public int maxSumIS(int arr[], int n)  
	{
	    int[][] dp=new int[n][n+1];
	    for (int i=0;i<n;i++)
	        for (int j=0;j<=n;j++)
	            dp[i][j]=-1;
	    return solve(n-1,n,arr,dp);
	} 
	
	private int solve(int pos,int prev,int[] arr,int[][] dp)
	{
	    if (pos<0)
	        return 0;
	        
	    if (dp[pos][prev]!=-1)
	        return dp[pos][prev];
	    
	    int notPick=solve(pos-1,prev,arr,dp);
	    int pick=0;
	    if (prev==arr.length || arr[pos]<arr[prev])
	        pick=arr[pos]+solve(pos-1,pos,arr,dp);
	        
	    return dp[pos][prev]=Math.max(pick,notPick);
	}
}