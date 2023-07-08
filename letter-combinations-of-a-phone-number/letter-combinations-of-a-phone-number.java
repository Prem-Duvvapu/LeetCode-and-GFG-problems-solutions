class Solution {
    String[] letters={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    private void helper(String digits,List<String> res,int index,String curr)
    {
        if (curr.length()==digits.length())
        {
            res.add(curr);
            return;
        }

        int dgt=digits.charAt(index)-'2';
        for (char ch: letters[dgt].toCharArray())
        {
            curr+=ch;
            helper(digits,res,index+1,curr);
            curr=curr.substring(0,curr.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if (digits.length()==0)
            return res;
        helper(digits,res,0,"");
        return res;
    }
}