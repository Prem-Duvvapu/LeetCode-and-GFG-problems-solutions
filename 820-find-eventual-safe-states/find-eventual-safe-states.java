//DFS
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        boolean[] visited=new boolean[n];
        boolean[] path=new boolean[n];
        List<Integer> res=new ArrayList<>();

        for (int i=0;i<n;i++)
            if (!visited[i])
                dfs(i,visited,path,res,graph);

        Collections.sort(res);
        return res;
    }

    private boolean dfs(int i,boolean[] visited,boolean[] path,List<Integer> res,int[][] graph) {
        visited[i]=true;
        path[i]=true;

        for (int neighbour: graph[i]) {
            if (!visited[neighbour]) {
                if (dfs(neighbour,visited,path,res,graph)) {
                    return true;
                }
            }
            else if (path[neighbour]) {
                return true;
            }
        }

        res.add(i);
        path[i]=false;
        return false;
    }
}