class Solution {
    public void solve(int n,int k,int pos,List<List<Integer>> res,List<Integer> curr)
    {
        if (k==0)
        {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i=pos;i<=n;i++)
        {
            curr.add(i);
            solve(n,k-1,i+1,res,curr);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        solve(n,k,1,res,new ArrayList<>());
        return res;
    }
}