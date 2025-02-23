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
        Queue<Integer> q=new LinkedList<>();
        q.add(initialSource);

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
            int curr=q.poll();
            for (Node neighbour: adjList.get(curr)) {
                if (dist[curr]+neighbour.wt<dist[neighbour.dest]) {
                    dist[neighbour.dest]=dist[curr]+neighbour.wt;
                    q.add(neighbour.dest);
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