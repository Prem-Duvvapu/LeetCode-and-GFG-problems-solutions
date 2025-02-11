class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        int currSum=0;

        map.put(0,1);
        for (int i=0;i<n;i++) {
            currSum+=nums[i];
            int remSum=currSum-k;

            if (map.containsKey(remSum))
                res+=(map.get(remSum));

            map.putIfAbsent(currSum,0);
            map.put(currSum,map.get(currSum)+1);
        }

        return res;
    }
}