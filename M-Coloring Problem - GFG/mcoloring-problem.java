//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    private boolean isSafe(int node,List<Integer>[] g,int[] color,int col)
    {
        for (int val: g[node])
            if (color[val]==col)
                return false;
            
        return true;
    }
    
    private boolean solve(int node,List<Integer>[] g,int m,int n,int[] color)
    {
        if (node==n)
            return true;
        
        for (int i=1;i<=m;i++)
        {
            if (isSafe(node,g,color,i))
            {
                color[node]=i;
                if (solve(node+1,g,m,n,color))
                    return true;
                color[node]=0;
            }
        }
        
        return false;
    }
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        // for (int i=0;i<n;i++)
        //     System.out.println(Arrays.toString(graph[i]));
        List<Integer>[] g=new ArrayList[n];
        buildGraph(graph,g,n);
        int[] color=new int[n];
        if (solve(0,g,m,n,color))
            return true;
        return false;
    }
    
    private void buildGraph(boolean[][] graph,List<Integer>[] g,int n)
    {
        for (int i=0;i<n;i++)
            g[i]=new ArrayList<>();
            
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                if (graph[i][j])
                {
                    g[i].add(j);
                }
            }
        }
    }
}