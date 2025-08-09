class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i=0;i<n;i++) {
            parent[i] = i;
            size[i] =1;
        }
    }

    public int getParent(int node) {
        if (parent[node] == node)
            return node;

        return parent[node] = getParent(parent[node]);
    }

    public void unionBySize(int u,int v) {
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
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraCables = 0;
        int numOfComponents = 0;

        for (int[] connection : connections) {
            int src = connection[0];
            int dest = connection[1];

            if (ds.getParent(src) == ds.getParent(dest))
                extraCables++;
            else
                ds.unionBySize(src, dest);
        }

        for (int i=0;i<n;i++)
            if (ds.parent[i] == i)
                numOfComponents++;

        int requiredCables = numOfComponents-1;

        return (extraCables >= requiredCables) ? requiredCables : -1;
    }
}