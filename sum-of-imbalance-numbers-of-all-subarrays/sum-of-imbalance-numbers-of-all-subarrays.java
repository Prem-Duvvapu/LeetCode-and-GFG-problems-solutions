class Solution {
    public int sumImbalanceNumbers(int[] nums) {
        int res=0;

        for (int i=0;i<nums.length;i++)
        {
            Set<Integer> set=new HashSet<>();
            set.add(nums[i]);
            int curr=0;
            
            for (int j=i+1;j<nums.length;j++)
            {
                if (!set.contains(nums[j]))
                {
                    int d=1;
                    if (set.contains(nums[j]-1))
                        d--;
                    if (set.contains(nums[j]+1))
                        d--;
                    
                    curr+=d;
                    set.add(nums[j]);
                }
                res+=curr;
            }
        }

        return res;
    }
}