//Optimal - Boyer Moore Majority Voting Alogrithm
class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int res=nums[0];
        int cnt=1;

        for (int i=1;i<n;i++)  {
            if (cnt==0) {
                res=nums[i];
                cnt=1;
            } else if (nums[i]==res) {
                cnt++;
            } else {
                cnt--;
            }
        }

        return res;
    }
}