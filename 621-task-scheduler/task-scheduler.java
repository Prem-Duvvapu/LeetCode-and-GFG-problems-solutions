class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        
        for (char ch: tasks)
            freq[ch-'A']++;

        Arrays.sort(freq);

        int maxFreq=freq[25];
        int maxFreqCnt=1;
        int i=24;

        while (i>=0 && freq[i]==freq[i+1]) {
            maxFreqCnt++;
            i--;
        }

        int minIntervals=tasks.length; //Min possible result
        int currIntervals=(n+1)*(maxFreq-1)+maxFreqCnt;
        int res=Math.max(minIntervals,currIntervals);

        return res;
    }
}