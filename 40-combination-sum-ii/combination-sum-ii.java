class Solution {
    private void combinations(int index,int target,List<Integer> currList,int[] candidates,List<List<Integer>> res)
    {
        if (target==0)
        {
            res.add(new ArrayList<>(currList));
            return;
        }

        if (index==candidates.length || candidates[index]>target)
            return;

        for (int i=index;i<candidates.length;i++)
        {
            if (i>index && candidates[i-1]==candidates[i])
                continue;

            currList.add(candidates[i]);
            combinations(i+1,target-candidates[i],currList,candidates,res);
            currList.remove(currList.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        combinations(0,target,new ArrayList<>(),candidates,res);
        return res;
    }
}