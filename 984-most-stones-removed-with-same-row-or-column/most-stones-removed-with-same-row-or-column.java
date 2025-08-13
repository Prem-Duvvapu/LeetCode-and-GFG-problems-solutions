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

    public void unionBySize(int u,int v) {
        int ultParU = getUltimateParent(u);
        int ultParV = getUltimateParent(v);

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
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;

        for (int[] coordinates: stones) {
            int x = coordinates[0];
            int y = coordinates[1];

            maxRow = Math.max(maxRow, x);
            maxCol = Math.max(maxCol, y);
        }

        int colStart = maxRow + 1;
        int colEnd = maxCol + colStart;

        DisjointSet ds = new DisjointSet(colEnd+1);
        boolean[] visited = new boolean[colEnd+1];
        for (int[] coordinates: stones) {
            int x = coordinates[0];
            int y = coordinates[1] + colStart;
            
            visited[x] = true;
            visited[y] = true;

            ds.unionBySize(x,y);
        }

        int components = 0;
        for (int i=0;i<=colEnd;i++) {
            if (visited[i] && ds.parent[i] == i)
                components++;
        }

        return (n - components);
    }
}