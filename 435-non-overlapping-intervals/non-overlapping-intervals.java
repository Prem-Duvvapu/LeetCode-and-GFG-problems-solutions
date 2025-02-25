class IntervalsComparator implements Comparator<int[]> {
    public int compare(int[] a,int[] b) {
        if (a[1]<b[1])
            return -1;
        else if (a[1]>b[1])
            return 1;
        else if (a[0]<b[0])
            return -1;
        else if (a[0]>b[0])
            return 1;
        return 0;
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        int overlappedIntervals=1;
        IntervalsComparator ic=new IntervalsComparator();
        int res=0;
        Arrays.sort(intervals,ic);
        int prevEndTime=intervals[0][1];

        for (int i=1;i<n;i++) {
            if (intervals[i][0]>=prevEndTime) {
                overlappedIntervals++;
                prevEndTime=intervals[i][1];
            }
        }
        
        res=n-overlappedIntervals;
        return res;
    }
}