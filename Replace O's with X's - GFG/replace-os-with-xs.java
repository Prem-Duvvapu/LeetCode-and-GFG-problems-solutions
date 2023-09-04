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
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isValid(int i,int j,int n,int m,char[][] a,boolean[][] visited)
    {
        if (i<0 || i==n || j<0 || j==m)
            return false;
            
        if (visited[i][j])
            return false;
            
        return (a[i][j]=='O');
    }
    
    static void dfs(int i,int j,int n,int m,char[][] a,boolean[][] visited,boolean[][] change)
    {
        visited[i][j]=true;
        change[i][j]=false;
        
                 //L R U D
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        
        for (int k=0;k<4;k++)
        {
            int nrow=i+dx[k];
            int ncol=j+dy[k];
            
            if (isValid(nrow,ncol,n,m,a,visited))
                dfs(nrow,ncol,n,m,a,visited,change);
        }
    }
    
    static char[][] fill(int n, int m, char a[][])
    {
        boolean[][] visited=new boolean[n][m];
        boolean[][] change=new boolean[n][m];
        
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                change[i][j]=true;
        
        for (int i=0;i<n;i++)
        {
            if (isValid(i,0,n,m,a,visited))//first column
                dfs(i,0,n,m,a,visited,change);
                
            if (isValid(i,m-1,n,m,a,visited))//last column
                dfs(i,m-1,n,m,a,visited,change);
        }
        
        for (int j=0;j<m;j++)
        {
            if (isValid(0,j,n,m,a,visited))//first row
                dfs(0,j,n,m,a,visited,change);
                
            if (isValid(n-1,j,n,m,a,visited))//first column
                dfs(n-1,j,n,m,a,visited,change);
        }
        
        char[][] b=new char[n][m];
        
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<m;j++)
            {
                if (change[i][j])
                    b[i][j]='X';
                else
                    b[i][j]='O';
            }
        }
        
        return b;
    }
}