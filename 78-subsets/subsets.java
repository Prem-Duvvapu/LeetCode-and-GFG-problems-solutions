class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        solve(0,new ArrayList<>(),nums,res);
        return res;
    }

    private void solve(int pos,List<Integer> curr,int[] nums,List<List<Integer>> res)
    {
        if (pos==nums.length)
        {
            res.add(new ArrayList<>(curr));
            return;
        }

        //pick
        curr.add(nums[pos]);
        solve(pos+1,curr,nums,res);
        curr.remove(curr.size()-1);

        //not pick
        solve(pos+1,curr,nums,res);
    }
}