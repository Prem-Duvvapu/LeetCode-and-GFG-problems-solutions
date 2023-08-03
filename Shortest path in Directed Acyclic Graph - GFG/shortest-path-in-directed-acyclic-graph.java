//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Pair implements Comparable<Pair>
{
    int n;
    int path;
    
    Pair(int n,int path)
    {
        this.n=n;
        this.path=path;
    }
    
    public int compareTo(Pair p2)
    {
        if (this.path>p2.path)
            return 1;
        else
            return -1;
    }
}

class Edge
{
    int src;
    int dest;
    int wt;
    
    Edge(int s,int d,int w)
    {
        src=s;
        dest=d;
        wt=w;
    }
}

//User function Template for Java
class Solution {
    public void buildGraph(ArrayList<Edge>[] graph,int v,int[][] edges)
    {
        for (int i=0;i<v;i++)
            graph[i]=new ArrayList<>();
            
        for (int[] e: edges)
        {
            graph[e[0]].add(new Edge(e[0],e[1],e[2]));
        }
    }
    
    public int[] dijkstra(int v,ArrayList<Edge>[] graph,int src)
    {
        int[] distance=new int[v];
        boolean[] visited=new boolean[v];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(src,0));
        
        while (!pq.isEmpty())
        {
            Pair curr=pq.poll();
            int n=curr.n;
            int path=curr.path;
            
            if (!visited[n])
            {
                visited[n]=true;
                for (int i=0;i<graph[n].size();i++)
                {
                    Edge e=graph[n].get(i);
                    if (!visited[e.dest] && distance[e.src]+e.wt<distance[e.dest])
                    {
                        distance[e.dest]=distance[e.src]+e.wt;
                        pq.add(new Pair(e.dest,distance[e.dest]));
                    }
                }
            }
        }
        
        
        return distance;
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		int[] distance=new int[N];
		ArrayList<Edge>[] graph=new ArrayList[N];
		buildGraph(graph,N,edges);
		int src=0;
		distance=dijkstra(N,graph,src);
		
		for (int i=0;i<N;i++)
		    if (distance[i]==Integer.MAX_VALUE)
		        distance[i]=-1;
		
		return distance;
	}
}