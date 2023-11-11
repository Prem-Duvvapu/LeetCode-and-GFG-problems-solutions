class Edge
{
    int src;
    int dest;
    int cost;
    Edge(int _src,int _dest,int _cost)
    {
        src=_src;
        dest=_dest;
        cost=_cost;
    }
}

class Pair implements Comparable<Pair>
{
    int n;
    int path;

    Pair(int _n,int _path)
    {
        n=_n;
        path=_path;
    }

    public int compareTo(Pair p2)
    {
        return (this.path-p2.path);
    }
}

class Graph {
    ArrayList<Edge>[] graph;

    public Graph(int n, int[][] edges) {
        graph=new ArrayList[n];
        for (int i=0;i<n;i++)
            graph[i]=new ArrayList<>();
        for (int i=0;i<edges.length;i++)
        {
            int[] curr=edges[i];
            graph[curr[0]].add(new Edge(curr[0],curr[1],curr[2]));
        }
    }
    
    public void addEdge(int[] edge) {
        graph[edge[0]].add(new Edge(edge[0],edge[1],edge[2]));
    }
    
    public int shortestPath(int node1, int node2) {
        int[] dist=dijkstra(node1);
        if (dist[node2]==Integer.MAX_VALUE)
            return -1;
        return dist[node2];
    }

    private int[] dijkstra(int src)
    {
        int n=graph.length;
        int dist[]=new int[n];
        boolean[] visited=new boolean[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        PriorityQueue<Pair> q=new PriorityQueue<>();
        q.offer(new Pair(src,0));

        while (!q.isEmpty())
        {
            Pair curr=q.poll();
            if (!visited[curr.n])
            {
                visited[curr.n]=true;
                for (int i=0;i<graph[curr.n].size();i++)
                {
                    Edge e=graph[curr.n].get(i);
                    if (!visited[e.dest] && dist[e.src]+e.cost<dist[e.dest])
                    {
                        dist[e.dest]=dist[e.src]+e.cost;
                        q.add(new Pair(e.dest,dist[e.dest]));
                    }   
                }
            }
        }

        return dist;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */