class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        int[] firstVisitedTime = new int[n];
        int[] lowestTime = new int[n];
        boolean[] visited = new boolean[n];
        int[] time = {1};

        for (int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for (List<Integer> edge: connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        dfs(0,-1,time,visited,firstVisitedTime,lowestTime,res,adjList);
        return res;
    }

    public void dfs(int curr,int parent,int[] time,boolean[] visited,int[] firstVisitedTime,int[] lowestTime,List<List<Integer>> res,List<List<Integer>> adjList) {
        visited[curr] = true;
        firstVisitedTime[curr] = time[0];
        lowestTime[curr] = time[0];
        time[0]++;

        for (int ngbr: adjList.get(curr)) {
            if (!visited[ngbr])
                dfs(ngbr,curr,time,visited,firstVisitedTime,lowestTime,res,adjList);

            if (ngbr != parent)
                lowestTime[curr] = Math.min(lowestTime[curr], lowestTime[ngbr]);

            if (lowestTime[ngbr] > firstVisitedTime[curr])
                res.add(new ArrayList<>(Arrays.asList(curr,ngbr)));
        }
    }
}