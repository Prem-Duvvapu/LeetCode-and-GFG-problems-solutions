class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        int[] res=new int[numCourses];
        int pos = 0;

        for (int i=0; i<numCourses; i++)
            adj.add(new ArrayList<>());

        for (int i=0; i<n; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        for (int i=0; i<numCourses; i++)
            if (indegree[i]==0)
                q.add(i);

        while (!q.isEmpty()) {
            int curr = q.poll();
            res[pos++] = curr;

            for (int neighbour: adj.get(curr)) {
                indegree[neighbour]--;
                if (indegree[neighbour]==0)
                    q.add(neighbour);
            }
        }

        for (int i=0; i<numCourses; i++)
            if (indegree[i]!=0)
                return new int[]{};

        return res;
    }
}