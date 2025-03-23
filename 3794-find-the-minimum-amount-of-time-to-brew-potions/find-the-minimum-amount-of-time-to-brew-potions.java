class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n=skill.length;
        int m=mana.length;
        long[] previousEndTime=new long[n];

        for (int i=0;i<m;i++) {
            long currTotalTime=0;
            long maxDiff=0;

            for (int j=0;j<n;j++) {
                maxDiff=Math.max(maxDiff,previousEndTime[j]-currTotalTime);
                currTotalTime+=((long)skill[j]*(long)mana[i]);
                previousEndTime[j]=currTotalTime;
            }

            for (int j=0;j<n;j++) {
                previousEndTime[j]+=maxDiff;
            }
        }

        return previousEndTime[n-1];
    }
}