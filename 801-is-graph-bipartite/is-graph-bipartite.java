class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        Arrays.fill(color, -1);

        for (int i=0;i<n;i++) {
            if (color[i] == -1) {
                if (!dfs(i,0,color,graph))
                    return false;
            }
        }

        return true;
    }

    private boolean dfs(int curr,int currColor,int[] color,int[][] graph) {
        color[curr] = currColor;

        for (int ngbr: graph[curr]) {
            if (color[ngbr] == -1) {
                if (!dfs(ngbr,1 - currColor,color,graph))
                    return false;
            } else if (color[ngbr] == currColor) {
                return false;
            }
        }

        return true;
    }
}