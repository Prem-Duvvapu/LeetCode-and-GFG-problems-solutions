class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        int prefixSum=0;

        map.put(0,1);
        for (int i=0;i<n;i++) {
            prefixSum+=nums[i];
            int remSum=prefixSum-k;

            if (map.containsKey(remSum))
                res+=(map.get(remSum));

            map.putIfAbsent(prefixSum,0);
            map.put(prefixSum,map.get(prefixSum)+1);
        }

        return res;
    }
}