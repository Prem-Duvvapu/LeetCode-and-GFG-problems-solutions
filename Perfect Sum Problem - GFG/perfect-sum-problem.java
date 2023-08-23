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
	    Arrays.sort(arr);
	    int[][] dp=new int[n][sum+1];
	    for (int i=0;i<n;i++)
	        for (int j=0;j<=sum;j++)
	            dp[i][j]=-1;
	    return solve(0,sum,arr,n,dp);
	}
	
	private int solve(int pos,int sum,int[] arr,int n,int[][] dp)
	{
	    if (sum==0)
	        return 1;
	        
	    if (pos==n || arr[pos]>sum)
	        return 0;
	        
	    if (dp[pos][sum]!=-1)
	        return dp[pos][sum];
	    
	    int notPick=solve(pos+1,sum,arr,n,dp);
	    int pick=pick=solve(pos+1,sum-arr[pos],arr,n,dp);
	        
	    return dp[pos][sum]=(pick+notPick)%mod;
	}
}