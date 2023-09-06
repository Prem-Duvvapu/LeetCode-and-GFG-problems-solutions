class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        solve(3,0,0,new ArrayList<>(),nums,result);
        return result;
    }

    private void solve(int k,int start,int target,List<Integer> currList,int[] nums,List<List<Integer>> result)
    {
        //base case
        if (k==2)
        {
            int left=start;
            int right=nums.length-1;

            while (left<right)
            {
                if (nums[left]+nums[right]<target)
                    left++;
                else if (nums[left]+nums[right]>target)
                    right--;
                else
                {
                    currList.add(nums[left]);
                    currList.add(nums[right]);
                    result.add(new ArrayList<>(currList));
                    currList.remove(currList.size()-1);
                    currList.remove(currList.size()-1);
                    left++;
                    right--;

                    while (left<right && nums[left]==nums[left-1])
                        left++;
                }
            }

            return;
        }

        for (int i=start;i<nums.length;i++)
        {
            if (i>start && nums[i]==nums[i-1])
                continue;

            currList.add(nums[i]);
            solve(k-1,i+1,target-nums[i],currList,nums,result);
            currList.remove(currList.size()-1);
        }
    }
}