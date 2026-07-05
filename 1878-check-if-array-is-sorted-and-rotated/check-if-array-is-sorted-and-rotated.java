class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int peakPoints = 0;

        for (int i=0;i<n;i++) {
            if (nums[i] > nums[(i+1)%n]) {
                peakPoints++;
            }
        }

        return (peakPoints <= 1);
    }
}