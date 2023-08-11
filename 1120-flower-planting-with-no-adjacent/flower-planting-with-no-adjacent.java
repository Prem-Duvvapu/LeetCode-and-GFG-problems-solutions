class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] color=new int[n];
        int m=4;
        ArrayList<Integer>[] graph=new ArrayList[n];
        for (int i=0;i<n;i++)
            graph[i]=new ArrayList<>();
        for (int[] path: paths)
        {
            int src=path[0]-1;
            int dest=path[1]-1;
            graph[src].add(dest);
            graph[dest].add(src);
        }
        solve(0,graph,n,m,color);
        return color;
    }

    private boolean solve(int node,ArrayList<Integer>[] graph,int n,int m,int[] color)
    {
        if (node==n)
            return true;

        for (int i=1;i<=m;i++)
        {
            if (isSafe(node,graph,color,i))
            {
                color[node]=i;
                if (solve(node+1,graph,n,m,color))
                    return true;
                color[node]=0;
            }
        }

        return false;
    }

    private boolean isSafe(int node,ArrayList<Integer>[] graph,int[] color,int col)
    {
        for (int vertex: graph[node])
            if (color[vertex]==col)
                return false;
        return true;
    }
}