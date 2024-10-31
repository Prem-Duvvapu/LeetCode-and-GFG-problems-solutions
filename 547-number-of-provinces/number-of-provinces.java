class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                res++;
                dfs(i, visited, isConnected, n);
            }
        }


        return res;
    }

    public void dfs(int currNode, boolean[] visited, int[][] isConnected, int n) {
        visited[currNode] = true;

        for (int i=0; i<n; i++) {
            if (isConnected[currNode][i]==1 && !visited[i])
                dfs(i, visited, isConnected, n);
        }
    }
}