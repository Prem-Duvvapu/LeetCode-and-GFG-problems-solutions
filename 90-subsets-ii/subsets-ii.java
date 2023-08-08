class Solution {
    private void solve(int index,List<Integer> currList,int[] nums,List<List<Integer>> res)
    {
        for (int i=index;i<nums.length;i++)
        {
            if (i>index && nums[i]==nums[i-1])
                continue;

            //pick
            currList.add(nums[i]);
            solve(i+1,currList,nums,res);
            res.add(new ArrayList<>(currList));
            currList.remove(currList.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        solve(0,new ArrayList<>(),nums,res);
        return res;
    }
}