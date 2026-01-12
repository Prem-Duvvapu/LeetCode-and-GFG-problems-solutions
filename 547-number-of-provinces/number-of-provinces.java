class DisjointSet {
    int[] parent;
    int[] size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int getUltParent(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = getUltParent(parent[x]);
    }

    public void unionBySize(int u,int v) {
        int ultParU = getUltParent(u);
        int ultParV = getUltParent(v);

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
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);
        int res = 0;

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (i!=j && isConnected[i][j] == 1) {
                    ds.unionBySize(i,j);
                }
            }
        }

        for (int i=0;i<ds.parent.length;i++)
            if (ds.parent[i] == i)
                res++;

        return res;
    }
}