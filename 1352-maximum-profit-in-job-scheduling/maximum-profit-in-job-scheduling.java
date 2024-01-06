class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        int[][] a=new int[n][3];
        int[] dp=new int[n];
        Arrays.fill(dp,-1);

        for (int i=0;i<n;i++) {
            a[i][0]=startTime[i];
            a[i][1]=endTime[i];
            a[i][2]=profit[i];
        }

        Comparator<int[]> com=new Comparator<>() {
            public int compare(int[] x,int[] y) {
                return (x[0]-y[0]);
            }
        };

        Arrays.sort(a,com);
        return solve(0,a,dp);
    }

    private int solve(int pos,int[][] a,int[] dp) {
        if (pos>=a.length)
            return 0;

        if (dp[pos]!=-1)
            return dp[pos];

        int notPick=solve(pos+1,a,dp);
        int next=bs(a,pos+1,a[pos][1]);
        int pick=a[pos][2]+solve(next,a,dp);

        return dp[pos]=Math.max(pick,notPick);
    }

    private int bs(int[][] a,int pos,int val) {
        int low=pos;
        int high=a.length-1;
        int index=a.length;
        while (low<=high) {
            int mid=low+(high-low)/2;
            if (a[mid][0]>=val) {
                index=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return index;
    }
}