class Solution {
    private void helper(int n,List<String> res,int open,int close,StringBuilder curr)
    {
        if (curr.length()==2*n)
        {
            res.add(curr.toString());
            return;
        }

        if (open<n)
        {
            curr.append('(');
            helper(n,res,open+1,close,curr);
            curr.deleteCharAt(curr.length()-1);
        }
        
        if (close<open)
        {
            curr.append(')');
            helper(n,res,open,close+1,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        helper(n,res,0,0,new StringBuilder());
        return res;
    }
}