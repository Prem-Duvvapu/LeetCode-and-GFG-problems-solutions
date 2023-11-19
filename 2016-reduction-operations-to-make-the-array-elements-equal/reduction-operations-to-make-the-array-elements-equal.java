class Solution {
    public int reductionOperations(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> map=new TreeMap<>();
        int res=0;

        for (int val: nums)
            map.put(val,map.getOrDefault(val,0)+1);

        int k=0;
        for (Integer freq: map.values())
            res+=(freq*(k++));

        return res;
    }
}