class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for (int val: nums)
            map.put(val,map.getOrDefault(val,0)+1);
        
        for (Map.Entry<Integer,Integer> m: map.entrySet())
            if (m.getValue() > n/3)
                res.add(m.getKey());

        return res;
    }
}