//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends

//Tabulation

class Solution{
    public int cutRod(int price[], int n) {
        int[][] dp=new int[n][n+1];
        
        for (int i=0;i<=n;i++)
            dp[0][i]=price[0]*i;
            
        for (int i=1;i<n;i++)
        {
            for (int j=0;j<=n;j++)
            {
                int notPick=dp[i-1][j];
                int pick=-1;
                if (i+1<=j)
                    pick=price[i]+dp[i][j-(i+1)];
                    
                dp[i][j]=Math.max(pick,notPick);
            }
        }
        
        return dp[n-1][n];
    }
}