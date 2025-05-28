class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n=edges1.length+1;
        int m=edges2.length+1;

        List<List<Integer>> adjList1=getAdjList(edges1,n);
        List<List<Integer>> adjList2=getAdjList(edges2,m);

        int[] targetNodesCnt1=getTargetNodesCnt(adjList1,n,k);
        int[] targetNodesCnt2=getTargetNodesCnt(adjList2,m,k-1);

        int maxFromTree2=0;
        for (int val: targetNodesCnt2)
            maxFromTree2=Math.max(val,maxFromTree2);

        for (int i=0;i<n;i++)
            targetNodesCnt1[i]+=maxFromTree2;

        return targetNodesCnt1;
    }

    public List<List<Integer>> getAdjList(int[][] edges,int V) {
        List<List<Integer>> adjList=new ArrayList<>();

        for (int i=0;i<V;i++)
            adjList.add(new ArrayList<>());

        for (int[] edge: edges) {
            int u=edge[0];
            int v=edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return adjList;
    }

    public int[] getTargetNodesCnt(List<List<Integer>> adjList,int V,int k) {
        int[] targetNodesCnt=new int[V];
        Queue<Integer> q;
        boolean[] visited;

        for (int i=0;i<V;i++) {
            q=new LinkedList<>();
            visited=new boolean[V];

            q.add(i);
            visited[i]=true;
            int cnt=0;
            int temp=k;

            while (temp>=0 && !q.isEmpty()) {
                int qlen=q.size();
                cnt+=qlen;

                if (temp==0)
                    break;

                while (qlen-- > 0) {
                    int u=q.poll();

                    for (int ngbr: adjList.get(u)) {
                        if (!visited[ngbr]) {
                            visited[ngbr]=true;
                            q.add(ngbr);
                        }
                    }
                }

                temp--;
            }

            targetNodesCnt[i]=cnt;
        }

        return targetNodesCnt;
    }
}