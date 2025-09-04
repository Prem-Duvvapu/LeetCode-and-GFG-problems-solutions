class Pair {
    long time;
    int node;

    Pair(long time,int node) {
        this.time = time;
        this.node = node;
    }
}

class Solution {
    public static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adjList = new ArrayList<>();
        long[] timeArr = new long[n];
        int[] ways = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Long.compare(x.time, y.time));
        int src = 0;
        int dest = n-1;

        Arrays.fill(timeArr, Long.MAX_VALUE);

        for (int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for (int[] e: roads) {
            int u = e[0];
            int v = e[1];
            int t = e[2];

            adjList.get(u).add(new Pair(t,v));
            adjList.get(v).add(new Pair(t,u));
        }

        timeArr[src] = 0;
        ways[src] = 1;
        pq.add(new Pair(0,src));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long currTime = curr.time;
            int currNode = curr.node;

            for (Pair ngbr: adjList.get(currNode)) {
                long newTime = currTime + ngbr.time;

                if (newTime < timeArr[ngbr.node]) {
                    timeArr[ngbr.node] = newTime;
                    ways[ngbr.node] = ways[currNode];
                    pq.add(new Pair(timeArr[ngbr.node], ngbr.node));
                } else if (newTime == timeArr[ngbr.node]) {
                    ways[ngbr.node] = (ways[ngbr.node] + ways[currNode])%MOD;
                }
            }
        }

        return ways[dest];
    }
}