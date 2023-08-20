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
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//Tabulation

class Solution{
    static int maximumPath(int n, int a[][])
    {
        int[][] dp=new int[n][n];
        for (int i=0;i<n;i++)
            dp[0][i]=a[0][i];
            
        for (int i=1;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                int up=dp[i-1][j];
                int leftDiag=0;
                int rightDiag=0;
                
                if (j-1>=0)
                    leftDiag=dp[i-1][j-1];
                    
                if (j+1<n)
                    rightDiag=dp[i-1][j+1];
                    
                dp[i][j]=a[i][j]+Math.max(up,Math.max(leftDiag,rightDiag));
            }
        }
        
        int maxVal=0;
        for (int k=0;k<n;k++)
           maxVal=Math.max(dp[n-1][k],maxVal);
           
        return maxVal;
    }
    
    
}