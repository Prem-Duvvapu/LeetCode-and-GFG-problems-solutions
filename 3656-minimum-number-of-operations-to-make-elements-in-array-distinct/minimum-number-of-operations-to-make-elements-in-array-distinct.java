class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        int cntOfRemovalElements=0;
        int res=0;
        int i=n-1;

        while (i>=0) {
            if (set.contains(nums[i]))
                break;

            set.add(nums[i]);
            i--;
        }

        cntOfRemovalElements=i+1;
        res=cntOfRemovalElements/3;

        if (cntOfRemovalElements%3!=0)
            res++;

        return res;
    }
}