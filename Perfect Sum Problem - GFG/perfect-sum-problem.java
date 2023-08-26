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
	public int perfectSum(int a[],int n, int sum) 
	{
	    int[][] dp=new int[n][sum+1];
	    if (a[0]==0)
	        dp[0][0]=2;
	    else
	        dp[0][0]=1;
	        
	    if (a[0]!=0 && a[0]<=sum)
	        dp[0][a[0]]=1;
	        
	    for (int i=1;i<n;i++)
	    {
	        for (int target=0;target<=sum;target++)
	        {
	            int notPick=dp[i-1][target];
	            int pick=0;
	            if (a[i]<=target)
	                pick=dp[i-1][target-a[i]];
	           
	            dp[i][target]=(pick+notPick)%mod;
	        }
	    }
	    
	    return dp[n-1][sum];
	} 
}