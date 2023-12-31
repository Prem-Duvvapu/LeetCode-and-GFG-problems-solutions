//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    static int[] r={1,0,0,-1};
    static int[] c={0,-1,1,0};
    static String[] s={"D","L","R","U"};
    
    private static void solve(int row,int col,String path,int[][] m,int n,boolean[][] visited,List<String> res)
    {
        if (row<0 || row==n || col<0 || col==n)
            return;
            
        if (row==n-1 && col==n-1 && m[row][col]==1)
        {
            res.add(new String(path));
            return;
        }
        
        if (m[row][col]==1 && !visited[row][col])
        {
            for (int i=0;i<4;i++)
            {
                visited[row][col]=true;
                solve(row+r[i],col+c[i],path+s[i],m,n,visited,res);
                visited[row][col]=false;
            }
        }
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res=new ArrayList<>();
        boolean[][] visited=new boolean[n][n];
        solve(0,0,"",m,n,visited,res);
        return res;
    }
}