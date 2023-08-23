class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> paths=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        path.add(0);
        solve(0,path,graph,n,new boolean[n],paths);

        return paths;
    }

    private void solve(int curr,List<Integer> currPath,int[][] graph,int n,boolean[] visited,List<List<Integer>> paths)
    {
        if (curr==n-1)
        {
            paths.add(new ArrayList<>(currPath));
            return;
        }

        for (int i=0;i<graph[curr].length;i++)
        {
            int node=graph[curr][i];
            if (!visited[node])
            {
                visited[node]=true;
                currPath.add(node);
                solve(node,currPath,graph,n,visited,paths);
                currPath.remove(currPath.size()-1);
                visited[node]=false;
            }
        }
    }
}