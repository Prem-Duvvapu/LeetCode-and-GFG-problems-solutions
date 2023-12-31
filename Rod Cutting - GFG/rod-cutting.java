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

//Space optimization using 1 array

class Solution{
    public int cutRod(int price[], int n) {
        int[] prev=new int[n+1];
        
        for (int i=0;i<=n;i++)
            prev[i]=price[0]*i;
            
        for (int i=1;i<n;i++)
        {
            int[] curr=new int[n+1];
            for (int j=0;j<=n;j++)
            {
                int notPick=prev[j];
                int pick=-1;
                if (i+1<=j)
                    pick=price[i]+prev[j-(i+1)];
                    
                prev[j]=Math.max(pick,notPick);
            }
        }
        
        return prev[n];
    }
}