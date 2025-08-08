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

    public int getParent(int node) {
        if (parent[node] == node)
            return node;

        return parent[node] = getParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int uParent = getParent(u);
        int vParent = getParent(v);

        if (uParent == vParent)
            return;

        if (size[uParent] >= size[vParent]) {
            size[uParent] += size[vParent];
            parent[vParent] = uParent;
        } else {
            size[vParent] += size[uParent];
            parent[uParent] = vParent;
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (isConnected[i][j] == 1)
                    ds.unionBySize(i,j);
            }
        }

        for (int i=0;i<n;i++)
            if (ds.parent[i] == i)
                res++;

        return res;
    }
}