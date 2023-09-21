//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        int[] dp=new int[n];
        for (int i=0;i<n;i++)
            dp[i]=-1;
        return solve(n-1,arr,dp);
    }
    
    private int solve(int pos,int[] arr,int[] dp)
    {
        if (pos==0)
            return arr[pos];
            
        if (pos<0)
            return 0;
            
        if (dp[pos]!=-1)
            return dp[pos];
        
        int pick=arr[pos]+solve(pos-2,arr,dp);
        int notPick=0+solve(pos-1,arr,dp);
        
        return dp[pos]=Math.max(pick,notPick);
    }
}