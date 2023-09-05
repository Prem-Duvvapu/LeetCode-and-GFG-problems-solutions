class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        solve(0,new ArrayList<>(),nums,res);
        return res;
    }

    private void solve(int pos,List<Integer> currList,int[] nums,List<List<Integer>> res)
    {
        res.add(new ArrayList<>(currList));

        for (int i=pos;i<nums.length;i++)
        {
            if (i>pos && nums[i]==nums[i-1])
                continue;

            currList.add(nums[i]);
            solve(i+1,currList,nums,res);
            currList.remove(currList.size()-1);
        }
    }
}