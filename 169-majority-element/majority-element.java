//Better
class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();

        for (int i=0;i<n;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for (Map.Entry<Integer,Integer> m: map.entrySet())
            if (m.getValue() >= (n/2+n%2))
                return m.getKey();

        return 0;
    }
}