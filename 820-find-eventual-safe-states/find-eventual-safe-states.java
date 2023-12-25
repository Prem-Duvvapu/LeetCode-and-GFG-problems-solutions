//DFS
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        boolean[] visited=new boolean[n];
        boolean[] path=new boolean[n];
        boolean[] safe=new boolean[n];
        List<Integer> res=new ArrayList<>();

        for (int i=0;i<n;i++)
            if (!visited[i])
                dfs(i,visited,path,safe,graph);

        for (int i=0;i<n;i++)
            if (safe[i])
                res.add(i);
        return res;
    }

    private boolean dfs(int i,boolean[] visited,boolean[] path,boolean[] safe,int[][] graph) {
        visited[i]=true;
        path[i]=true;

        for (int neighbour: graph[i]) {
            if (!visited[neighbour]) {
                if (dfs(neighbour,visited,path,safe,graph))
                    return true;
            }
            else if (path[neighbour])
                return true;
        }

        safe[i]=true;
        path[i]=false;
        return false;
    }
}