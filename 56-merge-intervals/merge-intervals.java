class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<int[]> res=new ArrayList<>();

        Comparator<int[]> com=new Comparator<>() {
            public int compare(int[] x,int[] y) {
                if (x[0]!=y[0])
                    return Integer.compare(x[0],y[0]);

                return Integer.compare(x[1],y[1]);
            }
        };

        Arrays.sort(intervals, com);

        int start=intervals[0][0];
        int end=intervals[0][1];

        for (int i=1;i<n;i++) {
            if (intervals[i][0]<=end) {
                end=Math.max(end,intervals[i][1]);
            } else {
                res.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        res.add(new int[]{start,end});

        return res.toArray(new int[res.size()][2]);
    }
}