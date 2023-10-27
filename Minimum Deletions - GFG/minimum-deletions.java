//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

//Memoization
class Solution{
    static int minimumNumberOfDeletions(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder(s);
        String rev=sb.reverse().toString();
        int[][] dp=new int[n][n];
        
        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                dp[i][j]=-1;
                
        int lcs=solve(n-1,n-1,s,rev,dp);
        return (n-lcs);
    }
    
    static int solve(int i,int j,String s1,String s2,int[][] dp)
    {
        if (i<0 || j<0)
            return 0;
            
        if (dp[i][j]!=-1)
            return dp[i][j];
        
        if (s1.charAt(i)==s2.charAt(j))
            return dp[i][j]=1+solve(i-1,j-1,s1,s2,dp);
            
        int move_i=solve(i-1,j,s1,s2,dp);
        int move_j=solve(i,j-1,s1,s2,dp);
        
        return dp[i][j]=Math.max(move_i,move_j);
    }
}