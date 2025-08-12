class DisjointSet {
    public int[] parent;
    public int[] size;

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
        int ultParU = getUltimateParent(u);
        int ultParV = getUltimateParent(v);

        if (ultParU == ultParV)
            return;

        if (size[ultParU] >= size[ultParV]) {
            size[ultParU] += size[ultParV];
            parent[ultParV] = ultParU;
        } else {
            size[ultParV] += size[ultParU];
            parent[ultParU] = ultParV;
        }
    }
}

class Solution {
    public int[] dRow = {-1,0,1,0};
    public int[] dCol = {0,1,0,-1};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int maxSize = 0;

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == 0)
                    continue;

                int node = n*i + j;
                for (int k=0;k<4;k++) {
                    int newRow = i + dRow[k];
                    int newCol = j + dCol[k];
                    int newNode = n*newRow + newCol;

                    if (newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==1)
                        ds.unionBySize(node, newNode);
                }
            }
        }

        int oneCnt = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == 1) {
                    oneCnt++;
                    continue;
                }

                Set<Integer> set = new HashSet<>();
                for (int k=0;k<4;k++) {
                    int newRow = i + dRow[k];
                    int newCol = j+ dCol[k];
                    int newNode = n*newRow + newCol;

                    if (newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==1) {
                        set.add(ds.getUltimateParent(newNode));
                    }
                }

                int currSize = 1;
                for (int uniqueParent: set)
                    currSize += ds.size[uniqueParent];

                maxSize = Math.max(maxSize, currSize);
            }
        }

        if (oneCnt == n*n)
            return n*n;

        return maxSize;
    }
}