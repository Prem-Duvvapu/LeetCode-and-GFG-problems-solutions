class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int minJumps=0;
        int start=0;
        int end=0;

        while (end<n-1) {
            int newEnd=end;

            for (int i=start;i<=end;i++)
                newEnd=Math.max(newEnd,i+nums[i]);

            start=end+1;
            end=newEnd;

            minJumps++;
        }

        return minJumps;
    }
}