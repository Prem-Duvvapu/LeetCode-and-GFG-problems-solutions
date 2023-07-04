class Solution {
    public int singleNumber(int[] nums) {
        int ones=0;
        int twos=0;

        for (int val: nums)
        {
            ones=(ones^val) & ~twos;
            twos=(twos^val) & ~ones;
        }

        return ones;
    }
}