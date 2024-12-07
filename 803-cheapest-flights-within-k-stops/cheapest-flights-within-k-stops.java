class Node {
    int stops;
    int dest;
    int price;

    Node(int _stops, int _dest, int _price) {
        stops = _stops;
        dest = _dest;
        price = _price;
    }
}

class Pair {
    int dest;
    int price;

    Pair(int _dest, int _price) {
        dest = _dest;
        price = _price;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i=0; i<n; i++)
            graph.add(new ArrayList<>());

        for (int i=0; i<flights.length; i++)
            graph.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));

        int[] price = new int[n];
        Arrays.fill(price, (int)1e5);
        price[src]=0;

        Queue<Node> q=new ArrayDeque<>();
        q.add(new Node(0,src,0));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int currStops = curr.stops;
            int currPrice = curr.price;
            int currNode = curr.dest;

            for (Pair pair: graph.get(currNode)) {
                if (currStops == k && pair.dest != dst)
                        continue;

                int newPrice = currPrice + pair.price;

                if (price[pair.dest] > newPrice) {
                    price[pair.dest] = newPrice;
                    if (pair.dest != dst)
                        q.add(new Node(currStops+1, pair.dest, price[pair.dest]));
                }
            }
        }

        if (price[dst]==(int)1e5)
            return -1;

        return price[dst];
    }
}