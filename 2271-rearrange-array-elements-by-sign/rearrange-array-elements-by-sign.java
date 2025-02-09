class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int positiveIndex=0;
        int negativeIndex=0;

        while (nums[positiveIndex]<0)
            positiveIndex++;

        while (nums[negativeIndex]>0)
            negativeIndex++;

        int pos=0;
        while (pos<n && positiveIndex<n) {
            res[pos]=nums[positiveIndex];
            positiveIndex++;
            pos+=2;
            while (positiveIndex<n && nums[positiveIndex]<0)
                positiveIndex++;
        }

        pos=1;
        while (pos<n && negativeIndex<n) {
            res[pos]=nums[negativeIndex];
            negativeIndex++;
            pos+=2;
            while (negativeIndex<n && nums[negativeIndex]>0)
                negativeIndex++;
        }

        return res;
    }
}