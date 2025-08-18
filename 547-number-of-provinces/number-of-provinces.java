class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cnt = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i,visited,isConnected,n);
            }     
        }

        return cnt;
    }

    private void dfs(int curr,boolean[] visited,int[][] adjMatrix,int n) {
        visited[curr] = true;

        for (int j=0;j<n;j++) {
            if (curr == j || adjMatrix[curr][j] == 0 || visited[j])
                continue;

            dfs(j,visited,adjMatrix,n);
        }
    }
}