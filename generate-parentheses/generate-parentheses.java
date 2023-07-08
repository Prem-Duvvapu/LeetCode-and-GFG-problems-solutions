class Solution {
    private void helper(int n,List<String> res,int open,int close,String curr)
    {
        if (curr.length()==2*n)
        {
            res.add(curr);
            return;
        }

        if (open<n)
            helper(n,res,open+1,close,curr+'(');
        
        if (close<open)
            helper(n,res,open,close+1,curr+')');
    }

    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        helper(n,res,0,0,"");
        return res;
    }
}