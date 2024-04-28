class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int cnt = 0;
        boolean[] visited=new boolean[n];

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i, visited, isConnected);
            }
        }

        return cnt;
    }

    private void dfs(int curr, boolean[] visited, int[][] isConnected) {
        visited[curr]=true;

        for (int j=0;j<isConnected.length;j++) {
            if (isConnected[curr][j]==1 && curr!=j && !visited[j]) {
                dfs(j,visited,isConnected);
            }
        }
    }
}