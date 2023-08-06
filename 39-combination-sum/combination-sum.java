class Solution {
    private void combinations(int pos,int target,List<Integer> curr,int[] candidates,List<List<Integer>> res)
    {
        if (target==0)
        {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target<0 || pos==candidates.length)
            return;

        //pick
        curr.add(candidates[pos]);
        target-=candidates[pos];
        combinations(pos,target,curr,candidates,res);
        curr.remove(curr.size()-1);
        target+=candidates[pos];

        //not pick
        combinations(pos+1,target,curr,candidates,res);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        combinations(0,target,new ArrayList<>(),candidates,res);
        return res;
    }
}