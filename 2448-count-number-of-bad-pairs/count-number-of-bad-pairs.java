class Solution {
    public long countBadPairs(int[] nums) {
        int n=nums.length;
        long res=0;
        Map<Integer,Integer> map=new HashMap<>();

        for (int i=0;i<n;i++)
        {
            int key=i-nums[i];
            int value=map.getOrDefault(key,0);
            map.put(key,value+1);
            
            //bad pairs= nums of pairs ending at ( i )-valid pairs( value ) ending at ( i ) ;
            res+=(i-value);
        }

        return res;
    }
}