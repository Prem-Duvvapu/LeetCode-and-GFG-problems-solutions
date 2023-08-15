class Solution {
    private void solve(int pos,StringBuilder curr,String s,List<String> res)
    {
        if (pos==s.length())
        {
            String sub=curr.toString();
            res.add(sub);
            return;
        }

        if (Character.isDigit(s.charAt(pos)))
        {
            char ch=s.charAt(pos);
            curr.append(ch);
            solve(pos+1,curr,s,res);
            curr.deleteCharAt(curr.length()-1);
        }
        else
        {
            char ch=s.charAt(pos);
            curr.append(Character.toLowerCase(ch));
            solve(pos+1,curr,s,res);
            curr.deleteCharAt(curr.length()-1);
            curr.append(Character.toUpperCase(ch));
            solve(pos+1,curr,s,res);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> res=new ArrayList<>();
        solve(0,new StringBuilder(),s,res);
        return res;
    }
}