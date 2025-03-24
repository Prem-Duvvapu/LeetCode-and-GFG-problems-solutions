class Solution {
    public int countDays(int days, int[][] meetings) {
        int n=meetings.length;
        int res=0;

        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0],b[0]));
        int prevEnd=0;

        // for (int i=0;i<n;i++)
        //     System.out.println(Arrays.toString(meetings[i]));

        for (int i=0;i<n;i++) {
            if (meetings[i][0]>prevEnd+1)
                res+=(meetings[i][0]-prevEnd-1);

            prevEnd=Math.max(prevEnd,meetings[i][1]);
        }

        res+=(days-prevEnd);
        return res;
    }
}