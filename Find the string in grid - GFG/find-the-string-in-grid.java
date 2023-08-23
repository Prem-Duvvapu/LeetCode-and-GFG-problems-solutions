//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        int m=grid.length;
        int n=grid[0].length;
        int[][] ans=new int[m*n][2];
        int k=0;
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                if (search(i,j,grid,m,n,word))
                {
                    ans[k][0]=i;
                    ans[k][1]=j;
                    k++;
                }
            }
        }
        
        int[][] res=new int[k][2];
        for (int i=0;i<k;i++)
        {
            res[i][0]=ans[i][0];
            res[i][1]=ans[i][1];
        }
        
        return res;
    }
    
    private boolean search(int r,int c,char[][] grid,int m,int n,String word)
    {
        int row[]={-1,-1,-1,0,1,1,1,0};
        int col[]={-1,0,1,1,1,0,-1,-1};
            
        for (int i=0;i<8;i++)
        {
            int nr=r;
            int nc=c;
            String curr="";
            for (int j=0;j<word.length();j++)
            {
                if (nr<0 || nr==m || nc<0 || nc==n)
                    break;
                if (grid[nr][nc]!=word.charAt(j))
                    break;
                curr+=grid[nr][nc];
                nr+=row[i];
                nc+=col[i];
            }
            if (curr.equals(word))
                return true;
        }
        
        return false;
    }
}