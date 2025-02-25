class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int minJumps=0;
        int minIndex=0;
        int maxIndex=0;

        while (maxIndex<n-1) {
            int newMaxIndex=maxIndex;

            for (int i=minIndex;i<=maxIndex;i++) {
                newMaxIndex=Math.max(newMaxIndex,i+nums[i]);
            }

            minJumps++;
            minIndex=maxIndex+1;
            maxIndex=newMaxIndex;
        }


        return minJumps;
    }
}