class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();

        int num=(1<<n);

        for (int i=0;i<num;i++) {
            List<Integer> subset=new ArrayList<>();
            for (int pos=0;pos<n;pos++) {
                if (((i>>pos)&1)==1)
                    subset.add(nums[pos]);
            }
            res.add(subset);
        }

        return res;
    }
}