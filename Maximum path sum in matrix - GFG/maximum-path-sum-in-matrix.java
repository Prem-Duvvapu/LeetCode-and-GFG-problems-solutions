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


//Space Optimization

class Solution{
    static int maximumPath(int n, int a[][])
    {
        int[] prev=new int[n];
        for (int i=0;i<n;i++)
            prev[i]=a[0][i];
            
        for (int i=1;i<n;i++)
        {
            int[] curr=new int[n];
            for (int j=0;j<n;j++)
            {
                int up=prev[j];
                int leftDiag=0;
                int rightDiag=0;
                
                if (j-1>=0)
                    leftDiag=prev[j-1];
                    
                if (j+1<n)
                    rightDiag=prev[j+1];
                    
                curr[j]=a[i][j]+Math.max(up,Math.max(leftDiag,rightDiag));
            }
            System.arraycopy(curr,0,prev,0,n);
        }
        
        int maxVal=0;
        for (int k=0;k<n;k++)
           maxVal=Math.max(prev[k],maxVal);
           
        return maxVal;
    }
    
    
}