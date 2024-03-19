class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt=new int[26];
        for (char ch: tasks)
            cnt[ch-'A']++;

        Arrays.sort(cnt);
        int res=tasks.length;

        for (int i=25;i>=0;i--)
            if (cnt[i]>0)
                res=Math.max(res,(cnt[i]-1)*(n+1)+(26-i));

        return res;
    }
}