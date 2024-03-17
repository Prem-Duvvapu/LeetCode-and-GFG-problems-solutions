class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        int start=newInterval[0];
        int end=newInterval[1];
        for (int i=0;i<intervals.length;i++)
        {
            if (end<intervals[i][0])
            {
                res.add(new int[]{start,end});
                for (int j=i;j<intervals.length;j++)
                {
                    res.add(intervals[j]);
                }
                return res.toArray(new int[res.size()][2]);
            }
            else if (start>intervals[i][1])
            {
                res.add(intervals[i]);
            }
            else
            {
                start=Math.min(start,intervals[i][0]);
                end=Math.max(end,intervals[i][1]);
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][2]);
    }
}