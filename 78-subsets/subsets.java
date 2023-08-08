class Solution {
    private void solve(int index,List<Integer> currList,int[] nums,List<List<Integer>> res)
    {
        if (index==nums.length)
        {
            res.add(new ArrayList<>(currList));
            return;
        }

        //pick
        currList.add(nums[index]);
        solve(index+1,currList,nums,res);
        currList.remove(currList.size()-1);

        //not pick
        solve(index+1,currList,nums,res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        solve(0,new ArrayList<>(),nums,res);
        return res;
    }
}