class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] cnt=new int[n];
        boolean[][] connection=new boolean[n][n];

        for (int[] e: roads)
        {
            cnt[e[0]]++;
            cnt[e[1]]++;
            connection[e[0]][e[1]]=true;
            connection[e[1]][e[0]]=true;
        }

        int maxRank=0;
        for (int i=0;i<n;i++)
        {
            for (int j=i+1;j<n;j++)
            {
                int a=cnt[i];
                int b=cnt[j];
                int curr=a+b;
                
                if (connection[i][j])
                    curr--;

                maxRank=Math.max(curr,maxRank);
            }
        }

        return maxRank;
    }
}