class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        int k=0;
        int res=0;

        for (int val: nums)
            set.add(val);

        k=set.size(); //no. of distint elements
        res=helper(nums,k,n)-helper(nums,k-1,n);

        return res;
    }

    //returns the cnt of subarrays in which distinct elements is less than or equal to k
    public int helper(int[] nums,int k,int n) {
        if (k<=0)
            return 0;

        int totalCnt=0;
        int left=0;
        int right=0;
        Map<Integer,Integer> freq=new HashMap<>();

        while (right<n) {
            freq.put(nums[right],freq.getOrDefault(nums[right],0)+1);

            while (freq.size()>k) {
                int val=freq.get(nums[left]);
                if (val==1)
                    freq.remove(nums[left]);
                else
                    freq.put(nums[left],val-1);
                left++;
            }

            totalCnt+=(right-left+1);
            right++;
        }

        return totalCnt;
    }
}