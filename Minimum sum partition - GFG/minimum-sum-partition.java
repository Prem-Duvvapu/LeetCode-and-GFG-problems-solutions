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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    int sum=0;
	    for (int val: arr)
	        sum+=val;
	        
	    int target=sum;
	        
	    boolean[][] dp=new boolean[n][target+1];
	    
	    for (int i=0;i<n;i++)
	        dp[i][0]=true;
	        
	    if (arr[0]<=target)
	        dp[0][arr[0]]=true;
	        
	    for (int i=1;i<n;i++)
	    {
	        for (int j=1;j<=target;j++)
	        {
	            boolean notTake=dp[i-1][j];
	            boolean take=false;
	            if (arr[i]<=j)
	                take=dp[i-1][j-arr[i]];
	                
	            dp[i][j]=(take || notTake);
	        }
	    }
	    
	    int minVal=sum;
	    for (int i=0;i<sum;i++)
	        if (dp[n-1][i])
	            minVal=Math.min(minVal,Math.abs(i-(sum-i)));
	            
	    return minVal;
	} 
}
