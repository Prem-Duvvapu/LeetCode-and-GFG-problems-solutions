class Solution {
    String[] phone={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public void solve(String digits,int pos,List<String> res,StringBuilder curr)
    {
        if (pos==digits.length())
        {
            res.add(curr.toString());
            return;
        }

        int index=digits.charAt(pos)-'0';
        for (char ch: phone[index].toCharArray())
        {
            curr.append(ch);
            solve(digits,pos+1,res,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();

        if (digits.length()==0)
            return res;

        solve(digits,0,res,new StringBuilder());
        return res;
    }
}