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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    int mod=(int)(1e9)+7;
	public int perfectSum(int arr[],int n, int sum) 
	{
	    int[][] dp=new int[n][sum+1];
	    for (int i=0;i<n;i++)
	        for (int j=0;j<=sum;j++)
	            dp[i][j]=-1;
	    return solve(n-1,sum,arr,dp);
	} 
	
	private int solve(int pos,int target,int[] a,int[][] dp)
	{
	    if (pos==0)
	    {
	        if (a[0]==0 && target==0)
	            return 2;
	        else if (a[0]==target || target==0)
	            return 1;
	        else
	        return 0;
	    }
	    
	    if (dp[pos][target]!=-1)
	        return dp[pos][target];
	    
	    int notPick=solve(pos-1,target,a,dp);
	    int pick=0;
	    if (a[pos]<=target)
	        pick=solve(pos-1,target-a[pos],a,dp);
	        
	    return dp[pos][target]=(pick+notPick)%mod;
	}
}