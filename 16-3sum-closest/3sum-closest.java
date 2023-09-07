class Solution {
    int ans=(int)(1e9);

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        solve(3,0,0,target,nums);
        return ans;
    }

    private void solve(int k,int pos,int sum,int target,int[] nums)
    {
        if (k==2)
        {
            int left=pos;
            int right=nums.length-1;
            while (left<right)
            {
                sum=sum+nums[left]+nums[right];
                // System.out.println(sum+" "+(pos-1)+" "+left+" "+right);
                if (Math.abs(sum-target)<Math.abs(ans-target))
                    ans=sum;
                int temp=sum;
                temp=temp-(nums[left]+nums[right]);
                if (sum<target) 
                    left++;
                else
                    right--;
                sum=temp;
            }
            return;
        }

        for (int i=pos;i<nums.length;i++)
        {
            if (i>pos && nums[i]==nums[i-1])
                continue;

            solve(k-1,i+1,sum+nums[i],target,nums);
        }
    }
}