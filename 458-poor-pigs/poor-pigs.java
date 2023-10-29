class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int trials=minutesToTest/minutesToDie+1;
        int ans=0;

        while ((int)Math.pow(trials,ans)<buckets)
            ans++;

        return ans;
    }
}