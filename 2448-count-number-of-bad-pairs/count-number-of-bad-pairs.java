class Solution {
    public long countBadPairs(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();

        for (int i=0;i<n;i++) {
            int diff=(i-nums[i]);
            map.putIfAbsent(diff,0);
            map.put(diff,map.get(diff)+1);
        }

        int m=map.size();
        int[] a=new int[m];
        int pos=0;
        for (Map.Entry<Integer,Integer> mp: map.entrySet())
            a[pos++]=mp.getValue();

        long res=0L;
        int sum=0;
        for (int i=0;i<m;i++)
            sum+=a[i];

        for (int i=0;i<m;i++) {
            sum-=a[i];
            res+=((long)a[i]*(long)sum);
        }

        return res;
    }
}