//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//Memoization
class Solution{
    static int matrixMultiplication(int n, int arr[])
    {
        int[][] dp=new int[n][n];
        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                dp[i][j]=-1;
        return solve(1,n-1,arr,dp);
    }
    
    static int solve(int left,int right,int[] arr,int[][] dp)
    {
        if (left==right)
            return 0;
            
        if (dp[left][right]!=-1)
            return dp[left][right];
        
        int minVal=Integer.MAX_VALUE;
        for (int k=left;k<right;k++)
        {
            int currVal=arr[left-1]*arr[k]*arr[right]+solve(left,k,arr,dp)+solve(k+1,right,arr,dp);
            minVal=Math.min(minVal,currVal);
        }
        
        return dp[left][right]=minVal;
    }
}
