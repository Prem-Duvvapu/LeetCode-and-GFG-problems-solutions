class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int positiveIndex = 0;
        int negativeIndex = 1;

        for (int val: nums) {
            if (val > 0) {
                res[positiveIndex] = val;
                positiveIndex += 2;
            } else {
                res[negativeIndex] = val;
                negativeIndex += 2;
            }
        }

        return res;
    }
}