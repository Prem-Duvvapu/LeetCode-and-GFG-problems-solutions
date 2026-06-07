class Solution {
    private final String[] phone={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        solve(0,"",res,digits);
        return res;
    }

    private void solve(int pos,String curr,List<String> res,String digits) {
        if (pos == digits.length()) {
            res.add(new String(curr));
            return;
        }

        int num = digits.charAt(pos) - '0';
        for (char ch: phone[num].toCharArray()) {
            solve(pos+1,curr+ch,res,digits);
        }
    }
}