class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> res=new ArrayList<>();
        boolean[] visited=new boolean[n];
        boolean[] path=new boolean[n];
        boolean[] safe=new boolean[n];

        for (int i=0;i<n;i++)
            if (!visited[i])
                dfs(i,visited,path,safe,graph,n);

        for (int i=0;i<n;i++)
            if (safe[i])
                res.add(i);

        return res;
    }

    public boolean dfs(int node,boolean[] visited,boolean[] path,boolean[] safe,int[][] graph,int n) {
        visited[node]=true;
        path[node]=true;

        for (int ngbr: graph[node]) {
            if (!visited[ngbr]) {
                if (dfs(ngbr,visited,path,safe,graph,n))
                    return true;
            } else if (path[ngbr]) {
                return true;
            }
        }

        safe[node]=true;
        path[node]=false;
        return false;
    }
}

/*

directed graph
n nodes
0 to n-1

adjList

terminal node - node which has no outgoing edges
safe node - node whose every path leads to safe termial node or another safe node


*/