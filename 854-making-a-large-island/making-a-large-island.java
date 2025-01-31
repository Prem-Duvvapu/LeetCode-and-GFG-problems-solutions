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

    public int uPar(int node) {
        if (parent[node]==node)
            return node;

        return parent[node]=uPar(parent[node]);
    }

    public void unionBySize(int u,int v) {
        int uParU=uPar(u);
        int uParV=uPar(v);

        if (uParU==uParV)
            return;

        if (size[uParU]>=size[uParV]) {
            parent[uParV]=uParU;
            size[uParU]+=size[uParV];
        } else {
            parent[uParU]=uParV;
            size[uParV]+=size[uParU];
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]==0)
                    continue;

                int node=i*n+j;
                for (int k=0;k<4;k++) {
                    int newRow=i+dRow[k];
                    int newCol=j+dCol[k];
                    int newNode=n*newRow+newCol;

                    if (newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==1) {
                        ds.unionBySize(node,newNode);
                        // System.out.println(""+i+" "+j+" "+newRow+" "+newCol+" "+Arrays.toString(ds.size));
                    }
                }
            }
        }

        int finalRes=1;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]==1)
                    continue;

                int node=i*n+j;
                Set<Integer> set=new HashSet<>();
                for (int k=0;k<4;k++) {
                    int newRow=i+dRow[k];
                    int newCol=j+dCol[k];
                    int newNode=n*newRow+newCol;

                    if (newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==1) {
                        set.add(ds.uPar(newNode));
                    }
                }

                int currRes=1;
                for (int uniqueParent: set) {
                    currRes+=ds.size[uniqueParent];
                }
                finalRes=Math.max(finalRes,currRes);
            }
        }

        // System.out.println(Arrays.toString(ds.size));
        if (ds.size[0]==n*n)
            return n*n;

        return finalRes;
    }
}