//dfs
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int numOfProvinces=0;

        for (int i=0;i<n;i++) {//O(n)
            if (!visited[i]) {
                dfs(i,visited,isConnected,n);
                numOfProvinces++;
            }
        }

        return numOfProvinces;
    }

    public void dfs(int currNode,boolean[] visited,int[][] isConnected,int n) {
        visited[currNode]=true;

        for (int j=0;j<n;j++) {
            if (isConnected[currNode][j]==1 && !visited[j])
                dfs(j,visited,isConnected,n);
        }
    }
}


/*
Time: O(V)+O(2*E)
Space: O(V)+O(V)
*/