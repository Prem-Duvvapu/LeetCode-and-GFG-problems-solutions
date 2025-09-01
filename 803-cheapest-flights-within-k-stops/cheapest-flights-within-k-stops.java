class Pair {
    int price;
    int node;

    Pair(int price,int node) {
        this.price = price;
        this.node = node;
    }
}

class Tuple {
    int stops;
    int price;
    int node;

    Tuple(int stops,int price,int node) {
        this.stops = stops;
        this.price = price;
        this.node = node;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>>  adjList = new ArrayList<>();
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> Integer.compare(x.stops,y.stops));
        int[] priceArr = new int[n];

        Arrays.fill(priceArr, Integer.MAX_VALUE);

        for (int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for (int[] e: flights) {
            int u = e[0];
            int v = e[1];
            int p = e[2];

            adjList.get(u).add(new Pair(p,v));
        }

        pq.add(new Tuple(0,0,src));
        priceArr[src] = 0;

        while (!pq.isEmpty()) {
            Tuple curr = pq.poll();
            int currStops = curr.stops;
            int currPrice = curr.price;
            int currNode = curr.node;

            if (currStops > k)
                continue;

            for (Pair ngbr: adjList.get(currNode)) {
                if (currPrice + ngbr.price < priceArr[ngbr.node]) {
                    priceArr[ngbr.node] = currPrice + ngbr.price;
                    pq.add(new Tuple(currStops+1,priceArr[ngbr.node],ngbr.node));
                }
            }
        }

        return (priceArr[dst] != Integer.MAX_VALUE) ? priceArr[dst] : -1;
    }
}