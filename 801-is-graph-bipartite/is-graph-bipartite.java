class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);

        for (int i=0;i<n;i++)
            if (color[i]==-1)
                if (!dfs(i,0,color,graph,n))
                    return false;

        return true;
    }

    public boolean dfs(int node,int currNodeColor,int[] color,int[][] graph,int n) {
        color[node]=currNodeColor;

        for (int ngbr: graph[node]) {
            if (color[ngbr]==-1) {
                if (!dfs(ngbr,1-currNodeColor,color,graph,n))
                    return false;
            } else if (color[node]==color[ngbr]) {
                return false;
            }
        }

        return true;
    }
}


/*



0   1
0 - 1
|   \
|    4 0
|    /
2 - 3
1   0

//a linear graph is always bipartitie
0-1-2-3

//a graph with even length cycle is also bipartite

//a graph with odd length cycle is not bipartite

color = [0,  1, 1, 0, 0]
          0  1  2  3  4

colors = {0,1}

q=[ 4,3]
*/