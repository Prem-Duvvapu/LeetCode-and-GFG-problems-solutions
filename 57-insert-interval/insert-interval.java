class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int[]> res=new ArrayList<>();
        int[] temp=new int[2];
        temp[0]=newInterval[0];
        temp[1]=newInterval[1];
        int i=0;

        while (i<n && intervals[i][1]<newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        while (i<n && intervals[i][0]<=temp[1]) {
            temp[0]=Math.min(intervals[i][0],temp[0]);
            temp[1]=Math.max(intervals[i][1],temp[1]);
            i++;
        }
        res.add(temp);

        while (i<n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][2]);
    }
}