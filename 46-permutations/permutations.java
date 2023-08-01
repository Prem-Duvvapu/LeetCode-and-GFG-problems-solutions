class Solution {
    public void solve(int[] nums,List<List<Integer>> res,List<Integer> curr,Set<Integer> set)
    {
        if (curr.size()==nums.length)
        {
            res.add(new ArrayList<>(curr));
            return;
        }


        for (int i=0;i<nums.length;i++)
        {
            if (set.contains(i))
                continue;
            curr.add(nums[i]);
            set.add(i);
            solve(nums,res,curr,set);
            curr.remove(curr.size()-1);
            set.remove(i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        solve(nums,res,new ArrayList<>(),new HashSet<>());
        return res;
    }
}