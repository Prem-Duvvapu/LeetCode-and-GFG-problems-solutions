//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] matrix=new int[n][m];
        
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                matrix[i][j]=grid[i][j];
                    
        //first row
        for (int j=0;j<m;j++)
                if (matrix[0][j]==1)
                    dfs(0,j,matrix);
                    
        //last row
        for (int j=0;j<m;j++)
                if (matrix[n-1][j]==1)
                    dfs(n-1,j,matrix);
                    
        //first col
        for (int i=0;i<n;i++)
                if (matrix[i][0]==1)
                    dfs(i,0,matrix);
                    
        //last col
        for (int i=0;i<n;i++)
                if (matrix[i][m-1]==1)
                    dfs(i,m-1,matrix);
                    
        
        int ans=0;
        for (int i=1;i<n-1;i++)
            for (int j=1;j<m-1;j++)
                if (matrix[i][j]==1)
                    ans++;
                    
        return ans;
    }
    
    private void dfs(int i,int j,int[][] matrix)
    {
        if (i<0 || i==matrix.length || j<0 || j==matrix[0].length || matrix[i][j]==0 || matrix[i][j]==2)
            return;
        
        matrix[i][j]=2;
        dfs(i-1,j,matrix);//up
        dfs(i+1,j,matrix);//down
        dfs(i,j-1,matrix);//left
        dfs(i,j+1,matrix);//right
    }
}