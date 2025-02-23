class Node {
    int dest;
    int wt;

     Node(int dest,int wt) {
        this.dest=dest;
        this.wt=wt;
     }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int initialSource=k;
        List<List<Node>> adjList=new ArrayList<>();
        int[] dist=new int[n+1];
        PriorityQueue<Node> q=new PriorityQueue<>((x,y)->(x.wt-y.wt));
        q.add(new Node(initialSource,0));

        Arrays.fill(dist,(int)1e5);
        dist[initialSource]=0;

        for (int i=0;i<=n;i++)
            adjList.add(new ArrayList<>());

        for (int[] e: times) {
            int u=e[0];
            int v=e[1];
            int w=e[2];

            adjList.get(u).add(new Node(v,w));
        }

        while (!q.isEmpty()) {
            Node curr=q.poll();
            int currSrc=curr.dest;
            int currWt=curr.wt;

            for (Node neighbour: adjList.get(currSrc)) {
                if (dist[currSrc]+neighbour.wt<dist[neighbour.dest]) {
                    dist[neighbour.dest]=dist[currSrc]+neighbour.wt;
                    q.add(new Node(neighbour.dest,dist[neighbour.dest]));
                }
            }
        }

        for (int i=1;i<=n;i++)
            if (dist[i]==(int)1e5)
                return -1;

        int maxTime=-1;
        for (int i=1;i<=n;i++)
            maxTime=Math.max(maxTime,dist[i]);

        return maxTime;
    }
}