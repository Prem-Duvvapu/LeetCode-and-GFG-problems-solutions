class Solution {
    String[] letters={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    private void helper(String digits,List<String> res,int position,StringBuilder sb)
    {
        if (sb.length()==digits.length())
        {
            res.add(sb.toString());
            return;
        }

        int index=digits.charAt(position)-'2';
        for (char ch: letters[index].toCharArray())
        {
            sb.append(ch);
            helper(digits,res,position+1,sb);
            sb.deleteCharAt(sb.length()-1);
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