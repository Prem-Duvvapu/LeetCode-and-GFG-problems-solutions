class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n=startTime.length;
        int[] freeTime=new int[n+1];
        int prev=0;

        for (int i=0;i<n;i++) {
            freeTime[i]=startTime[i]-prev;
            prev=endTime[i];
        }
        
        freeTime[n]=eventTime-prev;
        int[] largestRight=new int[n+1];

        for (int i=n-1;i>=0;i--)
            largestRight[i]=Math.max(largestRight[i+1],freeTime[i+1]);

        int largestLeft=0;
        int res=0;

        // System.out.println(Arrays.toString(freeTime));

        for (int i=1;i<=n;i++) {
            //time occupied by current meeting
            int currDiff=endTime[i-1]-startTime[i-1];

            //shifting the meeting to another interval to the left or to the right
            if (largestLeft>=currDiff || largestRight[i]>=currDiff)
                res=Math.max(res,freeTime[i-1]+currDiff+freeTime[i]);

            //move to adjacent leftside gap or adjacent rightside gap
            res=Math.max(res,freeTime[i-1]+freeTime[i]);

            largestLeft=Math.max(largestLeft,freeTime[i-1]);
        }

        return res;
    }
}