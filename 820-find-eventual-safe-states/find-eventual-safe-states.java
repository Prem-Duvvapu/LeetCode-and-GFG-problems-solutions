class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> revAdjList = new ArrayList<>();
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i=0;i<n;i++)
            revAdjList.add(new ArrayList<>());

        for (int i=0;i<n;i++) {
            for (int ngbr: graph[i]) {
                revAdjList.get(ngbr).add(i);
                indegree[i]++;
            }
        }

        for (int i=0;i<n;i++)
            if (indegree[i] == 0)
                q.add(i);

        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            for (int ngbr: revAdjList.get(curr))  {
                indegree[ngbr]--;

                if (indegree[ngbr] == 0)
                    q.add(ngbr);
            }
        }

        Collections.sort(res);
        return res;
    }
}