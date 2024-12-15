//Using Disjoint Set
class DisjointSet {
    int[] parent;
    int[] size;

    DisjointSet(int n) {
        parent=new int[n];
        size=new int[n];

        for (int i=0;i<n;i++) {
            parent[i]=i;
            size[i]=1;
        }
    }

    public int ultimateParent(int node) {
        if (parent[node] == node)
            return node;
        
        return parent[node]=ultimateParent(parent[node]);
    }

    public void unionBySize(int u,int v) {
        int uPu = ultimateParent(u);
        int uPv = ultimateParent(v);

        if (uPu == uPv) {
            return;
        }

        if (size[uPu] > size[uPv]) {
            parent[uPv] = uPu;
            size[uPu] += size[uPv];
        } else {
            parent[uPu] = uPv;
            size[uPv] += uPu;
        }
    }

}


class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;

        DisjointSet uds = new DisjointSet(n);

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (isConnected[i][j]==1) {
                    uds.unionBySize(i,j);
                }
            }
        }

        for (int i=0;i<n;i++)
            if (uds.ultimateParent(i) == i)
                provinces++;

        return provinces;
    }
}