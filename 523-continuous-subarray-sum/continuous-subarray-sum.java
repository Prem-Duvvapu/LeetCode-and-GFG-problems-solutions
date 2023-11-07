class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int currSum=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);

        for (int i=0;i<n;i++)
        {
            currSum+=nums[i];
            currSum%=k;

            if (map.containsKey(currSum))
            {
                if (i-map.get(currSum)>1)
                    return true;
            }
            else
                map.put(currSum,i);
        }

        return false;
    }
}