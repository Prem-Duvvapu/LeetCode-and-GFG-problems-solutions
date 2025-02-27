class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int res=0;
        int minCities=n+1;
        int[][] dist=new int[n][n];

        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                if (i!=j)
                    dist[i][j]=(int)1e8;

        for (int[] e: edges) {
            int u=e[0];
            int v=e[1];
            int wt=e[2];

            dist[u][v]=wt;
            dist[v][u]=wt;
        }

        for (int k=0;k<n;k++) {
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    if (dist[i][k]+dist[k][j]<dist[i][j])
                        dist[i][j]=dist[i][k]+dist[k][j];
                }
            }
        }


        for (int i=0;i<n;i++) {
            int cnt=0;
            for (int j=0;j<n;j++) {
                if (i!=j && dist[i][j]<=distanceThreshold)
                    cnt++;
            }

            if (cnt<=minCities) {
                minCities=cnt;
                res=i;
            }
        }

        return res;
    }
}