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


//Tabulation
class Solution{
    static int matrixMultiplication(int n, int arr[])
    {
        int[][] dp=new int[n][n];
        
        for (int left=n-1;left>0;left--)
        {
            for (int right=left+1;right<n;right++)
            {
                int minVal=Integer.MAX_VALUE;
                for (int k=left;k<right;k++)
                {
                    int currVal=arr[left-1]*arr[k]*arr[right]+dp[left][k]+dp[k+1][right];
                    minVal=Math.min(minVal,currVal);
                }
                
                dp[left][right]=minVal;
            }
        }
        return dp[1][n-1];
    }
}
