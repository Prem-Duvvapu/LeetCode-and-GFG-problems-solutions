class Edge
{
    int src;
    int dest;
    public Edge(int s,int d)
    {
        src=s;
        dest=d;
    }
}

class Solution {
    private boolean isCycleUtil(ArrayList<Edge>[] graph,int curr,boolean[] visited,boolean[] recStack)
    {
        visited[curr]=true;
        recStack[curr]=true;

        for (int i=0;i<graph[curr].size();i++)
        {
            Edge e=graph[curr].get(i);

            if (recStack[e.dest])
                return true;

            if (!visited[e.dest])
                if (isCycleUtil(graph,e.dest,visited,recStack))
                    return true;
        }

        recStack[curr]=false;
        return false;
    }

    private boolean isCycle(ArrayList<Edge>[] graph)
    {
        boolean[] visited=new boolean[graph.length];
        boolean[] recStk=new boolean[graph.length];

        for (int i=0;i<graph.length;i++)
        {
            if (!visited[i])
                if (isCycleUtil(graph,i,visited,recStk))
                    return true;
        }

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Edge>[] graph=new ArrayList[numCourses];

        for (int i=0;i<numCourses;i++) 
            graph[i]=new ArrayList<>();

        for (int i=0;i<prerequisites.length;i++)
            graph[prerequisites[i][0]].add(new Edge(prerequisites[i][0],prerequisites[i][1]));

        return !(isCycle(graph));
    }
}