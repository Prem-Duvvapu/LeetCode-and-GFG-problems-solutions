class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0;i<n;i++)
        {
            if (i>0 && nums[i]==nums[i-1])
                continue;
            int left=i+1;
            int right=n-1;
            while (left<right)
            {
                if (nums[i]+nums[left]+nums[right]<0)
                    left++;
                else if (nums[i]+nums[left]+nums[right]>0)
                    right--;
                else
                {
                    List<Integer> curr=new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[left]);
                    curr.add(nums[right]);
                    res.add(curr);
                    left++;
                    right--;
                    while (left<right && nums[left]==nums[left-1])
                        left++;
                    while (right>left && nums[right]==nums[right+1])
                        right--;
                }
            }
        }

        return res;
    }
}