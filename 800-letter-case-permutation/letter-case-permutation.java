class Solution {
    private void solve(int pos,String curr,String s,List<String> res)
    {
        if (pos==s.length())
        {
            res.add(new String(curr));
            return;
        }

        if (Character.isDigit(s.charAt(pos)))
            solve(pos+1,curr+s.charAt(pos),s,res);
        else
        {
            solve(pos+1,curr+Character.toLowerCase(s.charAt(pos)),s,res);
            solve(pos+1,curr+Character.toUpperCase(s.charAt(pos)),s,res);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> res=new ArrayList<>();
        solve(0,"",s,res);
        return res;
    }
}