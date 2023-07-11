class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new ArrayList<>();

        for (int i=0;i<nums.length;i++)
        {
            int val=Math.abs(nums[i])%100001;
            if (nums[val-1]>0)
                nums[val-1]*=-1;
            else if (nums[val-1]<0)
                nums[val-1]=Math.abs(nums[val-1])+100001;
        }

        for (int i=0;i<nums.length;i++)
            if (nums[i]>100001)
                res.add(i+1);

        return res;
    }
}