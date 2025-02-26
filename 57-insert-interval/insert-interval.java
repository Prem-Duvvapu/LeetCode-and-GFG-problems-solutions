class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int[][] res=new int[n+1][2];
        for (int i=0;i<n;i++) {
            res[i][0]=intervals[i][0];
            res[i][1]=intervals[i][1];
        }

        res[n][0]=newInterval[0];
        res[n][1]=newInterval[1];

        return merge(res);
    }

    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<int[]> res=new ArrayList<>();

        Arrays.sort(intervals,(a,b) -> (a[0]-b[0]));

        int i=0;
        while (i<n) {
            int start=intervals[i][0];
            int end=intervals[i][1];

            if (!res.isEmpty() && start<=res.get(res.size()-1)[1])
                continue;

            int j=i+1;
            while (j<n) {
                if (intervals[j][0]<=end)
                    end=Math.max(end,intervals[j][1]);
                else
                    break;

                j++;
            }

            res.add(new int[]{start,end});
            i=j;
        }

        return res.toArray(new int[res.size()][2]);
    }
}