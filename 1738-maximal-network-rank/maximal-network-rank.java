class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Integer>[] graph=new ArrayList[n];
        for (int i=0;i<n;i++)
            graph[i]=new ArrayList<>();

        for (int[] e: roads)
        {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int maxRank=0;
        for (int i=0;i<n;i++)
        {
            for (int j=i+1;j<n;j++)
            {
                int a=graph[i].size();
                int b=graph[j].size();
                int curr=a+b;
                
                if (graph[i].contains(j))
                    curr--;

                maxRank=Math.max(curr,maxRank);
            }
        }

        return maxRank;
    }
}