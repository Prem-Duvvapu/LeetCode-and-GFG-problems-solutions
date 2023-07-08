class Solution {
    String[] letters={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    private void helper(String digits,List<String> res,int index,StringBuilder curr)
    {
        if (curr.length()==digits.length())
        {
            res.add(curr.toString());
            return;
        }

        int dgt=digits.charAt(index)-'2';
        for (char ch: letters[dgt].toCharArray())
        {
            curr.append(ch);
            helper(digits,res,index+1,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if (digits.length()==0)
            return res;
        helper(digits,res,0,new StringBuilder());
        return res;
    }
}