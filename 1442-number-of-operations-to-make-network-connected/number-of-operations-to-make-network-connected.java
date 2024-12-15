class DisjointSet {
    int[] parent;
    int[] size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i=0;i<n;i++) {
            parent[i]=i;
            size[i]=1;
        }
    }

    public int ultimateParent(int node) {
        if (parent[node] == node)
            return node;

        return parent[node] = ultimateParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int uPu = ultimateParent(u);
        int uPv = ultimateParent(v);

        if (uPu == uPv)
            return;
        
        if (size[uPu] > size[uPv]) {
            parent[uPv] = uPu;
            size[uPu] += size[uPv];
        } else {
            parent[uPu] = uPv;
            size[uPv] += size[uPu];
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int components = 0;
        int extraEdges = 0;
        int requiredEdges = 0;

        for (int[] connection: connections) {
            int u = connection[0];
            int v = connection[1];
            if (ds.ultimateParent(u) == ds.ultimateParent(v))
                extraEdges++;
            else
                ds.unionBySize(u,v);
        }

        for (int i=0;i<n;i++)
            if (ds.ultimateParent(i) == i)
                components++;

        requiredEdges = components - 1;

        return (extraEdges >= requiredEdges) ? requiredEdges : -1;
    }
}