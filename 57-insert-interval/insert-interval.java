class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int[]> res=new ArrayList<>();
        int start=newInterval[0];
        int end=newInterval[1];

        for (int i=0;i<n;i++) {
            if (end<intervals[i][0]) {
                res.add(new int[]{start,end});
                for (int j=i;j<n;j++)
                    res.add(intervals[j]);

                return res.toArray(new int[res.size()][2]);
            }

            if (start>intervals[i][1]) {
                res.add(intervals[i]);
            } else {
                start=Math.min(start,intervals[i][0]);
                end=Math.max(end,intervals[i][1]);
            }
        }

        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][2]);
    }
}