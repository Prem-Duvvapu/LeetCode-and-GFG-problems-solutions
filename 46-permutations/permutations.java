class Solution {
    public void solve(int[] nums,List<List<Integer>> res,List<Integer> curr,boolean[] visited)
    {
        if (curr.size()==nums.length)
        {
            res.add(new ArrayList<>(curr));
            return;
        }


        for (int i=0;i<nums.length;i++)
        {
            if (visited[i])
                continue;
            curr.add(nums[i]);
            visited[i]=true;
            solve(nums,res,curr,visited);
            curr.remove(curr.size()-1);
            visited[i]=false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        solve(nums,res,new ArrayList<>(),new boolean[nums.length]);
        return res;
    }
}