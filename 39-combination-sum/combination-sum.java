class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        helper(res,candidates,target,0,new ArrayList<>(),0);
        return res;
    }

    private void helper(List<List<Integer>> res,int[] candidates,int target,int index,List<Integer> curr,int total)
    {
        if (total==target)
        {
            List<Integer> temp=new ArrayList<>(curr);
            res.add(temp);
            return;
        }

        if (index>=candidates.length || total>target)
            return;

        curr.add(candidates[index]);
        helper(res,candidates,target,index,curr,total+candidates[index]);//consider

        curr.remove(curr.size()-1);
        helper(res,candidates,target,index+1,curr,total);
    }
}