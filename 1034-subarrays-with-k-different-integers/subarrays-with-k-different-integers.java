class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int res=solve(nums,k)-solve(nums,k-1);
        return res;
    }

    private int solve(int[] nums,int k) {
        int left=0;
        int right=0;
        int cnt=0;
        Map<Integer,Integer> map=new HashMap<>();

        while (right<nums.length) {
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while (map.size()>k) {
                int val=map.get(nums[left]);
                val--;
                if (val==0)
                    map.remove(nums[left]);
                else
                    map.put(nums[left],val);
                left++;
            }

            cnt+=(right-left+1);
            right++;
        }

        return cnt;
    }
}