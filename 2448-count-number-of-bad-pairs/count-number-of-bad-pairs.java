class Solution {
    public long countBadPairs(int[] nums) {
        int n=nums.length;
        long good=0;
        Map<Integer,Integer> map=new HashMap<>();
        long total=1L*n*(n-1)/2;

        for (int i=0;i<n;i++)
        {
            int key=i-nums[i];
            int value=map.getOrDefault(key,0);
            map.put(key,value+1);
            good+=value;
        }

        return (total-good);
    }
}