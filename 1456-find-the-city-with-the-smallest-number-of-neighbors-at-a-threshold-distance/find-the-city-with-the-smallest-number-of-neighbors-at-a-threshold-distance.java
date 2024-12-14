class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist=new int[n][n];
        int[] cities=new int[n];

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (i!=j)
                    dist[i][j]=(int)1e6;
            }
        }

        for (int[] edge: edges) {
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            dist[u][v]=dist[v][u]=wt;
        }

        for (int k=0;k<n;k++)
            for (int i=0;i<n;i++)
                for (int j=0;j<n;j++)
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (i!=j && dist[i][j]<=distanceThreshold)
                    cities[i]++;
            }
        }

        // for (int i=0;i<n;i++) {
        //     for (int j=0;j<n;j++) {
        //         System.out.print(dist[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        // for (int i=0;i<n;i++)
        //     System.out.print(cities[i]+" ");

        int minCities=n+1;
        int res=0;
        for (int i=0;i<n;i++) {
            if (cities[i]<=minCities) {
                minCities=cities[i];
                res=i;
            }
        }

        return res;
    }
}
