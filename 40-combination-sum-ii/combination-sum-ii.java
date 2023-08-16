class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        solve(0,new ArrayList<>(),target,candidates,res);
        return res;
    }

    private void solve(int pos,List<Integer> curr,int target,int[] candidates,List<List<Integer>> res)
    {
        if (target==0)
        {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i=pos;i<candidates.length;i++)
        {
            if (i>pos && candidates[i]==candidates[i-1])
                continue;

            if (candidates[i]>target)
                return;

            curr.add(candidates[i]);
            solve(i+1,curr,target-candidates[i],candidates,res);
            curr.remove(curr.size()-1);
        }
    }
}