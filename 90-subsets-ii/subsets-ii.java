class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        solve(0,new ArrayList<>(),nums,res);
        return res;
    }

    private void solve(int pos,List<Integer> curr,int[] nums,List<List<Integer>> res)
    {
        res.add(new ArrayList<>(curr));

        if (pos==nums.length)
            return;

        for (int i=pos;i<nums.length;i++)
        {
            if (i>pos && nums[i]==nums[i-1])
                continue;

            curr.add(nums[i]);
            solve(i+1,curr,nums,res);
            curr.remove(curr.size()-1);
        }
    }
}