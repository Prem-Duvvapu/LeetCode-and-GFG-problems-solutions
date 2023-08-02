class Solution {
    private void solve(int[] nums,int pos,boolean[] visited,List<List<Integer>> res,List<Integer> curr)
    {
        if (pos==nums.length)
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
            solve(nums,pos+1,visited,res,curr);
            curr.remove(curr.size()-1);
            visited[i]=false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        boolean[] visited=new boolean[n];
        solve(nums,0,visited,res,new ArrayList<>());
        return res;
    }
}