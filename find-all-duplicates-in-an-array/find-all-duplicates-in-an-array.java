class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new ArrayList<>();

        for (int i=0;i<nums.length;i++)
        {
            int val=Math.abs(nums[i])%100000;
            if (nums[val-1]>0)
                nums[val-1]*=-1;
            else if (nums[val-1]<0)
                nums[val-1]=Math.abs(nums[val-1])+100000;
        }

        for (int i=0;i<nums.length;i++)
            if (nums[i]>100000)
                res.add(i+1);

        return res;
    }
}