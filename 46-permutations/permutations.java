class Solution {
    public void solve(int pos,List<Integer> curr,List<List<Integer>> res)
    {
        if (pos==curr.size())
        {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i=pos;i<curr.size();i++)
        {
            //swap
            int temp=curr.get(pos);
            curr.set(pos,curr.get(i));
            curr.set(i,temp);
            solve(pos+1,curr,res);

            //swap back
            temp=curr.get(pos);
            curr.set(pos,curr.get(i));
            curr.set(i,temp);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        for (int val: nums)
            curr.add(val);
        solve(0,curr,res);
        return res;
    }
}