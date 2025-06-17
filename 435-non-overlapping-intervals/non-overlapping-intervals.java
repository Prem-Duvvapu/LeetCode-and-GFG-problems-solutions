class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        int res=0;

        Comparator<int[]> com=new Comparator<>() {
            public int compare(int[] x,int[] y) {
                if (x[1]!=y[1])
                    return Integer.compare(x[1],y[1]);

                return Integer.compare(x[0],y[0]);
            }
        };
        Arrays.sort(intervals, com);

        int prevEndTime=intervals[0][1];

        for (int i=1;i<n;i++) {
            if (intervals[i][0]<prevEndTime)
                res++;
            else
                prevEndTime=intervals[i][1];
        }

        return res;
    }
}