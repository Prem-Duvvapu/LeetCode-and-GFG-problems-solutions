class Solution {
    private void combinations(int n,int k,int pos,List<List<Integer>> res,List<Integer> list)
    {
        if (list.size()==k)
        {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i=pos;i<=n;i++)
        {
            list.add(i);
            combinations(n,k,i+1,res,list);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        combinations(n,k,1,res,new ArrayList<>());
        return res;
    }
}