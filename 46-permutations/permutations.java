class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        solve(new ArrayList<>(),new boolean[nums.length],nums,res);
        return res;
    }

    private void solve(List<Integer> currList,boolean[] visited,int[] nums,List<List<Integer>> res)
    {
        if (currList.size()==nums.length)
        {
            res.add(new ArrayList<>(currList));
            return;
        }

        for (int i=0;i<nums.length;i++)
        {
            if (visited[i])
                continue;

            currList.add(nums[i]);
            visited[i]=true;
            solve(currList,visited,nums,res);
            visited[i]=false;
            currList.remove(currList.size()-1);
        }
    }
}