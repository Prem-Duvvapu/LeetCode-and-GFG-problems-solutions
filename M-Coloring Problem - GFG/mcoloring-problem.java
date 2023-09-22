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
    public boolean graphColoring(boolean graph[][], int m, int n) {
        ArrayList<Integer>[] g=new ArrayList[n];
        
        for (int i=0;i<n;i++)
            g[i]=new ArrayList<>();
            
        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                if (graph[i][j]==true)
                    g[i].add(j);
                    
        int[] colorArr=new int[n];
        return solve(0,colorArr,g,n,m);
    }
    
    private boolean solve(int node,int[] colorArr,ArrayList<Integer>[] g,int n,int m)
    {
        //base case
        if (node==n)
            return true;
        
        for (int color=1;color<=m;color++)
        {
            if (isValid(node,color,g,colorArr))
            {
                colorArr[node]=color;
                if (solve(node+1,colorArr,g,n,m))
                    return true;
                colorArr[node]=0;
            }
        }
        
        return false;
    }
    
    private boolean isValid(int node,int color,ArrayList<Integer>[] g,int[] colorArr)
    {
        for(int neighbour: g[node])
        {
            if (colorArr[neighbour]==color)
                return false;
        }
        
        return true;
    }
}