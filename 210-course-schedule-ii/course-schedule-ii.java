class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        List<List<Integer>> adjList=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();

        for (int i=0;i<numCourses;i++)
            adjList.add(new ArrayList<>());

        for (int[] e: prerequisites) {
            adjList.get(e[1]).add(e[0]);
            indegree[e[0]]++;
        }
        
        for (int i=0;i<numCourses;i++)
            if (indegree[i]==0)
                q.add(i);

        while (!q.isEmpty()) {
            int curr=q.poll();

            for (int neighbour: adjList.get(curr)) {
                indegree[neighbour]--;

                if (indegree[neighbour]==0)
                    q.add(neighbour);
            }

            res.add(curr);
        }

        if (res.size()!=numCourses)
            return new int[]{};

        int[] arr=new int[numCourses];
        for (int i=0;i<numCourses;i++)
            arr[i]=res.get(i);

        return arr;
    }
}