class Solution {
    public int findNumbers(int[] nums) {
        int n=nums.length;
        int res=0;

        for (int val: nums) {
            int digitsCount=(int)Math.log10(val)+1;

            if ((digitsCount&1)==0) //even
                res++;
        }

        return res;
    }
}