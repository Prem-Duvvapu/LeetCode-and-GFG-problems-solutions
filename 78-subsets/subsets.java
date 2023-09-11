class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        solve(0,new ArrayList<>(),nums,res);
        return res;
    }

    private void solve(int pos,List<Integer> currList,int[] nums,List<List<Integer>> res)
    {
        if (pos==nums.length)
        {
            res.add(new ArrayList<>(currList));
            return;
        }

        //pick
        currList.add(nums[pos]);
        solve(pos+1,currList,nums,res);
        currList.remove(currList.size()-1);

        //not pick
        solve(pos+1,currList,nums,res);
    }
}