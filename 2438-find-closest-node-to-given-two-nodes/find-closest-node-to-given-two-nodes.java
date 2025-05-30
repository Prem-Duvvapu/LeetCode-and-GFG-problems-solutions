class Pair {
    int node;
    int dist;

    public Pair(int node,int dist) {
        this.node=node;
        this.dist=dist;
    }
}

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int minDist=Integer.MAX_VALUE;
        int resNode=-1;
        int[] distArr1=dijkstraAlgo(edges,node1,n);
        int[] distArr2=dijkstraAlgo(edges,node2,n);
        
        for (int i=0;i<n;i++) {
            if (distArr1[i]!=Integer.MAX_VALUE && distArr2[i]!=Integer.MAX_VALUE) {
                if (Math.max(distArr1[i],distArr2[i]) < minDist) {
                    minDist=Math.max(distArr1[i],distArr2[i]);
                    resNode=i;
                }
            }
        }

        return resNode;
    }

    public int[] dijkstraAlgo(int[] edges,int src,int n) {
        int[] distArr=new int[n];
        Arrays.fill(distArr,Integer.MAX_VALUE);

        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> Integer.compare(x.dist,y.dist));
        pq.add(new Pair(src,0));
        distArr[src]=0;

        while (!pq.isEmpty()) {
            Pair curr=pq.poll();
            int currNode=curr.node;
            int currDist=curr.dist;

            int ngbrNode=edges[currNode];
            if (ngbrNode!=-1 && currDist+1<distArr[ngbrNode]) {
                distArr[ngbrNode]=currDist+1;
                pq.add(new Pair(ngbrNode,distArr[ngbrNode]));
            }
        }

        return distArr;
    }
}