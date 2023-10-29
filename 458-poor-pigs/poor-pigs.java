class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int trials=minutesToTest/minutesToDie+1;
        int pigs=0;

        while ((int)Math.pow(trials,pigs)<buckets)
            pigs++;

        return pigs;
    }
}