class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int getUltimateParent(int node) {
        if (parent[node] == node)
            return node;

        return parent[node] = getUltimateParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int up_u = getUltimateParent(u);
        int up_v = getUltimateParent(v);

        if (up_u == up_v)
            return;

        if (size[up_u] >= size[up_v]) {
            size[up_u] += size[up_v];
            parent[up_v] = up_u;
        } else {
            size[up_v] += size[up_u];
            parent[up_u] = up_v;
        }
    }
}

class Solution {
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        if (n == 1)
            return 0;

        DisjointSet ds = new DisjointSet(n*n);
        int[][] arr = new int[n*n][2];

        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                arr[grid[i][j]] = new int[]{i,j};

        int time = 0;
        while (ds.getUltimateParent(0) != ds.getUltimateParent(n*n-1)) {
            int[] curr = arr[time];
            int x = curr[0];
            int y = curr[1];
            int node = x*n + y;

            for (int i=0;i<4;i++) {
                int newRow = x + dRow[i];
                int newCol = y + dCol[i];
                int newNode = newRow*n + newCol;

                if (newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]<=time)
                    ds.unionBySize(node,newNode);
            }

            time++;
        }

        return time-1;
    }
}