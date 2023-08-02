//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair
{
    int a;
    int b;
    
    Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        if (A[0][0]==0)
            return -1;
            
        int[][] dp=new int[N][M];
        for (int i=0;i<N;i++)
            for (int j=0;j<M;j++)
                dp[i][j]=N*M;
                
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0));
        dp[0][0]=0;
        
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        
        while (!q.isEmpty())
        {
            Pair curr=q.poll();
            int r=curr.a;
            int c=curr.b;
            
            for (int i=0;i<4;i++)
            {
                int nr=r+dx[i];
                int nc=c+dy[i];
                
                if (nr>=0 && nr<N && nc>=0 && nc<M && A[nr][nc]==1)
                {
                    if (dp[nr][nc]>dp[r][c]+1)
                    {
                        dp[nr][nc]=dp[r][c]+1;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
        }
        
        if (dp[X][Y]==N*M)
            return -1;
            
        return dp[X][Y];
    }
};