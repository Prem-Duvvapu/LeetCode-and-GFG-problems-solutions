//bfs

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
    private boolean dfs(ArrayList<Edge>[] graph,Set<Integer> set,int curr,boolean[] visited)
    {
        visited[curr]=true;
        if (set.contains(curr))
            return true;

        for (int i=0;i<graph[curr].size();i++)
        {
            Edge e=graph[curr].get(i);

            if (!visited[e.dest])
                if (dfs(graph,set,e.dest,visited))
                    return true;
        }

        return false;
    }

    public boolean canReach(int[] arr, int start) {
        Set<Integer> set=new HashSet<>();
        int n=arr.length;

        for (int i=0;i<n;i++)
            if (arr[i]==0)
                set.add(i);

        ArrayList<Edge>[] graph=new ArrayList[n];

        for (int i=0;i<n;i++)
            graph[i]=new ArrayList<>();

        for (int i=0;i<n;i++)
        {
            if (arr[i]!=0 && i+arr[i]<n)
                graph[i].add(new Edge(i,i+arr[i]));

            if (arr[i]!=0 && i-arr[i]>=0)
                graph[i].add(new Edge(i,i-arr[i]));
        }
        
        boolean[] visited=new boolean[n];
        return dfs(graph,set,start,visited);
    }
}