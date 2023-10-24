//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
//Memoization
class Solution{
    static int palindromicPartition(String str)
    {
        int n=str.length();
        int[][] dp=new int[n][n];
        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                dp[i][j]=-1;
        return solve(str,0,n-1,dp);
    }
    
    static int solve(String s,int left,int right,int[][] dp)
    {
        if (left>right)
            return -1;
            
        if (left==right)
            return 0;
            
        if (dp[left][right]!=-1)
            return dp[left][right];
        
        int minVal=right-left;
        // if (isPalindrome(s,left,right))
        //     return 0;
            
        for (int k=left;k<=right;k++)
        {
            if (isPalindrome(s,left,k))
            {
                int currVal=1+solve(s,k+1,right,dp);
                minVal=Math.min(minVal,currVal);
                // System.out.println(left+" "+right+" "+k+" "+currVal);
            }
        }
        
        return dp[left][right]=minVal;
    }
    
    static boolean isPalindrome(String s,int left,int right)
    {
        while (left<right)
        {
            if (s.charAt(left)!=s.charAt(right))
                return false;
                
            left++;
            right--;
        }
        
        return true;
    }
}