class Solution {
    int N,GOAL,K;
    int mod=1_000_000_007;
    long[][] dp=new long[101][101];

    public long solve(int count_song,int count_unique)
    {
        //Base case
        if (count_song==GOAL)
        {
            if (count_unique==N)
                return dp[count_song][count_unique]=1;
            return 0;
        }

        if (dp[count_song][count_unique]!=-1)
            return dp[count_song][count_unique];

        long result=0;

        //option-1 : Play a unique song
        if (count_unique<N)
            result+=(N-count_unique)*solve(count_song+1,count_unique+1);

        //option-2: Replay a song
        if (count_unique>K)
            result+=(count_unique-K)*solve(count_song+1,count_unique);

        return dp[count_song][count_unique]=result%mod;
    }

    public int numMusicPlaylists(int n, int goal, int k) {
        N=n;
        GOAL=goal;
        K=k;
        for (int i=0;i<=100;i++)
            for (int j=0;j<=100;j++)
                dp[i][j]=-1;
        return (int)solve(0,0);
    }
}