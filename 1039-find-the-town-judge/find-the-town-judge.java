class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n==1)
            return 1;

        if (trust.length==0)
            return -1;

        boolean[] visited=new boolean[n+1];

        for (int i=0;i<trust.length;i++)
            visited[trust[i][0]]=true;

        int cnt=0;
        int judge=0;
        for (int i=1;i<=n;i++) {
            if (!visited[i]) {
                cnt++;
                judge=i;
            }
        }

        if (cnt!=1)
            return -1;

        cnt=0;
        for (int i=0;i<trust.length;i++)
            if (trust[i][1]==judge)
                cnt++;

        if (cnt==n-1)
            return judge;

        return -1;
    }
}