class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);

        for (int i=0;i<n;i++)
            if (color[i]==-1)
                if (!bfs(i,color,graph))
                    return false;

        return true;
    }

    public boolean bfs(int start,int[] color,int[][] graph) {
        color[start]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int curr=q.poll();
            for (int neighbour: graph[curr]) {
                if (color[neighbour]==-1) {
                    color[neighbour]=1-color[curr];
                    q.add(neighbour);
                } else if (color[neighbour]==color[curr]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int curr,int currColor,int[] color,int[][] graph) {
        color[curr]=currColor;

        for (int neighbour: graph[curr]) {
            if (color[neighbour]==-1) {
                if (!dfs(neighbour,1-currColor,color,graph))
                    return false;
            } else if (color[neighbour]==currColor) {
                return false;
            }
        }

        return true;
    }
}