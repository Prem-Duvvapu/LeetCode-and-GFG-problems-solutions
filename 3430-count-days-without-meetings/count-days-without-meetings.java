class Solution {
    public int countDays(int days, int[][] meetings) {
        int n=meetings.length;
        int[][] sortedMeetings=new int[n][2];
        int res=0;

        for (int i=0;i<n;i++) {
            sortedMeetings[i][0]=meetings[i][0];
            sortedMeetings[i][1]=meetings[i][1];
        }

        Arrays.sort(sortedMeetings, (a,b) -> Integer.compare(a[0],b[0]));
        int prevEnd=0;

        for (int i=0;i<n;i++) {
            if (sortedMeetings[i][0]>prevEnd+1)
                res+=(sortedMeetings[i][0]-prevEnd-1);

            prevEnd=Math.max(prevEnd,sortedMeetings[i][1]);
        }

        res+=(days-prevEnd);
        return res;
    }
}