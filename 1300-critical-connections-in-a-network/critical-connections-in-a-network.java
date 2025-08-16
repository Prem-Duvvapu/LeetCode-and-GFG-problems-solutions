class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        int m = connections.size();

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for (List<Integer> edge: connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] in = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        int[] time = {1};

        dfs(0,-1,time,visited,in,low,res,adjList);
        return res;
    }

    public void dfs(int curr,int parent,int[] time,boolean[] visited,int[] in,int[] low,List<List<Integer>> res,List<List<Integer>> adjList) {
        visited[curr] = true;
        in[curr] = time[0];
        low[curr] = time[0];
        time[0]++;

        for (int ngbr: adjList.get(curr)) {
            if (!visited[ngbr])
                dfs(ngbr,curr,time,visited,in,low,res,adjList);

            if (ngbr != parent)
                low[curr] = Math.min(low[curr], low[ngbr]);

            if (in[curr] < low[ngbr])
                res.add(new ArrayList<>(Arrays.asList(curr,ngbr)));
        }
    }
}