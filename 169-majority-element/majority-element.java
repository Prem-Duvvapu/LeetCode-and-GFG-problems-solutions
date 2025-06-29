class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();

        for (int val: nums)
            map.put(val,map.getOrDefault(val,0)+1);
        
        for (int key: map.keySet())
            if (map.get(key)>n/2)
                return key;

        return -1;
    }
}