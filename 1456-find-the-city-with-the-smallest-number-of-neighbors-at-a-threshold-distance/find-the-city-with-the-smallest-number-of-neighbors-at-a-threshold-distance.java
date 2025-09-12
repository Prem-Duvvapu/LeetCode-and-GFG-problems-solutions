class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int res = -1;
        int minCitiesCnt = n+1;
        int[][] dist = new int[n][n];

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (i != j)
                    dist[i][j] = (int)1e8;
            }
        }

        for (int[] e: edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for (int k=0;k<n;k++) {
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i=0;i<n;i++) {
            int currCitiesCnt = 0;
            for (int j=0;j<n;j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    currCitiesCnt++;
                }
            }

            if (currCitiesCnt <= minCitiesCnt) {
                minCitiesCnt = currCitiesCnt;
                res = i;
            }
        }

        return res;
    }
}