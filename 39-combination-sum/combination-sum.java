class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        solve(0,new ArrayList<>(),target,candidates,res);
        return res;
    }

    private void solve(int pos,List<Integer> currList,int target,int[] candidates,List<List<Integer>> res)
    {
        if (target==0)
        {
            res.add(new ArrayList<>(currList));
            return;
        }

        if (pos==candidates.length)
            return;

        if (candidates[pos]>target)
            return;

        //pick and stay there since infinite supply
        currList.add(candidates[pos]);
        solve(pos,currList,target-candidates[pos],candidates,res);
        currList.remove(currList.size()-1);

        //not pick
        solve(pos+1,currList,target,candidates,res);
    }
}