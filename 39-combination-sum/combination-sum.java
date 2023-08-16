class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        solve(0,new ArrayList<>(),candidates,target,res);
        return res;
    }

    private void solve(int pos,List<Integer> curr,int[] candidates,int target,List<List<Integer>> res)
    {
        if (target==0)
        {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (pos==candidates.length || candidates[pos]>target)
            return;

        //pick
        curr.add(candidates[pos]);
        solve(pos,curr,candidates,target-candidates[pos],res);
        curr.remove(curr.size()-1);

        //not pick
        solve(pos+1,curr,candidates,target,res);
    }
}