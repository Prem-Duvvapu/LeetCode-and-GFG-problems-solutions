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
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int mod=1003;
    
    static int countWays(int n, String s){
        int[][][] dp=new int[n][n][2];
        
        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                for (int k=0;k<2;k++)
                    dp[i][j][k]=-1;
                    
        return solve(0,n-1,1,s,dp);
    }
    
    static int solve(int left,int right,int boolVal,String s,int[][][] dp)
    {
        if (left==right)
        {
            if (boolVal==1 && s.charAt(left)=='T')
                return 1;
            else if (boolVal==0 && s.charAt(left)=='F')
                return 1;
            else
                return 0;
        }
        
        if (dp[left][right][boolVal]!=-1)
            return dp[left][right][boolVal];
        
        int cnt=0;
        
        for (int i=left+1;i<right;i+=2)
        {
            int leftTrueCnt=solve(left,i-1,1,s,dp);
            int leftFalseCnt=solve(left,i-1,0,s,dp);
            int rightTrueCnt=solve(i+1,right,1,s,dp);
            int rightFalseCnt=solve(i+1,right,0,s,dp);
            
            if (s.charAt(i)=='&')
            {
                if (boolVal==1)
                    cnt+=(leftTrueCnt*rightTrueCnt);
                else
                    cnt+=(leftTrueCnt*rightFalseCnt+leftFalseCnt*rightTrueCnt+leftFalseCnt*rightFalseCnt);
            }
            else if (s.charAt(i)=='|')
            {
                if (boolVal==1)
                    cnt+=(leftTrueCnt*rightTrueCnt+leftTrueCnt*rightFalseCnt+leftFalseCnt*rightTrueCnt);
                else
                    cnt+=(leftFalseCnt*rightFalseCnt);
            }
            else if (s.charAt(i)=='^')
            {
                if (boolVal==1)
                    cnt+=(leftTrueCnt*rightFalseCnt+leftFalseCnt*rightTrueCnt);
                else
                    cnt+=(leftTrueCnt*rightTrueCnt+leftFalseCnt*rightFalseCnt);
            }
        }
        
        return dp[left][right][boolVal]=cnt%mod;
    }
}