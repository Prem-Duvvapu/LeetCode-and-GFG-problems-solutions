class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();

        for (int val: nums)
            map.put(val,map.getOrDefault(val,0)+1);

        for (Map.Entry<Integer,Integer> m: map.entrySet())
        {
            if (m.getValue()==1)
            {
                res=m.getKey();
                break;
            }
        }

        return res;
    }
}