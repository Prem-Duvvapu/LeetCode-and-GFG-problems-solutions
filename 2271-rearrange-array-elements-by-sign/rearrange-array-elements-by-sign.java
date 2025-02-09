//Optimal
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int positiveIndex=0;
        int negativeIndex=1;

        for (int i=0;i<n;i++) {
            if (nums[i]>0) {
                res[positiveIndex]=nums[i];
                positiveIndex+=2;
            } else {
                res[negativeIndex]=nums[i];
                negativeIndex+=2;
            }
        }

        return res;
    }
}