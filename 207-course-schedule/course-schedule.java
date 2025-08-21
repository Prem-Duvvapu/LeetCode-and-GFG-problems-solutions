class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i=0;i<V;i++)
            adjList.add(new ArrayList<>());
        
        for (int[] edge: prerequisites) {
            int a = edge[0];
            int b = edge[1];
            
            adjList.get(b).add(a);
            indegree[a]++;
        }
        
        
        for (int i=0;i<V;i++)
            if (indegree[i] == 0)
                q.add(i);
                
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int ngbr: adjList.get(curr)) {
                indegree[ngbr]--;
                
                if (indegree[ngbr] == 0)
                    q.add(ngbr);
            }
        }
        
        for (int i=0;i<V;i++)
            if (indegree[i] > 0)
                return false;
                
        return true;
    }
}