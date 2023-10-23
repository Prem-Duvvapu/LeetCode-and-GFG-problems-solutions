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

//Tabulation
class Solution
{
	public int maxSumIS(int arr[], int n)  
	{
	    int[][] dp=new int[n][n+1];
	    
	    for (int pos=0;pos<n;pos++)
	    {
	        for (int prev=pos+1;prev<=n;prev++)
	        {
	            int notPick=0;
	            int pick=0;
	            
	            if (pos>0)
	                notPick=dp[pos-1][prev];
	               
	            if (prev==n || arr[pos]<arr[prev])
	            {
	                pick=arr[pos];
	                if (pos>0)
	                   pick+=dp[pos-1][pos];
	            }
	       
	                
	            dp[pos][prev]=Math.max(pick,notPick);
	        }
	    }
	    
	    return dp[n-1][n];
	} 
}