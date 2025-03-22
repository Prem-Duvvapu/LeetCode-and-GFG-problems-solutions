class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int components=0;
        boolean[] visited=new boolean[n];
        List<List<Integer>> adjList=new ArrayList<>();
        int res=0;

        for (int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for (int[] edge: edges) {
            int u=edge[0];
            int v=edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                dfs(i,visited,n,adjList);
                if (isComplete(i,n,adjList))
                    res++;
            }
        }

        return res;
    }

    public void dfs(int curr,boolean[] visited,int n,List<List<Integer>> adjList) {
        visited[curr]=true;

        for (int ngbr: adjList.get(curr)) {
            if (!visited[ngbr]) {
                dfs(ngbr,visited,n,adjList);
            }
        }
    }

    public boolean isComplete(int curr,int n,List<List<Integer>> adjList) {
        Queue<Integer> q=new LinkedList<>();
        q.add(curr);
        boolean[] visited=new boolean[n];
        visited[curr]=true;
        int totalEdges=0;
        int totalVertices=0;

        while (!q.isEmpty()) {
            int top=q.poll();
            totalEdges+=adjList.get(top).size();

            for (int ngbr: adjList.get(top)) {
                if (!visited[ngbr]) {
                    visited[ngbr]=true;
                    q.add(ngbr);
                }
            }
        }

        for (int i=0;i<n;i++)
            if (visited[i])
                totalVertices++;

        return check(totalVertices,totalEdges/2);
    }

    public boolean check(int totalVertices,int totalEdges) {
        if (totalVertices==1)
            return true;

        int requiredEdges=0;
        int d=1;

        for (int i=2;i<=totalVertices;i++) {
            requiredEdges+=(i-1);
        }

        return (totalEdges==requiredEdges);
    }
}