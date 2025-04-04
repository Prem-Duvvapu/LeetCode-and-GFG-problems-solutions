class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);

        for (int i=0;i<n;i++)
            if (color[i]==-1)
                if (!bfs(i,color,graph,n))
                    return false;

        return true;
    }

    public boolean bfs(int node,int[] color,int[][] graph,int n) {
        color[node]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int currNode=q.poll();
            int currColor=color[currNode];

            for (int ngbr: graph[currNode]) {
                if (color[ngbr]==-1) {
                    color[ngbr]=1-currColor;
                    q.add(ngbr);
                } else if (color[ngbr]==currColor) {
                    return false;
                }
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