class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        
        for (int val: nums)
            map.put(val,map.getOrDefault(val,0)+1);
        
        for (Map.Entry<Integer,Integer> m: map.entrySet())
        {
            if (m.getValue()==1)
                return -1;
            
            if (m.getValue()%3==0)
                ans+=(m.getValue()/3);
            else
                ans+=(m.getValue()/3+1);
        }
        
        return ans;
            
    }
}