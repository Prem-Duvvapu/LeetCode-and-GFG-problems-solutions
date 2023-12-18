class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int cnt=0;
        boolean[] visited=new boolean[n];
        for (int i=0;i<n;i++)
        {
            if (!visited[i])
            {
                cnt++;
                dfs(i,isConnected,visited);
            }
        }

        return cnt;
    }

    private void dfs(int curr,int[][] isConnected,boolean[] visited)
    {
        visited[curr]=true;

        for (int j=0;j<isConnected.length;j++)
            if (j!=curr && isConnected[curr][j]==1 && !visited[j])
                dfs(j,isConnected,visited);
    }
}