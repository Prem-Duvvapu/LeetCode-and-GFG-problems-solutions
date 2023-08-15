class Solution {
    private int solve(int pos,int[] nums,int target,Map<String,Integer> map)
    {
        if (pos==nums.length)
        {
            if (target==0)
                return 1;
            else
                return 0;
        }

        String s=Integer.toString(pos)+" "+Integer.toString(target);
        if (map.containsKey(s))
            return map.get(s);

        int plus=solve(pos+1,nums,target-nums[pos],map);
        int minus=solve(pos+1,nums,target+nums[pos],map);

        map.put(s,plus+minus);
        
        return plus+minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<String,Integer> map=new HashMap<>();
        return solve(0,nums,target,map);
    }
}