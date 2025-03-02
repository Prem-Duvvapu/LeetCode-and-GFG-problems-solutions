class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();

        int numOfSubsets=(1<<n);

        for (int i=0;i<numOfSubsets;i++) {
            List<Integer> subset=new ArrayList<>();
            for (int pos=0;pos<n;pos++) {
                if ((i&(1<<pos))>0)
                    subset.add(nums[pos]);
            }
            res.add(subset);
        }

        return res;
    }
}