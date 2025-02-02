//There should be only one peak value when there are distinct numbers in the array
//TC: O(n)
//SC: O(1)

class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        int peakCount=0;

        for (int i=0;i<n;i++)
            if (nums[i]>nums[(i+1)%n])
                peakCount++;

        return (peakCount<=1);
    }
}