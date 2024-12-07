class Pair {
    long time;
    long node;

    Pair(long time, long node) {
        this.time=time;
        this.node=node;
    }
}

class Solution {
    int mod = (int)1e9+7;

    public int countPaths(int n, int[][] roads) {
        long[] time=new long[n];
        long[] numberOfWays=new long[n];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> Long.compare(a.time,b.time));
        List<List<Pair>> adjList=new ArrayList<>();

        for (int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for (int[] road: roads) {
            adjList.get(road[0]).add(new Pair((long)road[2],(long)road[1]));
            adjList.get(road[1]).add(new Pair((long)road[2],(long)road[0]));
        }

        Arrays.fill(time, Long.MAX_VALUE);
        pq.add(new Pair(0L,0L));
        time[0]=0L;
        numberOfWays[0]=1L;

        while (!pq.isEmpty()) {
            Pair curr=pq.poll();
            long currTime=curr.time;
            long currNode=curr.node;
            // System.out.println(currTime+" "+currNode);
            // System.out.println("time "+Arrays.toString(time));
            // System.out.println("ways "+Arrays.toString(numberOfWays));
            // System.out.println("total pairs "+adjList.get(currNode).size());

            for (Pair p: adjList.get((int)currNode)) {
                long newNode=p.node;
                long newTime=p.time+currTime;
                // System.out.println("pair "+newTime+" "+newNode);

                if (newTime<time[(int)newNode]) {
                    time[(int)newNode]=newTime;
                    numberOfWays[(int)newNode]=numberOfWays[(int)currNode];
                    pq.add(new Pair(newTime,newNode));
                }
                else if (newTime==time[(int)newNode]) {
                    numberOfWays[(int)newNode] = (numberOfWays[(int)newNode]%mod + numberOfWays[(int)currNode]%mod)%mod;
                }
            }
        }

        return (int)numberOfWays[n-1];
    }
}