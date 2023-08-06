class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));

        int start=intervals[0][0];
        int end=intervals[0][1];
        for (int[] curr: intervals)
        {
            if (curr[0]<=end)
                end=Math.max(end,curr[1]);
            else
            {
                res.add(new int[]{start,end});
                start=curr[0];
                end=curr[1];
            }
        }
        res.add(new int[]{start,end});

        return res.toArray(new int[res.size()][2]);
    }
}