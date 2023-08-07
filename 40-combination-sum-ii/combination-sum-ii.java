//Striver's approach

class Solution {
    private void combinations(int pos,int target,List<Integer> curr,int[] candidates,List<List<Integer>> res)
    {
        if (target==0)
        {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i=pos;i<candidates.length;i++)
        {
            if (i>pos && (candidates[i]==candidates[i-1]))
                continue;

            if (candidates[i]>target)
                break;

            curr.add(candidates[i]);
            combinations(i+1,target-candidates[i],curr,candidates,res);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        combinations(0,target,new ArrayList<>(),candidates,res);
        return res;
    }
}