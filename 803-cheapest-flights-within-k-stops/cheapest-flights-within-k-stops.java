class Node {
    int stops;
    int dist;
    int dest;

    Node(int stops,int dist,int dest) {
        this.stops=stops;
        this.dist=dist;
        this.dest=dest;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList=new ArrayList<>();

        for (int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for (int[] e: flights) {
            int u=e[0];
            int v=e[1];
            int d=e[2];

            adjList.get(u).add(new int[]{v,d});
        }

        int[] dist=new int[n];
        for (int i=0;i<n;i++)
            dist[i]=(int)1e7;

        dist[src]=0;
        Queue<Node> pq=new PriorityQueue<>((x,y)->(x.stops-y.stops));
        pq.add(new Node(0,0,src));

        while (!pq.isEmpty()) {
            Node curr=pq.poll();

            int currStops=curr.stops;
            int currDist=curr.dist;
            int newSrc=curr.dest;
            
            for (int[] ngbr: adjList.get(newSrc)) {
                if (currStops==k && ngbr[0]!=dst)
                    continue;

                int oldDist=dist[ngbr[0]];
                int newDist=currDist+ngbr[1];

                if (newDist<oldDist) {
                    dist[ngbr[0]]=newDist;
                    pq.add(new Node(currStops+1,newDist,ngbr[0]));
                }
            }
        }

        if (dist[dst]==(int)1e7)
            return -1;

        return dist[dst];
    }
}