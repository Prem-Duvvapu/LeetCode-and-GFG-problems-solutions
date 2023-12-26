//Topological sort
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int v=numCourses;
        int n=prerequisites.length;
        List<Integer>[] graph=new ArrayList[v];
        for (int i=0;i<v;i++)
            graph[i]=new ArrayList<>();

        for (int[] i: prerequisites)
            graph[i[1]].add(i[0]);

        //topo sort
        int[] indegree=new int[v];
        Queue<Integer> q=new LinkedList<>();
        int[] res=new int[v];
        int pos=0;

        for (int i=0;i<v;i++)
            for (int node: graph[i])
                indegree[node]++;

        for (int i=0;i<v;i++)
            if (indegree[i]==0)
                q.add(i);

        while (!q.isEmpty()) {
            int curr=q.poll();
            res[pos++]=curr;

            for (int neighbour: graph[curr]) {
                indegree[neighbour]--;
                if (indegree[neighbour]==0)
                    q.add(neighbour);
            }
        }

        for (int i=0;i<v;i++)
            if (indegree[i]>0)
                return new int[0];

        return res;
    }
}